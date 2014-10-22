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

    @Override
    public int canBeStepped() {
        return -1;
    }

    @Override
    public boolean canBeTaken() {
        return false;
    }
    
}
