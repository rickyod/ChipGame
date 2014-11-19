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
 * Kelas level 4.
 * 
 * @author Riky Setiawan 2013730041
 * @author Devi Handevi 2013730015
 */
public class Level4 extends Level {

    public Level4() {
        this.initializeLevel();
    }

    @Override
    public void initializeLevel() {
        this.width = 25;
        this.length = 25;
        this.ICRequired = 1;
        this.tiles = new Tile[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
        this.loadAttributesNeeded();
        createMap();
    }
    
    @Override
    protected void loadAttributesNeeded() {
        this.redDoor = new Door(Color.red);
        this.redKey = new Key(Color.red);
        this.greenDoor = new Door(Color.green);
        this.greenKey = new Key(Color.green);
        this.blueDoor = new Door(Color.blue);
        this.blueKey = new Key(Color.blue);
        this.yellowDoor = new Door(Color.yellow);
        this.yellowKey = new Key(Color.yellow);
        this.redShoes = new Shoes(Color.red);
        this.blueShoes = new Shoes(Color.blue);
    }

    @Override
    protected void createMap() {
        
        //Wall
        //Outer
        for (int i = 3; i <= 21; i++) {
            this.tiles[i][3].setObject(this.wall);
        }
        for (int i = 4; i <= 21; i++) {
            this.tiles[3][i].setObject(this.wall);
        }
        for (int i = 4; i <= 21; i++) {
            this.tiles[21][i].setObject(this.wall);
        }
        for (int i = 4; i <= 20; i++) {
            this.tiles[i][21].setObject(this.wall);
        }
        for (int i = 4; i <= 7; i++) {
            this.tiles[5][i].setObject(this.wall);
        }
        this.tiles[6][7].setObject(this.wall);
        for (int i = 6; i <= 8; i++) {
            this.tiles[i][5].setObject(this.wall);
        }
        for (int i = 6; i <= 13; i++) {
            this.tiles[8][i].setObject(this.wall);
        }
        this.tiles[9][9].setObject(this.wall);
        this.tiles[4][19].setObject(this.wall);
        for (int i = 9; i <= 19; i++) {
            this.tiles[5][i].setObject(this.wall);
        }
        for (int i = 9; i <= 19; i++) {
            this.tiles[6][i].setObject(this.wall);
        }
        for (int i = 15; i <= 19; i++) {
            this.tiles[7][i].setObject(this.wall);
        }
        for (int i = 15; i <= 17; i++) {
            this.tiles[8][i].setObject(this.wall);
        }
        for (int i = 15; i <= 19; i++) {
            this.tiles[9][i].setObject(this.wall);
        }
        for (int i = 15; i <= 19; i++) {
            this.tiles[10][i].setObject(this.wall);
        }
        this.tiles[11][18].setObject(this.wall);
        for (int i = 11; i <= 16; i++) {
            this.tiles[i][19].setObject(this.wall);
        }
        for (int i = 14; i <= 16; i++) {
            this.tiles[i][17].setObject(this.wall);
        }
        for (int i = 11; i <= 14; i++) {
            this.tiles[i][16].setObject(this.wall);
        }
        for (int i = 12; i <= 14; i++) {
            this.tiles[i][15].setObject(this.wall);
        }
        this.tiles[13][14].setObject(this.wall);
        this.tiles[14][14].setObject(this.wall);
        for (int i = 10; i <= 13; i++) {
            this.tiles[i][13].setObject(this.wall);
        }
        
        for (int i = 5; i <= 7; i++) {
            this.tiles[10][i].setObject(this.wall);
        }
        this.tiles[10][11].setObject(this.wall);
        for (int i = 5; i <= 11; i++) {
            this.tiles[11][i].setObject(this.wall);
        }
        for (int i = 8; i <= 11; i++) {
            this.tiles[13][i].setObject(this.wall);
        }
        for (int i = 9; i <= 12; i++) {
            this.tiles[15][i].setObject(this.wall);
        }
        this.tiles[14][10].setObject(this.wall);
        this.tiles[14][11].setObject(this.wall);
        this.tiles[16][12].setObject(this.wall);
        this.tiles[17][11].setObject(this.wall);
        this.tiles[17][12].setObject(this.wall);
        for (int i = 6; i <= 9; i++) {
            this.tiles[16][i].setObject(this.wall);
        }
        for (int i = 12; i <= 16; i++) {
            this.tiles[i][5].setObject(this.wall);
        }
        for (int i = 13; i <= 15; i++) {
            this.tiles[i][7].setObject(this.wall);
        }
        this.tiles[19][4].setObject(this.wall);
        this.tiles[19][5].setObject(this.wall);
        this.tiles[20][7].setObject(this.wall);
        this.tiles[19][9].setObject(this.wall);
        this.tiles[20][9].setObject(this.wall);
        for (int i = 5; i <= 10; i++) {
            this.tiles[18][i].setObject(this.wall);
        }
        this.tiles[20][11].setObject(this.wall);
        for (int i = 11; i <= 14; i++) {
            this.tiles[19][i].setObject(this.wall);
        }
        for (int i = 16; i <= 18; i++) {
            this.tiles[i][14].setObject(this.wall);
        }
        this.tiles[16][15].setObject(this.wall);
        for (int i = 16; i <= 19; i++) {
            this.tiles[18][i].setObject(this.wall);
        }
        for (int i = 16; i <= 19; i++) {
            this.tiles[19][i].setObject(this.wall);
        }
        this.tiles[20][16].setObject(this.wall);
        
        //IC
        this.tiles[11][17].setObject(this.IC);

        //Key
        this.tiles[15][6].setObject(this.redKey);
        this.tiles[14][9].setObject(this.yellowKey);
        this.tiles[18][4].setObject(this.yellowKey);
        this.tiles[20][8].setObject(this.yellowKey);
        this.tiles[20][17].setObject(this.blueKey);
        this.tiles[8][18].setObject(this.greenKey);

        //Door
        this.tiles[20][18].setObject(this.redDoor);
        this.tiles[14][18].setObject(this.greenDoor);
        this.tiles[15][18].setObject(this.blueDoor);
        this.tiles[16][18].setObject(this.yellowDoor);
        
        //Barrier And Finish
        this.tiles[4][17].setObject(this.barrier);
        this.tiles[4][18].setObject(this.finish);
        
        //Fire
        this.tiles[5][8].setObject(new Fire());
        this.tiles[12][14].setObject(new Fire());
        this.tiles[11][15].setObject(new Fire());
        this.tiles[12][17].setObject(new Fire());
        this.tiles[13][17].setObject(new Fire());
        this.tiles[12][18].setObject(new Fire());
        this.tiles[13][18].setObject(new Fire());
       
        //Water
        this.tiles[8][19].setObject(new Water());
        this.tiles[6][8].setObject(new Water());
        this.tiles[7][4].setObject(new Water());
        this.tiles[8][4].setObject(new Water());
        
        //Sepatu
        this.tiles[6][4].setObject(this.redShoes);
        this.tiles[16][11].setObject(this.blueShoes);
    }

    @Override
    public Point getInitialChipCoordinate() {
        return new Point(4, 20);
    }
}