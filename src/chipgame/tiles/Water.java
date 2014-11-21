/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
        try {
            this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/water1.png"));
            this.image[1] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/water2.png"));
            this.image[2] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/water3.png"));
            this.image[3] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/water4.png"));
            this.image[4] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/water5.png"));
            this.image[5] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/water6.png"));
            this.image[6] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/water7.png"));
            this.image[7] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/water8.png"));
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

