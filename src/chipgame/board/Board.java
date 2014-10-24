/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.board;

import chipgame.tiles.*;
import java.awt.Color;

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
     * Constructor default untuk men-set papan permainan.
     */
    public Board() {
        this.width = 10;
        this.length = 10;
        this.tiles = new Tile[width][length];
        this.ICRequired = 3;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                this.tiles[i][j] = new Tile();
            }
        }

        this.chip = new Chip(1, 1, ICRequired);

        for (int i = 0; i < width; i++) { //wall kiri
            this.tiles[i][0].addObject(new Wall());
        }
        for (int i = 0; i < width; i++) { //wall kanan
            this.tiles[i][length - 1].addObject(new Wall());
        }
        for (int i = 0; i < length; i++) { //wall atas
            this.tiles[0][i].addObject(new Wall());
        }
        for (int i = 0; i < length; i++) { //wall atas
            this.tiles[width - 1][i].addObject(new Wall());
        }

        this.tiles[1][4].addObject(new IntegratedCircuit());
        this.tiles[2][8].addObject(new IntegratedCircuit());
        this.tiles[8][2].addObject(new IntegratedCircuit());

        this.tiles[8][5].addObject(new Key(Color.GREEN));
        this.tiles[8][6].addObject(new Door(Color.GREEN));

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
            this.tiles[5][i].addObject(new Wall());
        }
        for (int i = 5; i <= 8; i++) {
            this.tiles[7][i].addObject(new Wall());
        }

        this.tiles[8][7].addObject(new Barrier());
        this.tiles[8][8].addObject(new Finish());
    }

    public String getCurrentBoardCondition() {
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

    public void move(String dir) {
        Tile steppedTile;
        TileObject steppedObject;
        boolean canMove;

        if (dir.equals("a")) {
            steppedTile = this.tiles[this.chip.getY()][this.chip.getX() - 1];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), -1, 0);
        } else if (dir.equals("d")) {
            steppedTile = this.tiles[this.chip.getY()][this.chip.getX() + 1];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), 1, 0);
        } else if (dir.equals("w")) {
            steppedTile = this.tiles[this.chip.getY() - 1][this.chip.getX()];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), 0, -1);
        } else //s
        {
            steppedTile = this.tiles[this.chip.getY() + 1][this.chip.getX()];
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
}
