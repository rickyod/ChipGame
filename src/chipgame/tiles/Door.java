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
     * @return true, jika key yang dimiliki chip sama atau lebih dari key yang diperlukan
     */
    public boolean check(Chip chip) {
        if(chip.getKeyAcquired()>=chip.getKeyRequired()) { return true; }
        else { return false; }
    }
    
}
