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
public class Key extends TileObject {

    public Key() {
        try {
            this.image = ImageIO.read(new URL("chipgame/images/key.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Key.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Atribut warna dari key
     * (Red , Green , Blue)
     */
    private Color color;
    
    public Key(Color color)
    {
        this.color = color;
    }
    
    /**
     * Method untuk mengecek apakah objek ini dapat diinjak atau tidak.
     * @return 0, berarti bisa langsung diinjak
     */
    @Override
    public int canBeStepped() 
    {
        return 0;
    }

    /**
     * Method untuk mengecek apakah objek ini dapat diambil atau tidak.
     * @return true, berarti bisa
     */
    @Override
    public boolean canBeTaken() 
    {
        return true;
    }
    
    /**
     * Method untuk mendapatkan warna dari kunci.
     * @return warna kunci
     */
    public Color getColor()
    {
        return this.color;
    }
    
    /**
     * Method untuk mendapatkan gambar.
     * @return gambar key
     */
    @Override
    public Image getImage() {
        return this.image;
    }
}
