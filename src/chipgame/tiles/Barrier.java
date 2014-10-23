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

    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     * @return 3, berarti bisa, namun perlu ada pengecekan
     */
    @Override
    public int canBeStepped() {
        return 3;
    }

    /**
     * Method untuk mengecek apakah objek ini dapat diambil atau tidak.
     * @return true, berarti bisa
     */
    @Override
    public boolean canBeTaken() {
        return true;
    }

    /**
     * Method untuk mengecek apakah persyaratan sudah terpenuhi atau belum.
     * @param chip player
     * @return true, jika IC yang dimiliki chip sama atau lebih dari IC yang diperlukan
     */
    @Override
    public boolean check(Chip chip) {
        if(chip.getICAcquired()>=chip.getICRequired()) { return true; }
        else { return false; }
    }
    
}
