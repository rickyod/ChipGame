/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.gamerunner;

import chipgame.board.Board;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JPanel;

/**
 * Kelas yang mempunyai objek board sebagai papan permainan dan mengatur Graphic User Interface(GUI) dari permainan.
 * 
 * @author Riky Setiawan 2013730041
 * @author Devi Handevi 2013730015
 */
public class RunGameGUIMode extends JPanel {

    /**
     * Attribute papan permainan.
     */
    private final Board board;
    /**
     * Attribute besar ubin.
     */
    private final int tileSize;
    /**
     * Attribute lebar window permainan dengan papan yang tidak utuh.
     */
    private static final int WINDOWSIZE_WIDTH = 648;
    /**
     * Attribute tinggi window permainan dengan papan yang tidak utuh.
     */
    private static final int WINDOWSIZE_HEIGHT = 480;

    /**
     * Constructor untuk permainan chip.
     */
    public RunGameGUIMode() {
        setBackground(Color.black);
        setFocusable(true);
        KeyListener listener = new KeyListener();
        addKeyListener(listener);
        this.board = new Board();
        this.tileSize = 48;
    }

    /**
     * Kelas inner khusus untuk listener permainan.
     */
    private class KeyListener extends KeyAdapter {

        /**
         * Method untuk mengubah posisi chip saat tombol ditekan.
         * @param evt
         */
        @Override
        public void keyPressed(KeyEvent evt) {
            if (board.getCondition() == 0) {
                if (evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_A) {
                    board.move("a");
                } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_D) {
                    board.move("d");
                } else if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_S) {
                    board.move("s");
                } else if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_W) {
                    board.move("w");
                }
            } else if (board.getCondition() == 1){//&&!board.endGame()) {
                if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                    board.getNextLevel();
                }
            } else if (board.getCondition() == -1) {
                if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                    board.reset();
                }
            }
            repaint();
        }
    }

    /**
     * Method untuk menggambar kondisi papan dan lainnya.
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        //Draw Map
        int pointerX = this.board.getChip().getX() - 4;
        int pointerY = this.board.getChip().getY() - 4;
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                g2d.drawImage(this.board.getArrayOfTile()[i + pointerX][j + pointerY].getImage(), i * tileSize, j * tileSize, this);
            }
        }
        
        //Draw Chip
        g2d.drawImage(board.getChip().getImage(), 192, 192, this);
        
        //Draw Info
        g2d.setColor(Color.white);
        g2d.setFont(new Font("Calibri", Font.BOLD, 15));
        g2d.drawString("Level "+this.board.getIndexLevel(), 440, 40);
        g2d.drawString("Chips left  : "+(this.board.getChip().getICRequired()-this.board.getChip().getICAcquired()), 440, 60);
        
        //Draw Inventory
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                g2d.drawImage(this.board.getArrayOfInventory()[i][j].getImage(), i * tileSize + 440, j * tileSize + 100, this);
            }
        }
        
        //Draw Another Info
        if (this.board.getCondition() != 0) {
            g2d.setColor(Color.WHITE);
            if (this.board.getCondition() == 1) {
                g2d.setFont(new Font("Arial", Font.BOLD, 37));
                g2d.drawString("YOU WIN!", 450, 300);
                g2d.setFont(new Font("Arial", Font.BOLD, 11));
                g2d.drawString("PRESS SPACE TO CONTINUE", 144, 442);
            } else { // == -1
                g2d.setFont(new Font("Arial", Font.BOLD, 11));
                g2d.drawString("PRESS SPACE TO RESTART THIS LEVEL", 114, 442);
            }
        }

        //sleep agar animasi tidak terlalu cepat
        try {
            Thread.sleep(45);
        } catch (InterruptedException ex) {
            Logger.getLogger(RunGameGUIMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint(); //pemanggilan method ini lagi
    }

    /**
     * Method main untuk menjalankan program.
     * @param args 
     */
    public static void main(String[] args) {
        JFrame game = new JFrame();
        game.setTitle("Chip's Challenge");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(WINDOWSIZE_WIDTH, WINDOWSIZE_HEIGHT);
        game.setResizable(false);
        game.add(new RunGameGUIMode());
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
