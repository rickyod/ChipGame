/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

/**
 * Api sebagai objek yang dapat ditaruh di ubin yang tidak dapat diambil dan dapat diinjak. 
 * Jika diinjak, player akan mati dan permainan selesai.
 * @author Devi Handevi 2013730015
 */
public class Fire extends TileObject {

    @Override
    public int canBeStepped() {
        return 1;
    }

    @Override
    public boolean canBeTaken() {
        return false;
    }
    
}
