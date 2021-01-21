/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.raf.main;

import edu.raf.database.KingsBarbershopDatabase;
import edu.raf.entity.Pelanggan;
import edu.raf.error.PelangganException;
import edu.raf.service.PelangganDao;
import edu.raf.view.MainViewPelanggan;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author RAF
 * NIM      : 10119077
 * NAMA     : RIDHWAN ANWAR FAUZAN
 * KELAS    : IF - 2
 */
public class LatihanCRUDMVCDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, PelangganException {
        // TODO code application logic here

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                   MainViewPelanggan pelanggan = new MainViewPelanggan();
                   pelanggan.loadDatabase();
                   pelanggan.setVisible(true);
                } catch (SQLException e) {
                } catch (PelangganException ex) {
                    Logger.getLogger(LatihanCRUDMVCDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
                
            }
        });
        
                
        
    }
    
}
