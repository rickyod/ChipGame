/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

/**
 * Kelas sebagai kotak-kotak ubin untuk board, dapat berisi objek yang dapat diambil atau tidak, diinjak atau tidak.
 * @author Devi Handevi
 * @author Riky Setiawan
 */
public class Tile {

    private int x;
    private int y;
    private TileObject object;

    public TileObject getWhatIsStepped() {
        return this.object;
    }

    public TileObject takeSteppedObject() {
        if (this.object != null && this.object.canBeTaken()) {
            TileObject taken = this.object;
            this.object = null;
            return taken;
        } else {
            return null;
        }
    }

    /**
     * Method untuk memasukan objek ke dalam tile.
     *
     * @param object
     */
    public void addObject(TileObject object) {
        this.object = object;
    }
}
