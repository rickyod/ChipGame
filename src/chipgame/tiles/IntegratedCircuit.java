/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

/**
 * IC sebagai objek yang dapat di taruh di ubin yang dapat diambil dan dapat diinjak. Menginjak sama dengan mengambil.
 * @author Devi Handevi 2013730015
 * @author Riky Setiawan
 */
public class IntegratedCircuit extends TileObject {

    @Override
    public int canBeStepped() {
        return 0;
    }

    @Override
    public boolean canBeTaken() {
        return true;
    }
    
}
