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
    /**
     * Attribute untuk menyimpan posisi absis tile.
     */
    private int x;
    /**
     * Attribute untuk menyimpan posisi ordinat tile.
     */
    private int y;
    /**
     * Attribute untuk menyimpan objek yang ditaruh di ubin.
     */
    private TileObject object;

    /**
     * Method untuk mendapatkan objek apa yang ditaruh di ubin.
     * @return objek yang ditaruh di ubin
     */
    public TileObject getWhatIsStepped() {
        return this.object;
    }

    /**
     * Method untuk mengambil objek yang ditaruh di ubin, dan mengubah objek di ubin menjadi null.
     * @return objek yang ditaruh di ubin jika objek tersebut dapat diambil
     */
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
     * Method untuk menaruh objek di ubin.
     * @param object objek yang ingin ditaruh
     */
    public void addObject(TileObject object) {
        this.object = object;
    }
}
