/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.raf.event;

import edu.raf.entity.Pelanggan;
import edu.raf.model.PelangganModel;

/**
 *
 * @author RAF
 * NIM      : 10119077
 * NAMA     : RIDHWAN ANWAR FAUZAN
 * KELAS    : IF - 2
 */
public interface PelangganListener {
    
    public void onChange(PelangganModel model);
    public void onInsert(Pelanggan pelanggan);
    public void onDelete();
    public void onUpdate(Pelanggan pelanggan);
    
}
