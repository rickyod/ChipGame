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
 * Kelas level 3.
 * 
 * @author Riky Setiawan 2013730041
 * @author Devi Handevi 2013730015
 */
public class Level3 extends Level {
    
    /**
     * Method untuk menginisialisasi level.
     */
    @Override
    public void initializeLevel() {
        this.width = 19;
        this.length = 19;
        this.ICRequired = 6;
        this.tiles = new Tile[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
        this.loadAttributesNeeded();
        this.createMap();
    }
    
    /**
     * Method untuk men-load attribute-attribute yang diperlukan level.
     */
    @Override
    protected void loadAttributesNeeded() {
        this.redDoor = new Door(Color.red);
        this.redKey = new Key(Color.red);
        this.yellowDoor = new Door(Color.yellow);
        this.yellowKey = new Key(Color.yellow);
        this.redShoes = new Shoes(Color.red);
    }

    /**
     * Method untuk membuat peta pada level.
     */
    @Override
    protected void createMap() {
        //Water
        this.tiles[4][10].setObject(new Water());
        this.tiles[12][7].setObject(new Water());
        this.tiles[12][11].setObject(new Water());
        this.tiles[13][5].setObject(new Water());
        this.tiles[13][9].setObject(new Water());
        this.tiles[13][13].setObject(new Water());
        this.tiles[14][6].setObject(new Water());
        this.tiles[14][8].setObject(new Water());
        this.tiles[14][10].setObject(new Water());
        this.tiles[14][12].setObject(new Water());
        //Wall
        for (int i = 4; i <= 9; i++) {
            this.tiles[4][i].setObject(this.wall);
        }
        for (int i = 11; i <= 14; i++) {
            this.tiles[4][i].setObject(this.wall);
        }
        for (int i = 5; i <= 14; i++) {
            this.tiles[i][4].setObject(this.wall);
        }
        this.tiles[14][5].setObject(this.wall);
        this.tiles[14][7].setObject(this.wall);
        this.tiles[14][9].setObject(this.wall);
        this.tiles[14][11].setObject(this.wall);
        this.tiles[14][13].setObject(this.wall);
        for (int i = 5; i <= 14; i++) {
            this.tiles[i][14].setObject(this.wall);
        }
        for (int i = 11; i <= 13; i++) {
            this.tiles[7][i].setObject(this.wall);
        }
        this.tiles[6][9].setObject(this.wall);
        this.tiles[6][10].setObject(this.wall);
        this.tiles[6][11].setObject(this.wall);
        for (int i = 8; i <= 10; i++) {
            this.tiles[8][i].setObject(this.wall);
        }
        for (int i = 10; i <= 12; i++) {
            this.tiles[9][i].setObject(this.wall);
        }
        this.tiles[10][12].setObject(this.wall);
        for (int i = 8; i <= 12; i++) {
            this.tiles[11][i].setObject(this.wall);
        }
        this.tiles[9][8].setObject(this.wall);
        this.tiles[8][6].setObject(this.wall);
        this.tiles[9][6].setObject(this.wall);
        
        //IC
        this.tiles[5][10].setObject(this.IC);
        this.tiles[10][7].setObject(this.IC);
        this.tiles[5][12].setObject(this.IC);
        this.tiles[5][13].setObject(this.IC);
        this.tiles[6][12].setObject(this.IC);
        this.tiles[6][13].setObject(this.IC);

        //Key
        this.tiles[10][11].setObject(this.redKey);
        this.tiles[7][10].setObject(this.yellowKey);

        //Door
        this.tiles[10][8].setObject(this.redDoor);
        this.tiles[5][11].setObject(this.yellowDoor);
        
        //Barrier And Finish
        this.tiles[8][12].setObject(this.barrier);
        this.tiles[8][11].setObject(this.finish);
        
        //Fire
        this.tiles[5][9].setObject(new Fire());
        this.tiles[7][9].setObject(new Fire());
        this.tiles[6][6].setObject(new Fire());
        this.tiles[6][7].setObject(new Fire());
        this.tiles[7][6].setObject(new Fire());
        this.tiles[10][6].setObject(new Fire());
        this.tiles[11][6].setObject(new Fire());
        this.tiles[11][7].setObject(new Fire());
       
        //Sepatu
        this.tiles[8][13].setObject(this.redShoes);
    }

    /**
     * Method untuk mendapatkan koordinat awal chip
     * @return koordinat awal chip
     */
    @Override
    public Point getInitialChipCoordinate() {
        return new Point(9, 9);
    }
}
