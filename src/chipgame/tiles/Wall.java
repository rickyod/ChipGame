/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Tembok sebagai objek yang dapat ditaruh di ubin yang tidak bisa diambil maupun diinjak.
 * @author Devi Handevi 2013730015
 * @author Riky Setiawan
 */
public class Wall extends TileObject {

    /**
     * Constructor untuk membuat dinding.
     */
    public Wall() {
        this.image = new Image[1];
        
        this.image[0] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/wall.png")).getImage();
    }
    
    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     * @return -1, berarti tidak bisa diinjak
     */
    @Override
    public int canBeStepped() {
        return -1;
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
     * @return gambar wall
     */
    @Override
    public Image getImage() {
        return this.image[0];
    }
}
