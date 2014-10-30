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
 * Ubin Finish sebagai objek yang dapat di taruh di ubin, jika player menginjak ini, maka player akan menang dan permainan berakhir.
 * @author Devi Handevi 2013730015
 */
public class Finish extends TileObject {

    //private int imageIterator;
    
    public Finish() {
        //this.imageIterator = 0;
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/finish1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Finish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     * @return 2, berarti bisa diinjak, penginjak akan menang dan permainan berakhir.
     */
    @Override
    public int canBeStepped() {
        return 2;
    }

    /**
     * Method untuk mengecek apakah objek ini dapat diambil atau tidak.
     * @return false, berarti tidak bisa
     */
    @Override
    public boolean canBeTaken() {
        return false;
    }
    
    /**
     * Method untuk mendapatkan gambar.
     * @return gambar finish
     */
    @Override
    public Image getImage() {
//        Image i = this.image;
//        this.imageIterator = (this.imageIterator+1)%4;
//        return i;
        return this.image;
    }
}
