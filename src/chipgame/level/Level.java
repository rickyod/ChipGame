/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chipgame.level;

import chipgame.tiles.Tile;
import java.awt.Point;

/**
 *
 * @author ASUS
 */
public abstract class Level {
    /**
     * Attribute untuk menyimpan tiles.
     */
    protected Tile[][] tiles;
    /**
     * Attribut width dari map.
     */
    protected int width;
    /**
     * Attribut length dari map.
     */
    protected int length;
    
    /**
     * Method untuk mendapatkan array of tile , array 2 dimensi dari map.
     * @return 
     */
    public abstract Tile[][] getMap();
    
    /**
     * Method untuk mendapatkan IC yang dibutuhkan pada map.
     * @return int jumlah IC
     */
    public abstract int getICRequired();
    
    /**
     * Method untuk mendapatkan lebar map.
     * @return int jumlah IC
     */
    public abstract int getWidth();
    
    /**
     * Method untuk mendapatkan panjang map.
     * @return int jumlah IC
     */
    public abstract int getLength();
            
    /**
     * Method untuk mendapatkan koordinat pertama chip.
     */
    public abstract Point getCoordinateChip();
}
