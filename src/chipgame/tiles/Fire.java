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

    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     * @return 1, berarti bisa diinjak namun penginjak mati dan permainan berakhir
     */
    @Override
    public int canBeStepped() {
        return 1;
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
