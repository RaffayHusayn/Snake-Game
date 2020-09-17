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
        draw(g);

    }

    public void draw(Graphics g){
        for(int i=0; i<SCREEN_HEIGHT/UNIT_SIZE; i++){
            g.drawLine(i*UNIT_SIZE, 0 , i*UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
        }
        g.setColor(Color.yellow);
        g.fillRect(appleX,appleY, UNIT_SIZE, UNIT_SIZE);

        //drawing snake

        for(int i=0 ; i<bodyParts; i++){
            if(i==0){
                //head of the snake
                g.setColor(new Color(38, 105, 18));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
            else{
                //body of the snake
                g.setColor(new Color(54, 153, 22));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

            }
        }

    }

    public void newApple(){
        //generates a new apple
        appleX = random.nextInt((int)SCREEN_WIDTH / UNIT_SIZE)*UNIT_SIZE;
        appleY = random.nextInt((int)SCREEN_HEIGHT / UNIT_SIZE)*UNIT_SIZE;
    }

    public void move(){
        for(int i = bodyParts; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch (direction) {
//up
            case 'U' -> y[0] = y[0] - UNIT_SIZE;
//down
            case 'D' -> y[0] = y[0] + UNIT_SIZE;
//right
            case 'R' -> x[0] = x[0] + UNIT_SIZE;
//left
            case 'L' -> x[0] = x[0] - UNIT_SIZE;
        }

    }

    public void checkApple(){


    }
    public void checkCollisions(){
       //collision with the body of the snake itself
        for(int i=bodyParts; i>0; i--){
            if((x[0]==x[i]) && (y[0]==y[i])){
                running = false; //game over
            }
        }

        //collision with the left border
        if(x[0] < 0 ){
            running = false;
        }
        //collision with the right border
        if(x[0] > SCREEN_WIDTH ){
            running = false;
        }
        //collision with the top border
        if(y[0] < 0 ){
            running = false;
        }
        //collision with the bottom border
        if(y[0] > SCREEN_HEIGHT ){
            running = false;
        }

        if(!running){
            timer.stop();
        }


    }

    public void gameOver(Graphics g){


    }

    //internal class
    public class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){

                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U'){
                        direction = 'D';
                    }
                    break;

            }

        }
    }

   //implementing Action Listener methods
    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }
}
