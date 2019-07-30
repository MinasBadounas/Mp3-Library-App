/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp3library.assignment.service;

import com.mp3library.assignment.entities.Songfile;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mp3library.assignment.repositories.Mp3repository;
import java.awt.image.BufferedImage;
import static org.apache.tomcat.util.codec.binary.Base64.encodeBase64String;
import sun.misc.BASE64Decoder;


/**
 *
 * @author minas
 */
@Service
public class Mp3service {

    @Autowired
    private Mp3repository mp3Repo;

    public List<Songfile> listMp3() {
        
        List<Songfile> songList = mp3Repo.findAll();
        
        for (int i = 0; i < songList.size(); i++) {

            BufferedImage image = null;
            byte[] imageByte=null;
            BASE64Decoder decoder = new BASE64Decoder();
            
            String encodedImage = encodeBase64String(songList.get(i).getImagealbum());
            songList.get(i).setMp3filename(encodedImage);

        }
        return songList;
    }
    
     public Songfile downloadSong(Integer id) {
       Songfile downloadedSong= mp3Repo.findById(id).get();
        return downloadedSong;
    }

    public void uploadSong(Songfile song) {
        mp3Repo.save(song);
    }

}
