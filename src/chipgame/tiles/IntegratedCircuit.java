/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * IC sebagai objek yang dapat di taruh di ubin yang dapat diambil dan dapat diinjak. Menginjak sama dengan mengambil.
 * @author Devi Handevi 2013730015
 * @author Riky Setiawan
 */
public class IntegratedCircuit extends TileObject {

    public IntegratedCircuit() {
        try {
            URL url = getClass().getClassLoader().getResource("chipgame/images/IC.jpg");
            this.image = ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(IntegratedCircuit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     * @return 0, berarti bisa langsung diinjak
     */
    @Override
    public int canBeStepped() {
        return 0;
    }

    /**
     * Method untuk mengecek apakah objek ini dapat diambil atau tidak.
     * @return true, berarti bisa
     */
    @Override
    public boolean canBeTaken() {
        return true;
    }
    
    /**
     * Method untuk mendapatkan gambar.
     * @return gambar IC
     */
    @Override
    public Image getImage() {
        return this.image;
    }
}
