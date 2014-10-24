/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Color;

/**
 *
 * @author Devi
 */
public class Key extends TileObject {

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
}
