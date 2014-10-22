/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

/**
 * Gerbang sebagai objek yang dapat di taruh di ubin yang dapat diambil dan dapat diinjak jika player memiliki IC yang cukup.
 * @author Devi Handevi 2013730015
 */
public class Barrier extends TileObject implements Conditional {

    @Override
    public int canBeStepped() {
        return 3;
    }

    @Override
    public boolean canBeTaken() {
        return true;
    }

    @Override
    public boolean check(Chip chip) {
        if(chip.getICAcquired()>=chip.getICRequired()) { return true; }
        else { return false; }
    }
    
}
