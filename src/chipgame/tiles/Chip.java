/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

//import java.util.LinkedList;
/**
 * Kelas Chip sebagai player.
 *
 * @author Devi Handevi 2013730015
 */
public class Chip {

    private int x;
    private int y;
    private int win; //-1 lose, 0 not yet, 1 win
    private int ICAcquired;
    private final int ICRequired;
    private int keyAcquired;
    private final int keyRequired;
    //private LinkedList<Key> keys; ???

    public Chip(int x, int y, int ICRequired, int keyRequired) {
        this.x = x;
        this.y = y;
        this.ICAcquired = 0;
        this.ICRequired = ICRequired;
        this.keyAcquired = 0;
        this.keyRequired = keyRequired;
        this.win = 0;
    }

    public boolean move(TileObject object, int moveX, int moveY) {
        if (object != null && object.canBeStepped() == -1) {
            return false;
        } else {
            if (object == null) {
                this.move(moveX, moveY);
                return true;
            } else {
                if (object.canBeStepped() == 0) {
                    this.move(moveX, moveY);
                } else if (object.canBeStepped() == 1) {
                    this.win = -1;
                } else if (object.canBeStepped() == 2) {
                    this.move(moveX, moveY);
                    this.win = 1;
                } else if (object.canBeStepped() == 3) {
                    if(object.getClass().equals(Barrier.class))
                    { if(((Barrier)object).check(this)) { this.move(moveX, moveY); } else { return false; } }
                    else
                    { if(((Door)object).check(this)) { this.move(moveX, moveY); } else { return false; } }
                }
                return true;
            }
        }
    }

    private void move(int moveX, int moveY) {
        this.x += moveX;
        this.y += moveY;
    }

    public void addObject(TileObject object) {
        if (object != null) {
            if(object.getClass().equals(IntegratedCircuit.class)) { this.ICAcquired++; }
            else if(object.getClass().equals(Key.class)) { this.keyAcquired++; }
        }
    }

    public int getICAcquired() {
        return this.ICAcquired;
    }

    public int getICRequired() {
        return this.ICRequired;
    }

    public int getKeyAcquired() {
        return keyAcquired;
    }

    public int getKeyRequired() {
        return keyRequired;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCondition() {
        return this.win;
    }
}
