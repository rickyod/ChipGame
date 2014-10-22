/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.level;

import java.util.Scanner;

/**
 * Kelas Main untuk menjalankan game dalam wujud text (Text Mode Game).
 * @author Devi Handevi 2013730015
 */
public class RunGameTextMode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        board.startGameTextMode();
    }
}
