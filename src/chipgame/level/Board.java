/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.level;

import chipgame.tiles.*;
import java.util.Scanner;

/**
 * Kelas sebagai papan permainan yang dapat menjalankan game dalam text mode
 * maupun GUI.
 *
 * @author Devi Handevi 2013730015
 */
public class Board {

    private Tile[][] tiles;
    private int width;
    private int length;
    private Chip chip;
    private int ICRequired;
    private int keyRequired;

    public Board() {
        this.width = 10;
        this.length = 10;
        this.tiles = new Tile[width][length];
        this.ICRequired = 3;
        keyRequired = 1;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                this.tiles[i][j] = new Tile();
            }
        }

        this.chip = new Chip(1, 1, ICRequired, keyRequired);

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

        this.tiles[8][5].addObject(new Key());
        this.tiles[8][6].addObject(new Door());

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

    public void drawBoard() {
        TileObject steppedObject;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (i != chip.getY() || j != chip.getX()) {
                    steppedObject = this.tiles[i][j].getWhatIsStepped();
                    if (steppedObject == null) {
                        System.out.print(".");
                    } else {
                        if (steppedObject.getClass().equals(Chip.class)) {
                            System.out.print("?");
                        } else if (steppedObject.getClass().equals(Wall.class)) {
                            System.out.print("W");
                        } else if (steppedObject.getClass().equals(Barrier.class)) {
                            System.out.print("B");
                        } else if (steppedObject.getClass().equals(Finish.class)) {
                            System.out.print("F");
                        } else if (steppedObject.getClass().equals(Fire.class)) {
                            System.out.print("X");
                        } else if (steppedObject.getClass().equals(IntegratedCircuit.class)) {
                            System.out.print("I");
                        } else if (steppedObject.getClass().equals(Key.class)) {
                            System.out.print("K");
                        } else if (steppedObject.getClass().equals(Door.class)) {
                            System.out.print("D");
                        }
                        
                    }
                } else {
                    System.out.print("O");
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public void startGameTextMode() {
        Scanner sc = new Scanner(System.in);
        String dir;
        Tile steppedTile;
        TileObject steppedObject;
        boolean canMove;
        this.drawBoard();

        while (this.chip.getCondition() == 0) {
            dir = sc.next();
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
                this.chip.addObject(steppedTile.takeSteppedObject());
            }
            this.drawBoard();
        }

        if (this.chip.getCondition() == 1) {
            System.out.println("WIN");
        } else {
            System.out.println("LOSE");
        }
    }
}
