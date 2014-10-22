/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

/**
 * Kelas abstract untuk merepresentasikan objek yang dapat ditaruh di ubin.
 * @author Devi Handevi 2013730015
 * @author Riky Setiawan
 */
public abstract class TileObject {

    /**
     *
     * @return -1 ga bisa, 0 bisa, 1 mati, 2 menang, 3 cek dulu
     */
    public abstract int canBeStepped();

    public abstract boolean canBeTaken();
}
