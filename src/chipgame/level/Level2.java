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
 * Kelas level 2.
 * 
 * @author Riky Setiawan 2013730041
 * @author Devi Handevi 2013730015
 */
public class Level2 extends Level {

    /**
     * Method untuk menginisialisasi level.
     */
    @Override
    public void initializeLevel() {
        this.width = 27;
        this.length = 15;
        this.ICRequired = 0;
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
    }

    /**
     * Method untuk membuat peta pada level.
     */
    @Override
    protected void createMap() {
        //Wall
        for (int i = 8; i <= 10; i++) {
            this.tiles[3][i].setObject(this.wall);
        }
        for (int i = 3; i <= 5; i++) {
            this.tiles[i][11].setObject(this.wall);
        }
        for (int i = 6; i <= 8; i++) {
            this.tiles[i][8].setObject(this.wall);
        }
        for (int i = 10; i <= 12; i++) {
            this.tiles[i][9].setObject(this.wall);
        }
        for (int i = 6; i <= 8; i++) {
            this.tiles[i][10].setObject(this.wall);
        }
        for (int i = 3; i <= 11; i++) {
            this.tiles[i][7].setObject(this.wall);
        }
        for (int i = 14; i <= 23; i++) {
            this.tiles[i][7].setObject(this.wall);
        }
        for (int i = 7; i <= 23; i++) {
            this.tiles[i][11].setObject(this.wall);
        }
        for (int i = 3; i <= 7; i++) {
            this.tiles[11][i].setObject(this.wall);
        }
        this.tiles[12][3].setObject(this.wall);
        for (int i = 3; i <= 9; i++) {
            this.tiles[13][i].setObject(this.wall);
        }
        for (int i = 8; i <= 10; i++) {
            this.tiles[23][i].setObject(this.wall);
        }
        this.tiles[15][9].setObject(this.wall);
        this.tiles[15][10].setObject(this.wall);
        this.tiles[21][8].setObject(this.wall);
        this.tiles[21][9].setObject(this.wall);

        //Key
        this.tiles[12][4].setObject(this.redKey);
        this.tiles[6][11].setObject(this.redKey);

        //Door
        this.tiles[13][10].setObject(this.redDoor);
        
        //Barrier And Finish
        this.tiles[22][9].setObject(this.barrier);
        this.tiles[22][8].setObject(this.finish);
        
        //Fire
        this.tiles[17][8].setObject(new Fire());
        this.tiles[17][9].setObject(new Fire());
        this.tiles[19][9].setObject(new Fire());
        this.tiles[19][10].setObject(new Fire());

    }

    /**
     * Method untuk mendapatkan koordinat awal chip
     * @return koordinat awal chip
     */
    @Override
    public Point getInitialChipCoordinate() {
        return new Point(4, 8);
    }
}
