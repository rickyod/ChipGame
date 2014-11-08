/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Image;

/**
 * Kelas abstract untuk merepresentasikan objek yang dapat ditaruh di ubin.
 * @author Devi Handevi 2013730015
 * @author Riky Setiawan
 */
public abstract class TileObject implements Drawable{

    /**
     * Attribute untuk menyimpan gambar.
     */
    protected Image[] image;
    
    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     * @return
     * -1 objek tidak dapat diinjak, 
     * 0 objek dapat langsung diinjak, 
     * 1 dapat diinjak, tetapi jika terinjak, pengingjak akan mati dan permainan berakhir, 
     * 2 dapat diinjak, jika terinjak, penginjak menang dan permainan berakhir, 
     * 3 dapat diinjak, tetapi harus ada pengecekan terlebih dahulu apakah persyaratan penginjak memenuhi atau tidak.
     */
    public abstract int canBeStepped();

    /**
     * Method untuk mengecek apakah objek ini dapat diambil atau tidak.
     * @return true jika objek dapat diambil, false jika sebaliknya
     */
    public abstract boolean canBeTaken();
}
