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
     * Attribut lebar dari map.
     */
    protected int width;
    /**
     * Attribut panjang dari map.
     */
    protected int length;
    /**
     * Attribute the next level of the current level.
     */
    protected Level nextLevel;
    
    //Objek - objek chipgame.tiles
    
    /**
     * Attribute objek barrier dari kelas
     */
    protected Barrier barrier;
    /**
     * Attribute objek dari kelas
     */
    protected Door redDoor;
    /**
     * Attribute objek dari kelas
     */
    protected Door greenDoor;
    /**
     * Attribute objek dari kelas
     */
    protected Door blueDoor;
    /**
     * Attribute objek dari kelas
     */
    protected Door yellowDoor;
    /**
     * Attribute objek dari kelas
     */
    protected Key redKey;
    /**
     * Attribute objek dari kelas
     */
    protected Key greenKey;
    /**
     * Attribute objek dari kelas
     */
    protected Key blueKey;
    /**
     * Attribute objek dari kelas
     */
    protected Key yellowKey;
    /**
     * Attribute objek dari kelas
     */
    protected Finish finish = new Finish();
    /**
     * Attribute objek dari kelas
     */
    protected Fire fire;
    /**
     * Attribute objek dari kelas
     */
    protected IntegratedCircuit IC;
    /**
     * Attribute objek dari kelas
     */
    protected Wall wall;
    
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
        this.finish = new Finish();
        this.fire = new Fire();
        this.IC = new IntegratedCircuit();
        this.wall = new Wall();
    }
    
    
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
    public abstract Point getChipCoordinate();
    
    /**
     * Method untuk membuat map pada level.
     */
    public abstract void createMap() ;
    
    /**
     * Method untuk mendapatkan level selanjutnya
     * @return 
     */
    public abstract Level getNextLevel();

    
}
