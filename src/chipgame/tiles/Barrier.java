/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Gerbang sebagai objek yang dapat di taruh di ubin yang dapat diambil dan
 * dapat diinjak jika player memiliki IC yang cukup.
 *
 * @author Devi Handevi 2013730015
 */
public class Barrier extends TileObject implements Conditional {

    /**
     * Constructor untuk membuat penghalang sebelum masuk finish, mengecek banyak IC sebelum dapat dilewati.
     */
    public Barrier() {
        this.image = new Image[1];
        try {
            this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/barrier.png"));
        } catch (IOException ex) {
            Logger.getLogger(Barrier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     *
     * @return 3, berarti bisa, namun perlu ada pengecekan
     */
    @Override
    public int canBeStepped() {
        return 3;
    }

    /**
     * Method untuk mengecek apakah objek ini dapat diambil atau tidak.
     *
     * @return true, berarti bisa
     */
    @Override
    public boolean canBeTaken() {
        return true;
    }

    /**
     * Method untuk mengecek apakah persyaratan sudah terpenuhi atau belum.
     *
     * @param chip player
     * @return true, jika IC yang dimiliki chip sama atau lebih dari IC yang
     * diperlukan
     */
    @Override
    public boolean check(Chip chip) {
        if (chip.getICAcquired() >= chip.getICRequired()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method untuk mendapatkan gambar.
     *
     * @return gambar barrier
     */
    @Override
    public Image getImage() {
        return this.image[0];
    }
}
