/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.dao.impl.CancionDaoImpl;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import utileria.Cancion;

public class Principal {
    
    public static void main (String [] args) throws SQLException{
    Scanner scan=new Scanner(System.in);
    boolean flag=true;
    while (flag){
    System.out.println("Ingresa la opcion que deseees :D ");
    System.out.println("1.-> Crear nueva canción ");
    System.out.println("2.-> Mostarr canciones ");
    System.out.println("3.-> Actualizar canción ");
    System.out.println("4.-> Eliminar nueva canción ");
    System.out.println("5.-> Salir ");
    int opcion=scan.nextInt();
    flag=eleccion(opcion);
    
    }
     System.out.println("Gracias por participar ");
     
    }
    
     private static boolean eleccion(int opcion) throws SQLException{
        Scanner scan=new Scanner(System.in);
        
        Cancion cancion=new Cancion();
        CancionDaoImpl cancionDao= new CancionDaoImpl();
          boolean resultado=true;
       switch(opcion){
           case 1:
               System.out.println("Ingresa el nombre de la cancion: ");
               String nombre_cancion=scan.nextLine();
               System.out.println("Ingresa el nombre del artista: ");
               String nombre_artista=scan.nextLine();
               cancion.setNombre(nombre_cancion);
               cancion.setArtista(nombre_artista);
               resultado=cancionDao.Create(cancion);
               
               if (resultado){
                System.out.println("Ingresa el nombre del artista: ");
               }
               else{
                System.out.println("Ingresa el nombre del artista: ");
                   }
               
               break;
           case 2: 
               List<Cancion> cancionesLista=cancionDao.read();
               for(Cancion i:cancionesLista ){
                System.out.println("Id: "+i.getNum_cancion()+"Nombre: "+i.getArtista()+"Artista: "+i.getArtista());
               }
               break;
           case 3: break;
           case 4: break;
           case 5: 
               resultado=false;
               break;
    } 
      return resultado;
    }
}
