/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Giovani dos Santos
 */
public class Conexao {
    
    public Connection carrega() throws SQLException{
     Connection con = null;   
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persom?zeroDateTimeBehavior=convertToNull", "root", "");
           
      return con;
         
    }
    
}
