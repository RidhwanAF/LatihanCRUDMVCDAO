/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.raf.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.raf.impl.PelangganDaoImpl;
import edu.raf.service.PelangganDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author RAF
 * NIM      : 10119077
 * NAMA     : RIDHWAN ANWAR FAUZAN
 * KELAS    : IF - 2
 */
public class KingsBarbershopDatabase {
    
    private static Connection connection;
    private static PelangganDao pelangganDao;
    
    public static Connection getConnection() throws SQLException{
        if (connection==null){
            
            MysqlDataSource dataSource=new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/kingsbarbershop");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
    
    
    return connection;
    }
    
    public static PelangganDao getPelangganDao() throws SQLException{
        if(pelangganDao==null){
            pelangganDao = new PelangganDaoImpl(getConnection());
        }
    return pelangganDao;
    }
}
