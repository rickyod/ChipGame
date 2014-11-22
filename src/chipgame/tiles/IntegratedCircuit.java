/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * IC sebagai objek yang dapat di taruh di ubin yang dapat diambil dan dapat diinjak. Menginjak sama dengan mengambil.
 * IC diperlukan chip untuk melewati barrier.
 * 
 * @author Devi Handevi 2013730015
 * @author Riky Setiawan
 */
public class IntegratedCircuit extends TileObject {

    /**
     * Constructor untuk membuat objek IC.
     */
    public IntegratedCircuit() {
        this.image = new Image[1];
        
        this.image[0] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/IC.png")).getImage();
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
        return this.image[0];
    }
}
