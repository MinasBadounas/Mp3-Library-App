/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp3library.assignment.repositories;

import com.mp3library.assignment.entities.Songfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author minas
 */
@Repository
public interface Mp3repository extends JpaRepository<Songfile,Integer>  {
    
}
