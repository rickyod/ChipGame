/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chipgame.level;

import chipgame.tiles.*;
import java.awt.Point;

/**
 * Kelas abstract Level , sebagai template dari sebuah level.
 * 
 * @author Riky Setiawan 2013730041
 * @author Devi Handevi 2013730015
 */
public abstract class Level {
    /**
     * Attribute untuk menyimpan tiles.
     */
    protected Tile[][] tiles;
    /**
     * Attribute lebar dari map.
     */
    protected int width;
    /**
     * Attribute panjang dari map.
     */
    protected int length;
    /**
     * Attribute banyak IC yang dibutuhkan.
     */
    protected int ICRequired;
    
    //Objek - objek chipgame.tiles
    /**
     * Attribute barrier.
     */
    protected Barrier barrier;
    /**
     * Attribute pintu merah.
     */
    protected Door redDoor;
    /**
     * Attribute pintu hijau.
     */
    protected Door greenDoor;
    /**
     * Attribute pintu biru.
     */
    protected Door blueDoor;
    /**
     * Attribute pintu kuning.
     */
    protected Door yellowDoor;
    /**
     * Attribute kunci merah.
     */
    protected Key redKey;
    /**
     * Attribute kunci hijau.
     */
    protected Key greenKey;
    /**
     * Attribute kunci biru.
     */
    protected Key blueKey;
    /**
     * Attribute kunci kuning.
     */
    protected Key yellowKey;
    /**
     * Attribute IC.
     */
    protected IntegratedCircuit IC;
    /**
     * Attribute dinding.
     */
    protected Wall wall;
    /**
     * Attribute finish.
     */
    protected Finish finish;
    /**
     * Attribute sepatu merah.
     */
    protected Shoes redShoes;
    /**
     * Attribute sepatu biru.
     */
    protected Shoes blueShoes;
    
    /**
     * Constructor untuk membuat abstract kelas yang merepresentasikan level.
     */
    public Level() {
        this.wall = new Wall();
        this.barrier = new Barrier();
        this.IC = new IntegratedCircuit();
        this.finish = new Finish();
        this.initializeLevel();
    }
    
    /**
     * Method untuk mendapatkan array of tile, array 2 dimensi dari peta.
     * @return peta level
     */
    public Tile[][] getMap() {
        return this.tiles;
    }
    
    /**
     * Method untuk mendapatkan IC yang dibutuhkan pada level.
     * @return int jumlah IC
     */
    public int getICRequired() {
        return this.ICRequired;
    }
    
    /**
     * Method untuk mendapatkan koordinat awal chip
     * @return koordinat awal chip
     */
    public abstract Point getInitialChipCoordinate();
    
    /**
     * Method untuk membuat peta pada level.
     */
    protected abstract void createMap();
    
    /**
     * Method untuk menginisialisasi level.
     */
    public abstract void initializeLevel();
    
    /**
     * Method untuk men-load attribute-attribute yang diperlukan level.
     */
    protected abstract void loadAttributesNeeded();
}
