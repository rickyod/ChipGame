/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.level;

import chipgame.tiles.*;
import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Level1 extends Level {

    public Level1() {
        this.initializeLevel();
    }

    @Override
    public void initializeLevel() {
        this.width = 19;
        this.length = 22;
        this.ICRequired = 3;
        this.tiles = new Tile[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
        createMap();
    }

    @Override
    protected void createMap() {
        //Upper Wall
        for (int i = 3; i <= 6; i++) {
            this.tiles[8][i].addObject(this.wall);
        }
        this.tiles[9][3].addObject(this.wall);
        for (int i = 3; i <= 6; i++) {
            this.tiles[10][i].addObject(this.wall);
        }
        this.tiles[6][7].addObject(this.wall);
        this.tiles[7][6].addObject(this.wall);
        this.tiles[7][7].addObject(this.wall);
        this.tiles[11][6].addObject(this.wall);
        this.tiles[11][7].addObject(this.wall);
        this.tiles[12][7].addObject(this.wall);

        //Left Wall
        for (int i = 3; i <= 6; i++) {
            this.tiles[i][8].addObject(this.wall);
        }
        this.tiles[3][9].addObject(this.wall);
        for (int i = 3; i <= 6; i++) {
            this.tiles[i][10].addObject(this.wall);
        }

        //Right Wall
        for (int i = 12; i <= 15; i++) {
            this.tiles[i][8].addObject(this.wall);
        }
        this.tiles[15][9].addObject(this.wall);
        for (int i = 12; i <= 15; i++) {
            this.tiles[i][10].addObject(this.wall);
        }

        //Lower Wall
        for (int i = 12; i <= 18; i++) {
            this.tiles[8][i].addObject(this.wall);
        }
        this.tiles[9][18].addObject(this.wall);
        for (int i = 12; i <= 18; i++) {
            this.tiles[10][i].addObject(this.wall);
        }
        this.tiles[6][11].addObject(this.wall);
        this.tiles[7][11].addObject(this.wall);
        this.tiles[7][12].addObject(this.wall);
        this.tiles[11][11].addObject(this.wall);
        this.tiles[11][12].addObject(this.wall);
        this.tiles[12][11].addObject(this.wall);

        //IC
        this.tiles[9][4].addObject(this.IC);
        this.tiles[13][9].addObject(this.IC);
        this.tiles[14][9].addObject(this.IC);

        //Key
        this.tiles[4][9].addObject(this.greenKey);
        this.tiles[5][9].addObject(this.blueKey);
        this.tiles[6][9].addObject(this.redKey);

        //Door
        this.tiles[9][13].addObject(this.redDoor);
        this.tiles[9][14].addObject(this.blueDoor);
        this.tiles[9][15].addObject(this.greenDoor);
        //Barrier And Finish
        this.tiles[9][16].addObject(this.barrier);
        this.tiles[9][17].addObject(new Finish());
    }

    @Override
    public Point getInitialChipCoordinate() {
        return new Point(9, 9);
    }
}
