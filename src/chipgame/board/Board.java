/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.board;

import chipgame.level.*;
import chipgame.tiles.*;

/**
 * Kelas sebagai papan permainan yang dapat menjalankan game dalam text mode
 * maupun GUI.
 *
 * @author Devi Handevi 2013730015
 */
public class Board {

    /**
     * Attribute untuk menyimpan tiles.
     */
    private Tile[][] tiles;
    /**
     * Attribute untuk menyimpan tinggi papan permainan.
     */
    private int width;
    /**
     * Attribute untuk menyimpan lebar papan permainan.
     */
    private int length;
    /**
     * Attribute untuk menyimpan chip, sebagai pemain.
     */
    private Chip chip;
    /**
     * Attribute untuk menyimpan jumlah IC yang diperlukan.
     */
    private int ICRequired;
    /**
     * Attribute level.
     */
    private Levels level;
    
    /**
     * Constructor default untuk men-set papan permainan.
     */
    public Board() {
        this.level = new Levels();
        this.set();
    }

    /**
     * Method untuk mendapatkan tile-tile di dalam board.
     * @return array of tile di dalam board
     */
    public Tile[][] getArrayOfTile() {
        return this.tiles;
    }
    
    /**
     * Method untuk mendapatkan panjang board.
     * @return 
     */
    public int getLength() {
        return this.length;
    }
    
    /**
     * Method untuk mendapatkan lebar board.
     * @return 
     */
    public int getWidth() {
        return this.width;
    }
    
    /**
     * Method untuk mendapatkan kondisi papan dalam text mode. Sebagai debugger.
     * @return kondisi papan dalam text mode
     */
    public String getCurrentBoardConditionTextMode() {
        String currentBoard = new String();
        TileObject steppedObject;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (i != chip.getY() || j != chip.getX()) {
                    steppedObject = this.tiles[i][j].getWhatIsStepped();
                    if (steppedObject == null) {
                        currentBoard += ".";
                    } else {
                        if (steppedObject.getClass().equals(Chip.class)) {
                            currentBoard += "?";
                        } else if (steppedObject.getClass().equals(Wall.class)) {
                            currentBoard += "W";
                        } else if (steppedObject.getClass().equals(Barrier.class)) {
                            currentBoard += "B";
                        } else if (steppedObject.getClass().equals(Finish.class)) {
                            currentBoard += "F";
                        } else if (steppedObject.getClass().equals(Fire.class)) {
                            currentBoard += "X";
                        } else if (steppedObject.getClass().equals(IntegratedCircuit.class)) {
                            currentBoard += "I";
                        } else if (steppedObject.getClass().equals(Key.class)) {
                            currentBoard += "K";
                        } else if (steppedObject.getClass().equals(Door.class)) {
                            currentBoard += "D";
                        }
                    }
                } else {
                    currentBoard += "O";
                }
                currentBoard += " ";
            }
            currentBoard += "\n";
        }
        return currentBoard;
    }

    /**
     * Method untuk menggerakan chip ke arah tertentu.
     * @param dir arah bergerak
     */
    public void move(String dir) {
        Tile steppedTile;
        TileObject steppedObject;
        boolean canMove;

        if (dir.equals("a")) {
            steppedTile = this.tiles[this.chip.getX()-1][this.chip.getY()];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), -1, 0);
        } else if (dir.equals("d")) {
            steppedTile = this.tiles[this.chip.getX()+1][this.chip.getY()];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), 1, 0);
        } else if (dir.equals("w")) {
            steppedTile = this.tiles[this.chip.getX()][this.chip.getY()-1];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), 0, -1);
        } else { //s
            steppedTile = this.tiles[this.chip.getX()][this.chip.getY()+1];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), 0, 1);
        }

        if (canMove) {
            this.chip.takeObject(steppedTile.takeSteppedObject());
        }
    }

    /**
     * Method untuk mengecek kondisi permainan.
     *
     * @return 0 jika permainan belum berakhir, -1 jika permainan kalah, 1 jika
     * permainan dimenangkan
     */
    public int getCondition() {
        return this.chip.getCondition();
    }
    
    /**
     * Method untuk mendapatkan objek chip
     * @return 
     */
    public Chip getChip()
    {
        return this.chip;
    }
    
    /**
     * Method untuk melanjutkan level.
     */
    public void getNextLevel() {
        if(this.level.goToTheNextLevel()) {
            this.set();
        }
    }

    /**
     * Method untuk menginisialisasi attribute.
     */
    public void set() {
        this.width = level.getWidth();
        this.length = level.getLength();
        this.ICRequired = this.level.getICRequired();
        this.chip = new Chip(this.level.getInitialChipCoordinate().x,this.level.getInitialChipCoordinate().y,this.ICRequired);
        this.tiles = this.level.getMap();
    }
    
    public void reset() {
        this.level.resetLevel();
        this.set();
    }
}
