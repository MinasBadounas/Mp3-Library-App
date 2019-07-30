/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp3library.assignment.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author minas
 */
@Entity
@Table(name = "songfile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Songfile.findAll", query = "SELECT s FROM Songfile s")
    , @NamedQuery(name = "Songfile.findById", query = "SELECT s FROM Songfile s WHERE s.id = :id")
    , @NamedQuery(name = "Songfile.findByTitle", query = "SELECT s FROM Songfile s WHERE s.title = :title")
    , @NamedQuery(name = "Songfile.findByAlbum", query = "SELECT s FROM Songfile s WHERE s.album = :album")
    , @NamedQuery(name = "Songfile.findByArtist", query = "SELECT s FROM Songfile s WHERE s.artist = :artist")
    , @NamedQuery(name = "Songfile.findByYearrelease", query = "SELECT s FROM Songfile s WHERE s.yearrelease = :yearrelease")})
public class Songfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "album")
    private String album;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "artist")
    private String artist;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "yearrelease")
    private String yearrelease;
    @Lob
    @Column(name = "mp3file")
    private byte[] mp3file;
    @Lob
    @Column(name = "imagealbum")
    private byte[] imagealbum;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "mp3filename")
    private String mp3filename;

    public Songfile() {
    }

    public Songfile(Integer id) {
        this.id = id;
    }

    public Songfile(Integer id, String title, String album, String artist, String yearrelease) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.yearrelease = yearrelease;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYearrelease() {
        return yearrelease;
    }

    public void setYearrelease(String yearrelease) {
        this.yearrelease = yearrelease;
    }

    public byte[] getMp3file() {
        return mp3file;
    }

    public void setMp3file(byte[] mp3file) {
        this.mp3file = mp3file;
    }

    public byte[] getImagealbum() {
        return imagealbum;
    }

    public void setImagealbum(byte[] imagealbum) {
        this.imagealbum = imagealbum;
    }

    public String getMp3filename() {
        return mp3filename;
    }

    public void setMp3filename(String mp3filename) {
        this.mp3filename = mp3filename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Songfile)) {
            return false;
        }
        Songfile other = (Songfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mp3library.assignment.entities.Songfile[ id=" + id + " ]";
    }
    
}
