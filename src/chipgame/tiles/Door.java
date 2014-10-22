/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

/**
 *
 * @author Devi
 */
public class Door extends TileObject {//implements Conditional {

    @Override
    public int canBeStepped() {
        return 3;
    }

    @Override
    public boolean canBeTaken() {
        return true;
    }

    public boolean check(Chip chip) {
        if(chip.getKeyAcquired()>=chip.getKeyRequired()) { return true; }
        else { return false; }
    }
    
}
