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
        String move;
        int condition;
        
        while(true) {
            System.out.print(board.getCurrentBoardCondition());
            move = sc.next();
            board.move(move);
            
            condition = board.getCondition();
            if(condition!=0) {
                System.out.print(board.getCurrentBoardCondition());
                if(condition==1) {
                    System.out.println("WIN");
                } else {
                    System.out.println("LOSE");
                }
                break;
            }
        }
    }
}
