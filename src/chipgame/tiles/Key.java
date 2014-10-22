/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

/**
 *
 * @author Devi
 */
public class Key extends TileObject {

    @Override
    public int canBeStepped() {
        return 0;
    }

    @Override
    public boolean canBeTaken() {
        return true;
    }
}
