/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.raf.service;

import edu.raf.entity.Pelanggan;
import edu.raf.error.PelangganException;
import java.util.List;

/**
 *
 * @author RAF
 * NIM      : 10119077
 * NAMA     : RIDHWAN ANWAR FAUZAN
 * KELAS    : IF - 2
 */
public interface PelangganDao {
    
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException;
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException;
    public void deletePelanggan(Integer Id) throws PelangganException;
    public Pelanggan getPelanggan(Integer Id) throws PelangganException;
    public Pelanggan getPelanggan(String email) throws PelangganException;
    public List<Pelanggan> selectAllPelanggan() throws PelangganException;
    
}
