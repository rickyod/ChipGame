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
     * Attribut width dari map.
     */
    protected int width;
    /**
     * Attribut length dari map.
     */
    protected int length;
    /**
     * Attribute the next level of the current level.
     */
    protected Level nextLevel;
    
    //Objek - objek chipgame.tiles
    
    /**
     * Attribute objek dari kelas
     */
    protected Barrier barrier = new Barrier();
    /**
     * Attribute objek dari kelas
     */
    protected Door redDoor = new Door(Color.red);
    /**
     * Attribute objek dari kelas
     */
    protected Door greenDoor = new Door(Color.green);
    /**
     * Attribute objek dari kelas
     */
    protected Door blueDoor = new Door(Color.blue);
    /**
     * Attribute objek dari kelas
     */
    protected Door yellowDoor = new Door(Color.yellow);
    /**
     * Attribute objek dari kelas
     */
    protected Key redKey = new Key(Color.red);
    /**
     * Attribute objek dari kelas
     */
    protected Key greenKey = new Key(Color.green);
    /**
     * Attribute objek dari kelas
     */
    protected Key blueKey = new Key(Color.blue);
    /**
     * Attribute objek dari kelas
     */
    protected Key yellowKey = new Key(Color.yellow);
    /**
     * Attribute objek dari kelas
     */
    protected Finish finish = new Finish();
    /**
     * Attribute objek dari kelas
     */
    protected Fire fire = new Fire();
    /**
     * Attribute objek dari kelas
     */
    protected IntegratedCircuit IC = new IntegratedCircuit();
    /**
     * Attribute objek dari kelas
     */
    protected Wall wall = new Wall();
    
    
    
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
