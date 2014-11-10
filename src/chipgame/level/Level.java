/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chipgame.level;

import chipgame.tiles.*;
import java.awt.Color;
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
     * Attribute sepatu merah.
     */
    protected Shoes redShoes;
    /**
     * Attribute sepatu biru.
     */
    protected Shoes blueShoes;
    
    public Level() {
        this.barrier = new Barrier();
        this.redDoor = new Door(Color.red);
        this.greenDoor = new Door(Color.green);
        this.blueDoor = new Door(Color.blue);
        this.yellowDoor = new Door(Color.yellow);
        this.redKey = new Key(Color.red);
        this.greenKey = new Key(Color.green);
        this.blueKey = new Key(Color.blue);
        this.yellowKey = new Key(Color.yellow);
        this.IC = new IntegratedCircuit();
        this.wall = new Wall();
        this.redShoes = new Shoes(Color.red);
        this.blueShoes = new Shoes(Color.blue);
    }
    
    /**
     * Method untuk mendapatkan array of tile , array 2 dimensi dari map.
     * @return 
     */
    public Tile[][] getMap() {
        return this.tiles;
    }
    
    /**
     * Method untuk mendapatkan IC yang dibutuhkan pada map.
     * @return int jumlah IC
     */
    public int getICRequired() {
        return this.ICRequired;
    }
    
    /**
     * Method untuk mendapatkan lebar map.
     * @return int jumlah IC
     */
    public int getWidth() {
        return this.width;
    }
    
    /**
     * Method untuk mendapatkan panjang map.
     * @return int jumlah IC
     */
    public int getLength() {
        return this.length;
    }
            
    /**
     * Method untuk mendapatkan koordinat pertama chip.
     */
    public abstract Point getInitialChipCoordinate();
    
    /**
     * Method untuk membuat map pada level.
     */
    protected abstract void createMap();
    
    /**
     * Method untuk menginisialisasi level.
     */
    public abstract void initializeLevel();
}
