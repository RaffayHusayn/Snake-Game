package com.raffaypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel  extends JPanel implements ActionListener{
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE =25; //size of things in the game
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75;//speed of the game

    //body parts of the snake position
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];

    //snake size at the start
    int bodyParts = 6;
    //snake direction at the start
    char direction = 'R'; //snake going right

    //score or apples eaten by the snake
    int applesEaten;

    //apples location
    int appleX;
    int appleY;


    boolean running = false;
    Timer timer;
    Random random;



    //Constructor
    public GamePanel(){

        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();

    }

    public void startGame(){
        newApple();
        running = true; //game starts
        timer = new Timer(DELAY, this); //this sets the speed of the games
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }

    public void draw(Graphics g){


    }

    public void newApple(){


    }

    public void move(){


    }

    public void checkApple(){


    }
    public void checkCollisions(){


    }

    public void gameOver(Graphics g){


    }

    //internal class
    public class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
//            super.keyPressed(e);

        }
    }

   //implementing Action Listener methods
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
