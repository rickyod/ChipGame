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
 * Door sebagai objek yang dapat di taruh di ubin yang dapat diambil dan dapat diinjak dengan kondisi tertentu.
 * Door akan bisa dibuka dengan objek Key yang memiliki warna yang sama dengan door.
 * Contoh , bila door berwarna merah akan terbuka bila memiliki key berwarna merah juga.
 * 
 * @author Devi Handevi 2013730015
 */
public class Door extends TileObject {

    /**
     * Atribut warna dari door
     */
    private Color color;

    /**
     * Constructor untuk membuat pintu dengan warna tertentu.
     * @param color warna
     */
    public Door(Color color) {
        this.image = new Image[1];
        this.color = color;
        try {
            if (color.equals(Color.RED)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/door_red.png"));
            } else if (color.equals(Color.GREEN)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/door_green.png"));
            } else if (color.equals(Color.BLUE)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/door_blue.png"));
            } else if (color.equals(Color.YELLOW)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/door_yellow.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Door.class.getName()).log(Level.SEVERE, null, ex);
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
     * Method untuk mengecek apakah chip memiliki kunci dengan warna door yang
     * sama.
     *
     * @param chip player
     * @return true, jika key yang dimiliki chip sama atau lebih dari key yang
     * diperlukan
     */
    public boolean openDoor(Chip chip) {
        if (chip.hasColoredKey(this.color)) {
            return true;
        }
        return false;
    }

    /**
     * Method untuk mendapatkan gambar.
     *
     * @return gambar door
     */
    @Override
    public Image getImage() {
        return this.image[0];
    }
}
