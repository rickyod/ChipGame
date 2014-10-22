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

    @Override
    public int canBeStepped() {
        return 2;
    }

    @Override
    public boolean canBeTaken() {
        return false;
    }
    
}
