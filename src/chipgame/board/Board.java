/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.board;

import chipgame.level.*;
import chipgame.tiles.*;
import java.awt.Color;

/**
 * Kelas sebagai papan permainan yang menjalankan semua jalannya permainan.
 *
 * @author Riky Setiawan 2013730041
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
     * Attribute inventory tools yang dimiliki chip 
     * 0,0 Red Key , 1,0 Green Key, 2,0 Blue Key , 3,0 Yellow Key ,  0,1 Red Shoes , 1,1 Blue Shoes
     */
    private Tile[][] inventory;
    /**
     * Attribute untuk menyimpan jumlah IC yang diperlukan.
     */
    private int ICRequired;
    /**
     * Attribute level.
     */
    private Levels level;
    /**
     * Attribute index dari level
     */
    private int levelIndex;

    /**
     * Constructor default untuk men-set papan permainan.
     */
    public Board() {
        this.inventory = new Tile[4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                this.inventory[i][j] = new Tile();
            }
        }
        this.levelIndex = 1;
        this.level = new Levels();
        this.set();
    }

    /**
     * Method untuk mendapatkan tile-tile di dalam board.
     *
     * @return array of tile di dalam board
     */
    public Tile[][] getArrayOfTile() {
        return this.tiles;
    }

    /**
     * Method untuk mendapatkan array dari inventory
     *
     * @return array of tile inventory
     */
    public Tile[][] getArrayOfInventory() {
        return this.inventory;
    }

    /**
     * Method untuk mendapatkan panjang board.
     *
     * @return
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Method untuk mendapatkan lebar board.
     *
     * @return
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Method untuk menggerakan chip ke arah tertentu.
     *
     * @param dir arah bergerak
     */
    public void move(String dir) {
        Tile steppedTile;
        TileObject steppedObject;
        boolean canMove;
        TileObject takenObject;

        if (dir.equals("a")) {
            steppedTile = this.tiles[this.chip.getX() - 1][this.chip.getY()];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), -1, 0);
        } else if (dir.equals("d")) {
            steppedTile = this.tiles[this.chip.getX() + 1][this.chip.getY()];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), 1, 0);
        } else if (dir.equals("w")) {
            steppedTile = this.tiles[this.chip.getX()][this.chip.getY() - 1];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), 0, -1);
        } else { //s
            steppedTile = this.tiles[this.chip.getX()][this.chip.getY() + 1];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), 0, 1);
        }

        if (canMove) {
            takenObject = this.chip.takeObject(steppedTile.takeSteppedObject());
            //Memasukkan object kedalam inventory
            if (takenObject != null) {
                if (takenObject.getClass().equals(Key.class)) {
                    Key keyObj = (Key) takenObject;
                    if (keyObj.getColor().equals(Color.RED)) {
                        this.inventory[0][0].setObject(takenObject);
                    } else if (keyObj.getColor().equals(Color.GREEN)) {
                        this.inventory[1][0].setObject(takenObject);
                    } else if (keyObj.getColor().equals(Color.BLUE)) {
                        this.inventory[2][0].setObject(takenObject);
                    }
                    else //Yellow Key
                    {
                        this.inventory[3][0].setObject(takenObject);
                    }
                } else if (takenObject.getClass().equals(Shoes.class)) {
                    Shoes shoesObj = (Shoes) takenObject;
                    if (shoesObj.getColor().equals(Color.RED)) {
                        this.inventory[0][1].setObject(takenObject);
                    } else if (shoesObj.getColor().equals(Color.BLUE)) {
                        this.inventory[1][1].setObject(takenObject);
                    }
                }
            }
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
     *
     * @return
     */
    public Chip getChip() {
        return this.chip;
    }

    /**
     * Method untuk melanjutkan level.
     */
    public void getNextLevel() {
        if (this.level.goToTheNextLevel()) {
            this.set();
        }
        this.levelIndex++;
    }

    /**
     * Method untuk menginisialisasi attribute.
     */
    public void set() {
        this.width = level.getWidth();
        this.length = level.getLength();
        this.ICRequired = this.level.getICRequired();
        this.chip = new Chip(this.level.getInitialChipCoordinate().x, this.level.getInitialChipCoordinate().y, this.ICRequired);
        this.tiles = this.level.getMap();
        this.clearInventory();
    }

    public void reset() {
        this.level.resetLevel();
        this.set();
    }

    /**
     * Attribut untuk mengecek apakah game sudah berakhir
     *
     * @return boolean
     */
    public boolean endGame() {
        return this.getCondition() == 1 && this.level.endLevel();
    }

    /**
     * Method untuk mendapatkan index level
     *
     * @return int index level
     */
    public int getIndexLevel() {
        return this.levelIndex;
    }
    
    /**
     * Method untuk mengosongkan inventory.
     */
    public void clearInventory()
    {
        for (int i = 0; i < this.inventory.length; i++) {
            for (int j = 0; j < this.inventory[0].length; j++) {
                this.inventory[i][j].takeSteppedObject();
            }
        }
    }
}
