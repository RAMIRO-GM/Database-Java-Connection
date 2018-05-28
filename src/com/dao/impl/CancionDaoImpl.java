
package com.dao.impl;

import com.dao.IcancionesDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utileria.Cancion;


public class CancionDaoImpl implements IcancionesDao{
    
Connection conexion;
    private void conexion(){
        try{
        String cadenaConexion="jdbc:mysql://localhost:3306/spotifydb?useSSL=false";
        String usuario="root";
        String passDB="123456";
        Connection conexion=DriverManager.getConnection(cadenaConexion,usuario,passDB);
        
        }catch(SQLException ex){
        ex.printStackTrace();
        }
        }
    
    @Override
    public boolean Create(Cancion entidad) throws SQLException {
        conexion();
        String insertCancion="INSERT INTO canciones"+"(nombre,artista) VALUES (? ,?)";

        PreparedStatement stm=conexion.prepareStatement(insertCancion);
        //recupero el nombre
        stm.setString(1,entidad.getNombre());
        stm.setString(2,entidad.getArtista());
        stm.close();
        boolean ejecutado=stm.executeUpdate()>0;
        
        conexion.close();
        return ejecutado;
        
    }

    @Override
    public List<Cancion> read() throws SQLException{
         
         List<Cancion> cancionesLista=new ArrayList<>();
         String leerQuery="SELECT*FROM canciones";
         
         conexion();//conecta
         Statement sentencia=conexion.createStatement(); //jala loque tiene
         ResultSet resultado=sentencia.executeQuery(leerQuery); //ejecuta el query que le puse
       
         //mientras haya algo guardado en la siguiente prosicion
        while (resultado.next()){
         //tomamos el resultset que es la manera en que obtenemos el resultado de la  base de datos
         //de maneria resultado.getInt(getRypodedato)
         Cancion cancion=new Cancion();
         cancion.setNum_cancion(resultado.getInt(1));
         cancion.setNombre(resultado.getString(2));
         cancion.setArtista(resultado.getString(3));
         //lo agrego en la lista
         cancionesLista.add(cancion);
            }
        resultado.close();
        sentencia.close();
        conexion.close();
        return cancionesLista;
    }

    @Override
    public boolean update(Cancion entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int num_cancion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
