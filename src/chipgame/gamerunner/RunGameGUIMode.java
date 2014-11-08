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
import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author Riky Setiawan 2013730041
 */
public class RunGameGUIMode extends JPanel {

    private final Board board = new Board();
    private final int tileSize;
    private static int WINDOWSIZE_WIDTH = 485;
    private static int WINDOWSIZE_HEIGHT = 500;
   
    public RunGameGUIMode() {
        setFocusable(true);
        KeyListener listener = new KeyListener();
        addKeyListener(listener);
        this.tileSize = 48;
    }
    

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
            }
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Image img = null;
        //Draw
        for (int i = 0; i < this.board.getWidth(); i++) {
            for (int j = 0; j < this.board.getLength(); j++) {
                img = this.board.getArrayOfTile()[i][j].getImage();
                g2d.drawImage(img,j*tileSize,i*tileSize,this);
            }     
        }
        if(this.board.getCondition()!=-1)
        {
            g2d.drawImage(board.getChip().getImage(), board.getChip().getX() * tileSize, board.getChip().getY() * tileSize, this); 
        }
        if (this.board.getCondition() == 1 || this.board.getCondition() == -1) 
        {
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 48));
            if (this.board.getCondition() == 1) 
            {
                g2d.drawString("YOU WIN!",getWidth()/4,getHeight()/2);
            }
            else 
            {
                g2d.drawString("YOU LOSE!",getWidth()/4,getHeight()/2);
            }
        }
    }

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
