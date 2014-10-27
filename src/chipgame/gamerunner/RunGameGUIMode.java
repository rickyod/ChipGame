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
public class RunGameGUIMode extends JPanel 
{
    private final Board board = new Board();
    private static int WINDOWSIZE_WIDTH=485;
    private static int WINDOWSIZE_HEIGHT=500;
    
    public RunGameGUIMode() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                
                if (board.getCondition() == 0) {
                    if (evt.getKeyCode() == KeyEvent.VK_LEFT||evt.getKeyCode() == KeyEvent.VK_A) {
                        board.move("a");
                    } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT||evt.getKeyCode() == KeyEvent.VK_D) {
                        board.move("d");
                    } else if (evt.getKeyCode() == KeyEvent.VK_DOWN||evt.getKeyCode() == KeyEvent.VK_S) {
                        board.move("s");
                    } else if (evt.getKeyCode() == KeyEvent.VK_UP||evt.getKeyCode() == KeyEvent.VK_W) {
                        board.move("w");
                    }
                }
                else if (board.getCondition() == 1)
                {
                    System.out.println("WIN");
                }
                else 
                {
                    System.out.println("LOSE");
                }
                repaint();
                
                
            }
        });
    }
  
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Image imgChip=null;
        //Chip Image
        URL imgUrlChip = getClass().getClassLoader().getResource("chipgame/images/chip.jpg");
        try 
        {
            imgChip= ImageIO.read(imgUrlChip);
        } catch (IOException ex) 
        {
            Logger.getLogger(RunGameGUIMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Tile Image
        Image imgTile=null;
        URL imgUrlTile = getClass().getClassLoader().getResource("chipgame/images/tile.jpg");
        try 
        {
            imgTile= ImageIO.read(imgUrlTile);
        } catch (IOException ex) 
        {
            Logger.getLogger(RunGameGUIMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Wall Image
        Image imgWall=null;
        URL imgUrlWall = getClass().getClassLoader().getResource("chipgame/images/wall.jpg");
        try 
        {
            imgWall= ImageIO.read(imgUrlWall);
        } catch (IOException ex) 
        {
            Logger.getLogger(RunGameGUIMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Barrier Image
        Image imgBarrier=null;
        URL imgUrlBarrier = getClass().getClassLoader().getResource("chipgame/images/barrier.jpg");
        try 
        {
            imgBarrier= ImageIO.read(imgUrlBarrier);
        } catch (IOException ex) 
        {
            Logger.getLogger(RunGameGUIMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Finish Image
        Image imgFinish=null;
        URL imgUrlFinish = getClass().getClassLoader().getResource("chipgame/images/finish.jpg");
        try 
        {
            imgFinish= ImageIO.read(imgUrlFinish);
        } catch (IOException ex) 
        {
            Logger.getLogger(RunGameGUIMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fire Image
        Image imgFire=null;
        URL imgUrlFire = getClass().getClassLoader().getResource("chipgame/images/fire.jpg");
        try 
        {
            imgFire= ImageIO.read(imgUrlFire);
        } catch (IOException ex) 
        {
            Logger.getLogger(RunGameGUIMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        //IC Image
        Image imgIC=null;
        URL imgUrlIC = getClass().getClassLoader().getResource("chipgame/images/IC.jpg");
        try 
        {
            imgIC= ImageIO.read(imgUrlIC);
        } catch (IOException ex) 
        {
            Logger.getLogger(RunGameGUIMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Door Image
        Image imgDoor=null;
        URL imgUrlDoor = getClass().getClassLoader().getResource("chipgame/images/door.jpg");
        try 
        {
            imgDoor= ImageIO.read(imgUrlDoor);
        } catch (IOException ex) 
        {
            Logger.getLogger(RunGameGUIMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Key Image
        Image imgKey=null;
        URL imgUrlKey = getClass().getClassLoader().getResource("chipgame/images/keygreen.jpg");
        try 
        {
            imgKey= ImageIO.read(imgUrlKey);
        } catch (IOException ex) 
        {
            Logger.getLogger(RunGameGUIMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Draw
        for (int i = 0; i < this.board.lengthBoard(); i++) 
        {
            for (int j = 0; j < this.board.lengthBoard(); j++) 
            {
                TileObject steppedObject = this.board.getArrayOfTile()[i][j].getWhatIsStepped();
                if(board.getChip().getX()==j&&board.getChip().getY()==i)
                {
                    g2d.drawImage(imgChip, j*48, i*48, this);
                }
                else if(steppedObject==null)
                {
                    g2d.drawImage(imgTile, j*48, i*48, this);
                }
                else if(steppedObject.getClass().equals(Wall.class))
                {
                    g2d.drawImage(imgWall, j*48, i*48, this);
                }
                else if(steppedObject.getClass().equals(Barrier.class))
                {
                    g2d.drawImage(imgBarrier, j*48, i*48, this);
                }
                else if(steppedObject.getClass().equals(Finish.class))
                {
                    g2d.drawImage(imgFinish, j*48, i*48, this);
                }
                else if(steppedObject.getClass().equals(Fire.class))
                {
                    g2d.drawImage(imgFire, j*48, i*48, this);
                }
                else if(steppedObject.getClass().equals(IntegratedCircuit.class))
                {
                    g2d.drawImage(imgIC, j*48, i*48, this);
                }
                else if(steppedObject.getClass().equals(Door.class))
                {
                    g2d.drawImage(imgDoor, j*48, i*48, this);
                }
                else if(steppedObject.getClass().equals(Key.class))
                {
                    g2d.drawImage(imgKey, j*48, i*48, this);
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
