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
 * Api sebagai objek yang dapat ditaruh di ubin yang tidak dapat diambil dan dapat diinjak. 
 * Jika diinjak, player akan mati dan permainan selesai.
 * @author Devi Handevi 2013730015
 */
public class Fire extends TileObject {

    private int imageIterator;
    
    public Fire() {
        this.image = new Image[6];
        this.imageIterator = 0;
        try {
            this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/fire1.png"));
            this.image[1] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/fire2.png"));
            this.image[2] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/fire3.png"));
            this.image[3] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/fire4.png"));
            this.image[4] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/fire5.png"));
            this.image[5] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/fire6.png"));
        } catch (IOException ex) {
            Logger.getLogger(Fire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
    
    /**
     * Method untuk mendapatkan gambar.
     * @return gambar fire
     */
    @Override
    public Image getImage() {
        Image i = this.image[this.imageIterator];
        this.imageIterator = (this.imageIterator+1)%6;
        return i;
    }
}
