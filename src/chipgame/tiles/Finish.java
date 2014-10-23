/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

/**
 * Ubin Finish sebagai objek yang dapat di taruh di ubin, jika player menginjak ini, maka player akan menang dan permainan berakhir.
 * @author Devi Handevi 2013730015
 */
public class Finish extends TileObject {

    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     * @return 2, berarti bisa diinjak, penginjak akan menang dan permainan berakhir.
     */
    @Override
    public int canBeStepped() {
        return 2;
    }

    /**
     * Method untuk mengecek apakah objek ini dapat diambil atau tidak.
     * @return false, berarti tidak bisa
     */
    @Override
    public boolean canBeTaken() {
        return false;
    }
    
}
