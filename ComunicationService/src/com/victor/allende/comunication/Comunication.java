/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.victor.allende.comunication;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allen
 */
public class Comunication {

    private PreparedStatement ps = null;
    private Statement st = null;
    private Connection con = null;

    public void realizaConexion() {

        String urlDatabase = "jdbc:postgresql://localhost:5433/ddbb_apk";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(urlDatabase, "victor", "cometa");
        } catch (Exception e) {
            System.out.println("Ocurrio un error : " + e.getMessage());
        }
        System.out.println("La conexión se realizo sin problemas! =) ");
    }

    public void insert() {

        String stm = "INSERT INTO users (name_user, pw_password) VALUES(?, ?)";
        try {
            ps = con.prepareStatement(stm);
            ps.setString(1, "usuario ");
            ps.setString(2, "alguna más");

           
            int resul =  ps.executeUpdate();
            System.out.println("se ha insertado : "+resul+" fila");
        } catch (SQLException ex) {
            System.out.println("Error SQL " +ex);       
        }
    }

    public static void main(String[] args) {

        Comunication c = new Comunication();
        c.realizaConexion();
        c.insert();
    }
}
