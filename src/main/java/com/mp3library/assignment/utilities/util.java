/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp3library.assignment.utilities;

import com.mp3library.assignment.entities.Songfile;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.datatype.Artwork;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author minas
 */
@Component
public class util {

    public static Songfile multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {

        Songfile newSongfile = new Songfile();
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
        multipart.transferTo(convFile);

        AudioFile f = null;
        try {
            f = AudioFileIO.read(convFile);
        } catch (CannotReadException ex) {
            Logger.getLogger(util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.jaudiotagger.tag.TagException ex) {
            Logger.getLogger(util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ReadOnlyFileException ex) {
            Logger.getLogger(util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAudioFrameException ex) {
            Logger.getLogger(util.class.getName()).log(Level.SEVERE, null, ex);
        }

        org.jaudiotagger.tag.Tag tag = f.getTag();

        String artist = tag.getFirst(FieldKey.ARTIST);
        String album = tag.getFirst(FieldKey.ALBUM);
        String title = tag.getFirst(FieldKey.TITLE);
        String year = tag.getFirst(FieldKey.YEAR);
        byte[] artworkArr = tag.getFirstArtwork().getBinaryData();
        byte[] byteArr = multipart.getBytes();

        newSongfile.setAlbum(album);
        newSongfile.setArtist(artist);
        newSongfile.setTitle(title);
        newSongfile.setYearrelease(year);
        newSongfile.setMp3file(byteArr);
        newSongfile.setImagealbum(artworkArr);

        return newSongfile;
    }

}
