/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp3library.assignment.controller;

import com.mp3library.assignment.entities.Songfile;
import com.mp3library.assignment.service.Mp3service;
import com.mp3library.assignment.utilities.util;
import static com.mp3library.assignment.utilities.util.multipartToFile;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author minas
 */
@Controller
public class Mp3controller {

    @Autowired
    Mp3service mp3service;

    @Autowired
    util util1;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String indexPage(ModelMap mm, RedirectAttributes ra, @ModelAttribute("lyrics") String lyrics) {
        mm.put("mp3list", mp3service.listMp3());
        mm.addAttribute("lyrics", lyrics);
        Songfile newSongfile = new Songfile();
        ra.addAttribute("newsong", newSongfile);
        return "view";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadSongPage(ModelMap mm, @RequestParam(value = "song", required = false) MultipartFile song, @ModelAttribute("newSongfile") Songfile newSongfile) {

        try {
            newSongfile = multipartToFile(song, song.getOriginalFilename());
        } catch (IllegalStateException ex) {
            Logger.getLogger(Mp3controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mp3controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        mp3service.uploadSong(newSongfile);
        return "redirect:/view";
    }

    @RequestMapping(value = "/lyrics", params = {"artist", "title"}, method = RequestMethod.GET)
    public String lyricsPage(ModelMap mm, RedirectAttributes ra, @RequestParam("artist") String artist, @RequestParam("title") String title) throws IOException {

        try {

            String surl = "https://api.lyrics.ovh/v1/" + artist + "/" + title;
            URL url = new URL(surl.replace("\"", "%22").replace(" ", "%20"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");

            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: “ +responsecode");
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String temp;
                String lyrics = "";

                while ((temp = br.readLine()) != null) {
                    lyrics = lyrics.concat(temp);
                }
                conn.disconnect();

                lyrics = lyrics.replace("\\n", "<br />");
                lyrics = lyrics.substring(10);
                lyrics = lyrics.replace("}", "");
                ra.addAttribute("lyrics", lyrics);

            }

        } catch (IOException ex) {
            Logger.getLogger(Mp3controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/view";

    }

    @RequestMapping(value = "/download", params = {"id"}, method = RequestMethod.GET)
    public void downloadMp3(ModelMap mm,HttpServletResponse response, @RequestParam("id") Integer id) {

        Songfile downloadedSong = mp3service.downloadSong(id);

        response.setContentType("audio/mp3");
        response.setHeader("Content-Disposition", "attachment; filename=" + downloadedSong.getTitle() +".mp3");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            outputStream.write(downloadedSong.getMp3file());
        } catch (IOException ex) {
            Logger.getLogger(Mp3controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        final byte[] bytes = outputStream.toByteArray();
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
      
        OutputStream os=null;
        try {
            os =response.getOutputStream();
        } catch (IOException ex) {
            Logger.getLogger(Mp3controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            os.write(bytes);
           
        } catch (IOException ex) {
            Logger.getLogger(Mp3controller.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        try {
            os.flush();
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(Mp3controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            

        }


    }

