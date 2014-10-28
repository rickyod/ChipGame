/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Devi
 */
public class Door extends TileObject {

    public Door() {
        try {
            this.image = ImageIO.read(new URL("chipgame/images/door.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Door.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Atribut warna dari door
     */
    private Color color;
    
    public Door(Color color)
    {
        this.color=color;
    }
    
    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     * @return 3, berarti bisa, namun perlu ada pengecekan
     */
    @Override
    public int canBeStepped() {
        return 3;
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
     * Method untuk mengecek apakah chip memiliki kunci dengan warna door yang sama.
     * @param chip player
     * @return true, jika key yang dimiliki chip sama atau lebih dari key yang diperlukan
     */
    public boolean openDoor(Chip chip) {
        if(chip.getColoredKeyAcquired(this.color)>0)
        {
            chip.useKey(color);
            return true;
        }
        return false;
    }
    
    /**
     * Method untuk mendapatkan gambar.
     * @return gambar door
     */
    @Override
    public Image getImage() {
        return this.image;
    }
}
