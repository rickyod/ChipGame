/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Shoes sebagai objek yang dapat di taruh di ubin yang dapat diambil dan dapat diinjak. Menginjak sama dengan mengambil.
 * Shoes adalah objek yang dapat memberikan kemampuan khusus pada pemilik, 
 * yaitu pemilik akan kebal terhadap elemen tergantung dengan warna dari shoes.
 * Shoes berwarna merah adalah sepatu yang kebal terhadap api.
 * Shoes berwarna biru adalah sepatu yang kebal terhadap air.
 * 
 * @author Devi Handevi 2013730015
 */
public class Shoes extends TileObject {
    
    /**
     * Atribut warna dari sepatu (Red , Blue)
     */
    private Color color;

    /**
     * Constructor untuk membuat sepatu berdasarkan warna
     * @param color warna
     */
    public Shoes(Color color) {
        this.image = new Image[1];
        this.color = color;
        
        if (this.color.equals(Color.RED)) {
            this.image[0] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/shoes_red.png")).getImage();
        } else if (this.color.equals(Color.BLUE)) {
            this.image[0] = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/shoes_blue.png")).getImage();
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
     * @return warna sepatu
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Method untuk mendapatkan gambar.
     *
     * @return gambar sepatu
     */
    @Override
    public Image getImage() {
        return this.image[0];
    }
}
