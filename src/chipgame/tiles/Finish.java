/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Finish adalah objek yang dapat di taruh di ubin.
 * Jika player menginjak finish, maka player akan menang dan permainan berakhir.
 * 
 * @author Devi Handevi 2013730015
 */
public class Finish extends TileObject {
    
    /**
     * Attribute sebagai penunjuk gambar sekarang.
     */
    private int imageIterator;
    
    /**
     * Constructor untuk membuat objek finish.
     */
    public Finish() {
        this.image = new Image[4];
        this.imageIterator = 0;
        
        this.image[0] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/finish1.png")).getImage();
        this.image[1] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/finish2.png")).getImage();
        this.image[2] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/finish3.png")).getImage();
        this.image[3] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/finish4.png")).getImage();
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
        Image i = this.image[this.imageIterator];
        this.imageIterator = (this.imageIterator+1)%4;
        return i;
    }
}
