/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.SQLException;
import java.util.List;
import utileria.Cancion;

/**
 *
 * @author Ramirito
 */
public interface IcancionesDao {
    //entidad de tipo cancion que es el objeto
    boolean Create(Cancion entidad)throws SQLException ;
    List<Cancion> read()throws SQLException;    
    boolean update(Cancion entidad);
    boolean delete(int num_cancion);
    
    
}
