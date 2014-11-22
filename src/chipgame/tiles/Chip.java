/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

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
     * Attribute array dari kumpulan key berwarna.
     * [0]Red,[1]Green,[2]Blue,[3]Yellow
     */
    private boolean[] coloredKey;
    /**
     * Attribute untuk sepatu milik chip. [0]Red, [1]Blue
     */
    private Shoes[] shoes;
    /**
     * Attribute Image untuk gambar chip.
     */
    private Image image;
    private Image up; //chip menghadap ke atas
    private Image down; //chip menghadap ke bawah
    private Image left; //chip menghadap ke kiri
    private Image right; //chip menghadap ke kanan
    private Image burnt; //chip terbakar
    private Image drown; //chip tercebur

    /**
     * Constructor untuk membuat objek dari chip.
     *
     * @param x posisi absis awal chip
     * @param y posisi ordinat awal chip
     * @param ICRequired jumlah IC yang dibutuhkan
     */
    public Chip(int x, int y, int ICRequired) {
        this.x = x;
        this.y = y;
        this.ICAcquired = 0;
        this.ICRequired = ICRequired;
        this.win = 0;
        this.coloredKey = new boolean[4];
        this.shoes = new Shoes[2];

        this.up = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/chip_up2.PNG")).getImage();
        this.down = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/chip_down2.PNG")).getImage();
        this.left = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/chip_left2.PNG")).getImage();
        this.right = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/chip_right2.PNG")).getImage();
        this.burnt = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/chip_burnt.png")).getImage();
        this.drown = new ImageIcon(getClass().getClassLoader().getResource("chipgame/images/chip_drown.png")).getImage();
        
        this.image = this.down;
    }

    /**
     * Method untuk mengecek apakah chip dapat pindah atau tidak.
     *
     * @param object objek yang ingin diinjak
     * @param moveX perubahan x (-1 kiri, 0 tetap, 1 kanan)
     * @param moveY perubahan y (-1 atas, 0 tetap, 1 bawah)
     * @return true jika chip dapat bergerak
     */
    public boolean move(TileObject object, int moveX, int moveY) {
        this.changeDirection(moveX, moveY);
        if (object != null && object.canBeStepped() == -1) { //jika objek tidak bisa diinjak
            return false;
        } else {
            if (object == null) { //jika tidak ada objek, langsung pindah
                this.move(moveX, moveY);
            } else {
                if (object.canBeStepped() == 0) { //jika tidak bisa
                    this.move(moveX, moveY);
                } else if (object.canBeStepped() == 1) { //bisa bergerak, namun jika tidak ada sepatu khusus, chip mati
                    this.move(moveX, moveY);
                    if (object.getClass().equals(Fire.class)) {
                        if (!((Fire) object).check(this)) { //jika api dan tidak ada sepatu, terbakar
                            this.image = this.burnt;
                            this.win = -1;
                        }
                    } else if (object.getClass().equals(Water.class)) { //jika air dan tidak ada sepatu, tenggelam
                        if (!((Water) object).check(this)) {
                            this.image = this.drown;
                            this.win = -1;
                        }
                    }
                } else if (object.canBeStepped() == 2) { //bisa bergerak, chip menang
                    this.move(moveX, moveY);
                    this.win = 1;
                } else if (object.canBeStepped() == 3) { //bisa bergerak, dengan syarat tertentu
                    if (object.getClass().equals(Barrier.class)) { //jika barrier
                        if (((Barrier) object).check(this)) {
                            this.move(moveX, moveY);
                        } else {
                            return false;
                        }
                    } else if (object.getClass().equals(Door.class)) { //jika door
                        if (((Door) object).check(this)) {
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
     * Method untuk mengubah arah hadapan chip.
     *
     * @param moveX perubahan x
     * @param moveY perubahan y
     */
    private void changeDirection(int moveX, int moveY) {
        if (moveX > 0) {
            this.image = right;
        } else if (moveX < 0) {
            this.image = left;
        } else if (moveY > 0) {
            this.image = down;
        } else if (moveY < 0) {
            this.image = up;
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
     * @param object objek yang akan diambil di tile
     * @return object objek yang diambil di tile
     */
    public TileObject takeObject(TileObject object) {
        if (object != null) {
            if (object.getClass().equals(IntegratedCircuit.class)) {
                this.ICAcquired++;
            } else if (object.getClass().equals(Key.class)) {
                Key keyObj = (Key) object;
                if (keyObj.getColor().equals(Color.RED)) {
                    this.coloredKey[0] = true;
                } else if (keyObj.getColor().equals(Color.GREEN)) {
                    this.coloredKey[1] = true;
                } else if (keyObj.getColor().equals(Color.BLUE)) {
                    this.coloredKey[2] = true;
                } else { //YELLOW
                    this.coloredKey[3] = true; 
                }
            } else if (object.getClass().equals(Shoes.class)) {
                Shoes shoesObj = (Shoes) object;
                if (shoesObj.getColor().equals(Color.RED)) {
                    this.shoes[0] = shoesObj;
                } else if (shoesObj.getColor().equals(Color.BLUE)) {
                    this.shoes[1] = shoesObj;
                }
            }
        }
        return object;
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
     * @param color Color dari key
     * @return jumlah key yang dimiliki
     */
    public boolean hasColoredKey(Color color) {
        if (color.equals(Color.RED)) {
            return this.coloredKey[0];
        } else if (color.equals(Color.GREEN)) {
            return this.coloredKey[1];
        } else if (color.equals(Color.BLUE)) {
            return this.coloredKey[2];
        } else if (color.equals(Color.YELLOW)) {
            return this.coloredKey[3];
        }
        return false;
    }

    /**
     * Method untuk memeriksa apakah chip memiliki sepatu dengan warna tertentu.
     *
     * @param color warna
     * @return true jika ada
     */
    public boolean hasShoes(Color color) {
        if (color.equals(Color.RED)) {
            return !(this.shoes[0] == null);
        } else if (color.equals(Color.BLUE)) {
            return !(this.shoes[1] == null);
        }
        return false;
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
     *
     * @return gambar chip
     */
    @Override
    public Image getImage() {
        return this.image;
    }
}
