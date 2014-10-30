/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

//import java.util.LinkedList;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Kelas Chip sebagai player.
 *
 * @author Devi Handevi 2013730015
 */
public class Chip implements Drawable {

    /**
     * Attribute untuk menyimpan posisi absis chip.
     */
    private int x;
    /**
     * Attribute untuk menyimpan posisi ordinat chip.
     */
    private int y;
    /**
     * Attribute untuk menyimpan nilai, apakah chip masih bisa terus main, sudah
     * menang, atau sudah mati. -1 berarti chip kalah, 1 berarti chip menang, 0
     * berarti bukan kedua-duanya.
     */
    private int win; //-1 lose, 0 not yet, 1 win
    /**
     * Attribute untuk menyimpan jumlah IC yang dimiliki.
     */
    private int ICAcquired;
    /**
     * Attribute untuk menyimpan jumlah IC yang diperlukan.
     */
    private final int ICRequired;
    /**
     * Attribute array dari kumpulan key berwarna. [0]Red,[1]Green,[2]Blue
     */
    private int[] coloredKey;
    /**
     * Attribute Image untuk gambar chip.
     */
    private Image image;
    
    /**
     * Constructor untuk membuat objek dari chip.
     *
     * @param x posisi absis awal chip
     * @param y posisi ordinat awal chip
     * @param ICRequired jumlah IC yang dibutuhkan
     * @param keyRequired jumlah key yang dibutuhkan
     */
    public Chip(int x, int y, int ICRequired) {
        this.x = x;
        this.y = y;
        this.ICAcquired = 0;
        this.ICRequired = ICRequired;
        this.win = 0;
        this.coloredKey = new int[3];
        
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("chipgame/images/chip_down2.png"));
        } catch (IOException ex) {
            Logger.getLogger(Chip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method untuk mengecek apakah chip dapat pindah atau tidak.
     *
     * @param object objek yang ingin diinjak
     * @param moveX perubahan x
     * @param moveY perubahan y
     * @return true jika chip dapat bergerak
     */
    public boolean move(TileObject object, int moveX, int moveY) {
        if (object != null && object.canBeStepped() == -1) { //jika objek tidak bisa diinjak
            return false;
        } else {
            if (object == null) { //jika tidak ada objek, langsung pindah
                this.move(moveX, moveY);
            } else {
                if (object.canBeStepped() == 0) { //jika tidak bisa
                    this.move(moveX, moveY);
                } else if (object.canBeStepped() == 1) { //bisa bergerak, tapi mati
                    this.move(moveX, moveY);
                    this.win = -1;
                } else if (object.canBeStepped() == 2) { //bisa bergerak, chip menang
                    this.move(moveX, moveY);
                    this.win = 1;
                } else if (object.canBeStepped() == 3) { //bisa bergerak, dengan syarat tertentu
                    if (object.getClass().equals(Barrier.class)) //jika barrier
                    {
                        if (((Barrier) object).check(this)) {
                            this.move(moveX, moveY);
                        } else {
                            return false;
                        }
                    } else //jika door
                    {
                        if (((Door) object).openDoor(this)) {
                            this.move(moveX, moveY);
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    /**
     * Method untuk menjalankan chip.
     *
     * @param moveX perubahan x
     * @param moveY perubahan y
     */
    private void move(int moveX, int moveY) {
        this.x += moveX;
        this.y += moveY;
    }

    /**
     * Method untuk mendapatkan objek yang di tile. Jika objek tersebut tidak
     * penting untuk pengguna, maka objek tersebut tidak akan dianggap,
     * contohnya pintu.
     *
     * @param object objek yang diambil di tile
     */
    public void takeObject(TileObject object) {
        if (object != null) {
            if (object.getClass().equals(IntegratedCircuit.class)) {
                this.ICAcquired++;
            } else if (object.getClass().equals(Key.class)) {
                Key keyObj = (Key) object;
                if (keyObj.getColor().equals(Color.RED)) {
                    this.coloredKey[0]++;
                } else if (keyObj.getColor().equals(Color.GREEN)) {
                    this.coloredKey[1]++;
                } else if (keyObj.getColor().equals(Color.BLUE)) {
                    this.coloredKey[2]++;
                }
            }
        }
    }

    /**
     * Method untuk mendapatkan IC yang dimiliki chip.
     *
     * @return jumlah IC yang dimiliki
     */
    public int getICAcquired() {
        return this.ICAcquired;
    }

    /**
     * Method untuk mendapatkan IC yang diperlukan.
     *
     * @return jumlah IC yang diperlukan
     */
    public int getICRequired() {
        return this.ICRequired;
    }

    /**
     * Method untuk mendapatkan key yang dimiliki chip.
     *
     * @return jumlah key yang dimiliki
     */
    public int getColoredKeyAcquired(Color color) {
        if(color.equals(Color.RED))
        {
            return this.coloredKey[0];
        }
        else if(color.equals(Color.GREEN))
        {
            return this.coloredKey[1];
        }
        else if(color.equals(Color.BLUE))
        {
            return this.coloredKey[2];
        }
        return 0;
    }

    /**
     * Method untuk mendapatkan key yang diperlukan.
     *
     * @return jumlah key yang diperlukan
     */
    public void useKey(Color color) {
        if(color.equals(Color.RED))
        {
            this.coloredKey[0]--;
        }
        else if(color.equals(Color.GREEN))
        {
            this.coloredKey[1]--;
        }
        else if(color.equals(Color.BLUE))
        {
            this.coloredKey[2]--;
        }
    }

    /**
     * Method untuk mendapatkan posisi x chip.
     *
     * @return posisi x chip
     */
    public int getX() {
        return x;
    }

    /**
     * Method untuk mendapatkan posisi y chip.
     *
     * @return posisi y chip
     */
    public int getY() {
        return y;
    }

    /**
     * Method untuk mengecek kondisi chip masih bisa lanjut permainan atau
     * tidak.
     *
     * @return -1 jika sudah kalah, 1 jika sudah menang, 0 jika belum keduanya
     */
    public int getCondition() {
        return this.win;
    }

    /**
     * Method untuk mendapatkan gambar.
     * @return gambar chip
     */
    @Override
    public Image getImage() {
        return this.image;
    }
}
