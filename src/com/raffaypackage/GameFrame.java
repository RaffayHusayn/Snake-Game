package com.raffaypackage;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
        //Constructor
        public GameFrame(){
            GamePanel panel = new GamePanel();
            this.add(panel); //object of our other class
            this.setTitle("Snake Game");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.pack(); //fit everything  snuggly in the frame
            this.setVisible(true);
            this.setLocationRelativeTo(null); //shows the window in the middle of the screen
        }
}
