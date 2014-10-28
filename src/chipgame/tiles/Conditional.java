/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

/**
 * Sebuah interface yang menandakan bahwa kelas yang mengimplemen membutuhkan
 * persyaratan dalam melakukan sesuatu.
 *
 * @author Devi
 */
public interface Conditional {

    /**
     * Method untuk mengecek apakah persyaratan sudah terpenuhi atau belum.
     *
     * @param chip player
     * @return true jika layak, false jika sebaliknya
     */
    public boolean check(Chip chip);
}
