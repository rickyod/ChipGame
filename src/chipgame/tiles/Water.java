/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Air sebagai objek yang dapat ditaruh di ubin yang tidak dapat diambil.
 * Jika chip tidak memiliki sepatu kebal air dan menginjak air, maka chip akan mati dan permainan selesai.
 * 
 * @author Devi Handevi 2013730015
 */
public class Water extends TileObject implements Conditional {

    /**
     * Attribute sebagai penunjuk gambar sekarang.
     */
    private int imageIterator;
    
    /**
     * Constructor untuk membuat objek air.
     */
    public Water() {
        this.image = new Image[8];
        this.imageIterator = 0;
        
        this.image[0] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/water1.png")).getImage();
        this.image[1] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/water2.png")).getImage();
        this.image[2] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/water3.png")).getImage();
        this.image[3] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/water4.png")).getImage();
        this.image[4] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/water5.png")).getImage();
        this.image[5] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/water6.png")).getImage();
        this.image[6] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/water7.png")).getImage();
        this.image[7] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/water8.png")).getImage();
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
     * Method untuk mengecek apakah chip memiliki sepatu khusus untuk dapat berjalan di air
     * @param chip
     * @return true jika chip punya
     */
    @Override
    public boolean check(Chip chip) {
        if(chip.hasShoes(Color.BLUE)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method untuk mendapatkan gambar.
     * @return gambar air
     */
    @Override
    public Image getImage() {
        Image i = this.image[this.imageIterator];
        this.imageIterator = (this.imageIterator+1)%8;
        return i;
    }
}

