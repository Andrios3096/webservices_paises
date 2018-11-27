/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leandro.webservice;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrios
 */
public class ConectionMysql {
    
    CallableStatement procedure;
    String execsql = "{call obtenerPaises}";
    Connection sql;
    ResultSet mdatabase;
    
    public Connection connection() {
        Connection mysql = null;
        try {
            mysql = DriverManager.getConnection(
                    
                    "jdbc:mysql://localhost/" + "latinoamerica" + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    ""                  
            );
        } 
        catch (SQLException exception) {
            
            System.out.println("error");
    
            }
        return mysql;
        
    }
    
    public List<Paises> ListaPaises(){
        List<Paises> listapaises = new ArrayList();
        
        try {
            sql = connection();
            procedure = sql.prepareCall(execsql);
            mdatabase = procedure.executeQuery();
            
            while (mdatabase.next()) {
                Paises paises = new Paises();
                paises.setId(mdatabase.getInt("id"));
                paises.setNombre(mdatabase.getString("nombre"));
                listapaises.add(paises);
            }
            
        }
        catch (SQLException exception) {
            System.out.println("error");
        }
        System.out.println(listapaises.size());
        return listapaises;
    }
    
}
