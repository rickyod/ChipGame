/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.level;

import chipgame.tiles.Tile;
import java.awt.Point;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Kelas Levels mengatur jalannya level dan memiliki list dari semua level.
 * 
 * @author Riky Setiawan 2013730041
 * @author Devi Handevi 2013730015
 */
public class Levels {
    
    /**
     * Attribute linked list of all stages.
     */
    private LinkedList<Level> listLevel;
    /**
     * Attribute current level.
     */
    private Level currentLevel;
    /**
     * Attribute list iterator of list level.
     */
    private ListIterator li;
    
    /**
     * Constructor untuk menginisialisasi seluruh level.
     */
    public Levels() {
        this.listLevel = new LinkedList<Level>();
        this.listLevel.add(new Level1());
        this.listLevel.add(new Level2());
        this.listLevel.add(new Level3());
        this.li = this.listLevel.listIterator();
        this.currentLevel = (Level)this.li.next();
    }
    
    /**
     * Method untuk mendapatkan jumlah IC yang diperlukan untuk level yang sekarang.
     * @return jumlah IC yang diperlukan
     */
    public int getICRequired() {
        return this.currentLevel.getICRequired();
    }
    
    /**
     * Method untuk mendapatkan map untuk level yang sekarang.
     * @return map
     */
    public Tile[][] getMap() {
        return this.currentLevel.getMap();
    }
    
    /**
     * Method untuk mendapatkan posisi awal chip pada level sekarang.
     * @return posisi awal chip
     */
    public Point getInitialChipCoordinate() {
        return this.currentLevel.getInitialChipCoordinate();
    }
    
    /**
     * Method untuk meneruskan ke level selanjutnya.
     * @return true jika berhasil
     */
    public boolean goToTheNextLevel() {
        if(li.hasNext()) {
            this.currentLevel = (Level)this.li.next();
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method untuk mereset level sekarang.
     */
    public void resetLevel() {
        this.currentLevel.createMap();
    }
}
