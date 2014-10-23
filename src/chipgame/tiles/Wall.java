/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

/**
 * Tembok sebagai objek yang dapat ditaruh di ubin yang tidak bisa diambil maupun diinjak.
 * @author Devi Handevi 2013730015
 * @author Riky Setiawan
 */
public class Wall extends TileObject {

    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     * @return -1, berarti tidak bisa diinjak
     */
    @Override
    public int canBeStepped() {
        return -1;
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
