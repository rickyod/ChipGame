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
public class Level1 extends Level{
    
    public Level1() {
        this.nextLevel = new Level2();
        this.width = 10;
        this.length = 10;
        this.tiles = new Tile[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
        createMap();
    }
    
    @Override
    public void createMap() {
        for (int i = 0; i < width; i++) { //wall kiri
            this.tiles[i][0].addObject(this.wall);
        }
        for (int i = 0; i < width; i++) { //wall kanan
            this.tiles[i][length - 1].addObject(this.wall);
        }
        for (int i = 0; i < length; i++) { //wall atas
            this.tiles[0][i].addObject(this.wall);
        }
        for (int i = 0; i < length; i++) { //wall atas
            this.tiles[width - 1][i].addObject(this.wall);
        }

        this.tiles[1][4].addObject(this.IC);
        this.tiles[2][8].addObject(this.IC);
        this.tiles[8][2].addObject(this.IC);

        this.tiles[8][5].addObject(this.greenKey);
        this.tiles[8][6].addObject(this.greenDoor);
        
        this.tiles[1][3].addObject(new Fire());
        this.tiles[2][3].addObject(new Fire());
        this.tiles[2][4].addObject(new Fire());

        this.tiles[2][7].addObject(new Fire());
        this.tiles[3][7].addObject(new Fire());
        this.tiles[3][8].addObject(new Fire());

        this.tiles[7][2].addObject(new Fire());
        this.tiles[6][3].addObject(new Fire());
        this.tiles[7][3].addObject(new Fire());
        this.tiles[8][3].addObject(new Fire());

        for (int i = 3; i <= 7; i++) {
            this.tiles[5][i].addObject(this.wall);
        }
        for (int i = 5; i <= 8; i++) {
            this.tiles[7][i].addObject(this.wall);
        }

        this.tiles[8][7].addObject(this.barrier);
        this.tiles[8][8].addObject(this.finish);
    }
    
    @Override
    public Tile[][] getMap() {
        return this.tiles;
    }

    @Override
    public int getICRequired() {
        return 3;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public Point getChipCoordinate() {
        return new Point(1,1);   
    }

    @Override
    public Level getNextLevel() {
        return this.nextLevel;
    }
}
