/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leandro.webservice;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
/**
 *
 * @author Andrios
 */
@WebService
public class BuscadorPaises {
    
    @WebMethod
    
    public int metodo(){
    ConectionMysql conexion = new ConectionMysql();
    return conexion.ListaPaises().size();
    }
}
