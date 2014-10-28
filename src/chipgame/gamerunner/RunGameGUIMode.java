/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chipgame.gamerunner;

import chipgame.board.Board;
import chipgame.tiles.Barrier;
import chipgame.tiles.Chip;
import chipgame.tiles.Door;
import chipgame.tiles.Finish;
import chipgame.tiles.Fire;
import chipgame.tiles.IntegratedCircuit;
import chipgame.tiles.Key;
import chipgame.tiles.TileObject;
import chipgame.tiles.Wall;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author Riky Setiawan 2013730041
 */
public class RunGameGUIMode extends JPanel {

    private final Board board = new Board();
    private static int WINDOWSIZE_WIDTH = 485;
    private static int WINDOWSIZE_HEIGHT = 500;
    
    private URL url;
    private Image imgChip;
    private Image imgTile;
    private Image imgWall;
    private Image imgBarrier;
    private Image imgFinish;
    private Image imgFire;
    private Image imgIC;
    private Image imgDoor;
    private Image imgRedKey;
    private Image imgGreenKey;
    private Image imgBlueKey;

    /*
    REMINDER!!!!!
    Hilangkan semua attribute gambar dan URL
    method getImage hilangkan
    JANGAN ada if Chip, print something
    Chip di print setelah tiles sudah di print semua
    pemanggilan image dapat dilakukan dengan cara for(Drawable d: get all blablabla)
    cari di google
    */      
    
    public RunGameGUIMode() {
        setFocusable(true);
        KeyListener listener = new KeyListener();
        addKeyListener(listener);
        
        imgChip = this.getImage("chipgame/images/chip.jpg");
        imgTile = this.getImage("chipgame/images/tile.jpg");
        imgWall = this.getImage("chipgame/images/wall.jpg");
        imgBarrier = this.getImage("chipgame/images/barrier.jpg");
        imgFinish = this.getImage("chipgame/images/finish.jpg");
        imgFire = this.getImage("chipgame/images/fire.jpg");
        imgIC = this.getImage("chipgame/images/IC.jpg");
        imgDoor = this.getImage("chipgame/images/door.jpg");
        imgRedKey = this.getImage("chipgame/images/keyred.jpg");
        imgGreenKey = this.getImage("chipgame/images/keygreen.jpg");
        imgBlueKey = this.getImage("chipgame/images/keyblue.jpg");
        
    }
    
    private Image getImage(String urlString) {
        url = getClass().getClassLoader().getResource(urlString);
        try {
            return ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(RunGameGUIMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
            } else if (board.getCondition() == 1) {
                System.out.println("WIN");
            } else {
                System.out.println("LOSE");
            }
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        //Draw
        for (int i = 0; i < this.board.lengthBoard(); i++) {
            for (int j = 0; j < this.board.lengthBoard(); j++) {
                TileObject steppedObject = this.board.getArrayOfTile()[i][j].getWhatIsStepped();
                if (board.getChip().getX() == j && board.getChip().getY() == i) {
                    g2d.drawImage(imgChip, j * 48, i * 48, this);
                } else if (steppedObject == null) {
                    g2d.drawImage(imgTile, j * 48, i * 48, this);
                } else if (steppedObject.getClass().equals(Wall.class)) {
                    g2d.drawImage(imgWall, j * 48, i * 48, this);
                } else if (steppedObject.getClass().equals(Barrier.class)) {
                    g2d.drawImage(imgBarrier, j * 48, i * 48, this);
                } else if (steppedObject.getClass().equals(Finish.class)) {
                    g2d.drawImage(imgFinish, j * 48, i * 48, this);
                } else if (steppedObject.getClass().equals(Fire.class)) {
                    g2d.drawImage(imgFire, j * 48, i * 48, this);
                } else if (steppedObject.getClass().equals(IntegratedCircuit.class)) {
                    g2d.drawImage(imgIC, j * 48, i * 48, this);
                } else if (steppedObject.getClass().equals(Door.class)) {
                    g2d.drawImage(imgDoor, j * 48, i * 48, this);
                } else if (steppedObject.getClass().equals(Key.class)) {
                    Key key = (Key)steppedObject;
                    if(key.getColor().equals(Color.red)) {
                        g2d.drawImage(imgRedKey, j * 48, i * 48, this);
                    } else if (key.getColor().equals(Color.green)) {
                        g2d.drawImage(imgGreenKey, j * 48, i * 48, this);
                    } else if (key.getColor().equals(Color.blue)) {
                        g2d.drawImage(imgBlueKey, j * 48, i * 48, this);
                    }
                    
                }
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
