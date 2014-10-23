/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.tiles;

//import java.util.LinkedList;
/**
 * Kelas Chip sebagai player.
 *
 * @author Devi Handevi 2013730015
 */
public class Chip {

    /**
     * Attribute untuk menyimpan posisi absis chip.
     */
    private int x;
    /**
     * Attribute untuk menyimpan posisi ordinat chip.
     */
    private int y;
    /**
     * Attribute untuk menyimpan nilai, apakah chip masih bisa terus main, sudah menang, atau sudah mati.
     * -1 berarti chip kalah, 1 berarti chip menang, 0 berarti bukan kedua-duanya.
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
     * Attribute untuk menyimpan jumlah key yang dimiliki.
     */
    private int keyAcquired;
    /**
     * Attribute untuk menyimpan jumlah key yang diperlukan.
     */
    private final int keyRequired;
    
    //!!! disini perlu perubahan
    //ganti persyaratan key dan door juga
    //jika key merah, door merah terbuka
    //tidak perlu ada jumlah key yang dibutuhkan untuk suatu door
    //key menggunakan array 1D, dengan panjang 3 (?) untuk warna (mis. R G B)
    //tambah setiap mendapatkan key
    //kurang setiap membuka door
    //jangan lupa hilangkan yang if if untuk key yang lama
    //perlu getter jumlah kunci sesuai warna
    //cek juga di board karena ada keyRequired

    /**
     * Constructor untuk membuat objek dari chip.
     * @param x posisi absis awal chip
     * @param y posisi ordinat awal chip
     * @param ICRequired jumlah IC yang dibutuhkan
     * @param keyRequired jumlah key yang dibutuhkan
     */
    public Chip(int x, int y, int ICRequired, int keyRequired) {
        this.x = x;
        this.y = y;
        this.ICAcquired = 0;
        this.ICRequired = ICRequired;
        this.keyAcquired = 0;
        this.keyRequired = keyRequired;
        this.win = 0;
    }

    /**
     * Method untuk mengecek apakah chip dapat pindah atau tidak.
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
                    if(object.getClass().equals(Barrier.class)) //jika barrier
                    { if(((Barrier)object).check(this)) { this.move(moveX, moveY); } else { return false; } }
                    else //jika door
                    { if(((Door)object).check(this)) { this.move(moveX, moveY); } else { return false; } }
                }
            }
            return true;
        }
    }

    /**
     * Method untuk menjalankan chip.
     * @param moveX perubahan x
     * @param moveY perubahan y
     */
    private void move(int moveX, int moveY) {
        this.x += moveX;
        this.y += moveY;
    }

    /**
     * Method untuk mendapatkan objek yang diambil.
     * Jika objek tersebut tidak penting untuk pengguna, maka objek tersebut tidak akan dianggap, contohnya pintu.
     * @param object objek yang diambil di ubin
     */
    public void addObject(TileObject object) {
        if (object != null) {
            if(object.getClass().equals(IntegratedCircuit.class)) { this.ICAcquired++; }
            else if(object.getClass().equals(Key.class)) { this.keyAcquired++; }
        }
    }

    /**
     * Method untuk mendapatkan IC yang dimiliki chip.
     * @return jumlah IC yang dimiliki
     */
    public int getICAcquired() {
        return this.ICAcquired;
    }

    /**
     * Method untuk mendapatkan IC yang diperlukan.
     * @return jumlah IC yang diperlukan
     */
    public int getICRequired() {
        return this.ICRequired;
    }

    /**
     * Method untuk mendapatkan key yang dimiliki chip.
     * @return jumlah key yang dimiliki
     */
    public int getKeyAcquired() {
        return keyAcquired;
    }

    /**
     * Method untuk mendapatkan key yang diperlukan.
     * @return jumlah key yang diperlukan
     */
    public int getKeyRequired() {
        return keyRequired;
    }

    /**
     * Method untuk mendapatkan posisi x chip.
     * @return posisi x chip
     */
    public int getX() {
        return x;
    }

    /**
     * Method untuk mendapatkan posisi y chip.
     * @return posisi y chip
     */
    public int getY() {
        return y;
    }

    /**
     * Method untuk mengecek kondisi chip masih bisa lanjut permainan atau tidak.
     * @return -1 jika sudah kalah, 1 jika sudah menang, 0 jika belum keduanya
     */
    public int getCondition() {
        return this.win;
    }
}
