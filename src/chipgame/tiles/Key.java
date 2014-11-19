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
 * Key sebagai objek yang dapat di taruh di ubin yang dapat diambil dan dapat diinjak. Menginjak sama dengan mengambil.
 * Jika mendapatkan key , bisa membuka door sesuai dengan warna dari key.
 * Contoh , bila key berwarna merah akan membuka door berwarna merah.
 * 
 * @author Devi Handevi 2013730015
 */
public class Key extends TileObject {

    /**
     * Atribut warna dari key (Red , Green , Blue , Yellow)
     */
    private Color color;

    /**
     * Constructor untuk membuat objek kunci dengan warna tertentu.
     * @param color warna
     */
    public Key(Color color) {
        this.image = new Image[1];
        this.color = color;
        try {
            if (this.color.equals(Color.RED)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/key_red.png"));
            } else if (this.color.equals(Color.GREEN)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/key_green.png"));
            } else if (this.color.equals(Color.BLUE)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/key_blue.png"));
            } else if (this.color.equals(Color.YELLOW)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/key_yellow.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Key.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     *
     * @return 0, berarti bisa langsung diinjak
     */
    @Override
    public int canBeStepped() {
        return 0;
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
     * Method untuk mendapatkan warna dari kunci.
     *
     * @return warna kunci
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Method untuk mendapatkan gambar.
     *
     * @return gambar key
     */
    @Override
    public Image getImage() {
        return this.image[0];
    }
}
