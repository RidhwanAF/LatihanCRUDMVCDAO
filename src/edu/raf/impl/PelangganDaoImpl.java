/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.raf.impl;

import edu.raf.entity.Pelanggan;
import edu.raf.error.PelangganException;
import edu.raf.service.PelangganDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RAF
 * NIM      : 10119077
 * NAMA     : RIDHWAN ANWAR FAUZAN
 * KELAS    : IF - 2
 */
public class PelangganDaoImpl implements PelangganDao{

    private Connection connection;

    private final String insertPelanggan = "INSERT INTO PELANGGAN (NAMA,ALAMAT,TELEPON,EMAIL) VALUES (?,?,?,?)";
    
    private final String updatePelanggan = "UPDATE PELANGGAN SET NAMA=?, ALAMAT=?, TELEPON=?, EMAIL=? WHERE ID=?";
    
    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID=?";
    
    private final String getById = "SELECT * FROM PELANGGAN WHERE ID=?";
    
    private final String getByEmail = "SELECT * FROM PELANGGAN WHERE EMAIL=?";
    
    private final String selectAll = "SELECT * FROM PELANGGAN";
    
    public PelangganDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    
    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(insertPelanggan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,pelanggan.getNama());
            statement.setString(2,pelanggan.getAlamat());
            statement.setString(3,pelanggan.getTelepon());
            statement.setString(4,pelanggan.getEmail());
            statement.executeUpdate();
            
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                pelanggan.setId(result.getInt(1));
            }
            
            connection.commit();
            
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            if (statement!=null){
                try {
                 statement.close();
                } catch (SQLException e){
                }
            }
        }
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(updatePelanggan);
            statement.setString(1,pelanggan.getNama());
            statement.setString(2,pelanggan.getAlamat());
            statement.setString(3,pelanggan.getTelepon());
            statement.setString(4,pelanggan.getEmail());
            statement.setInt(5,pelanggan.getId());
            statement.executeUpdate();
            
            connection.commit();
            
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            if (statement!=null){
                try {
                 statement.close();
                } catch (SQLException e){
                }
            }
        }
    }

    @Override
    public void deletePelanggan(Integer Id) throws PelangganException {
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(deletePelanggan);
            statement.setInt(1, Id);
            statement.executeUpdate();
            
            connection.commit();
            
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            if (statement!=null){
                try {
                 statement.close();
                } catch (SQLException e){
                }
            }
        }
    }

    @Override
    public Pelanggan getPelanggan(Integer Id) throws PelangganException {
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(getById);
            statement.setInt(1, Id);
            
            ResultSet result=statement.executeQuery();
            Pelanggan pelanggan=null;
            
            if (result.next()){
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
            } else{
                throw new PelangganException("Pelanggan dengan id "+Id+" tidak ditemukan");
            }
            connection.commit();
            return pelanggan;
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            if (statement!=null){
                try {
                 statement.close();
                } catch (SQLException e){
                }
            }
        }
    }

    @Override
    public Pelanggan getPelanggan(String email) throws PelangganException {
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(getByEmail);
            statement.setString(1, email);
            
            ResultSet result=statement.executeQuery();
            Pelanggan pelanggan=null;
            
            if (result.next()){
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
            } else{
                throw new PelangganException("Pelanggan dengan id "+email+" tidak ditemukan");
            }
            connection.commit();
            return pelanggan;
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            if (statement!=null){
                try {
                 statement.close();
                } catch (SQLException e){
                }
            }
        }
    }

    @Override
    public List<Pelanggan> selectAllPelanggan() throws PelangganException {
        Statement statement = null;
        List<Pelanggan> list=new ArrayList<Pelanggan>();
        
        
        try{
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            
            ResultSet result=statement.executeQuery(selectAll);
            Pelanggan pelanggan=null;
            
            while (result.next()){
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                list.add(pelanggan);
            }
            connection.commit();
            return list;
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            if (statement!=null){
                try {
                 statement.close();
                } catch (SQLException e){
                }
            }
        }
    }
    
    
    
}
