package basicshooter;

import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import basicgraphics.*;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.console;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    final public static Random RAND = new Random();
    public static Color SHOOTER_COLOR = Color.blue;
    public static Color BULLET_COLOR = Color.blue;
    final public static Color ENEMY_COLOR = Color.red;
    final public static Color EXPLOSION_COLOR = Color.orange;
    final public static int BIG = 20;
    final public static int SMALL = 5;
    final public static int ENEMIES = 8;
    final public static Dimension BOARD_SIZE = new Dimension(1500, 1500);
    public static int shooterHealth = 4;
    public static int level = 0;

    BasicFrame bf = new BasicFrame("Ball Game");
    
//    static ArrayList<health> health = new ArrayList<health>();

    static Picture makeBall(Color color, int size) {
        Image im = BasicFrame.createImage(size, size);
        Graphics g = im.getGraphics();
        g.setColor(color);
        g.fillOval(0, 0, size, size);
        return new Picture(im);
    }

    public static void main(String[] args) throws IOException{
        
       final BasicFrame bf = new BasicFrame("Ball Game");
        final SpriteComponent sc = new SpriteComponent();
        sc.setSize(1500, 1500);
        sc.setPreferredSize(sc.getSize());

        bf.addMenuAction("Help", "Game Instructions", new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(bf.getContentPane(), "Press 1, 2, or 3!");
            }
        });

        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("pressed: " + e.getKeyText(e.getKeyCode()));
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        bf.addKeyListener(kl);
        
//        try{
//        int i = 0;
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter imput file name: ");
//        String fileName = scan.next();
//        
//        File input = new File(fileName);
//        Scanner in = new Scanner(input);
//        
//        
//        while(in.hasNext()){
//            String let = in.next();
//            
//            if(let.compareTo("W") == 0){
//            final Wall w = new Wall();
//            w.init(sc, 50 * i, 30);
//            
//            }
//        }
//        
//        }catch(FileNotFoundException exception){
            
        final Shooter s = new Shooter();
        s.init(sc);

        final Upgrade l = new Upgrade();
        l.init(sc);
        final speedupgrade su = new speedupgrade();
        su.init(sc);
        final doubleshotup ds = new doubleshotup();
        ds.init(sc);

        ArrayList<topwall> walls = new ArrayList<topwall>();
        for (int i = 0; i < 30; i++) {
            final topwall w = new topwall();
            w.init(sc, 50 * i, 30);
            walls.add(w);
        }
        for (int i = 0; i < 30; i++) {
            final topwall w = new topwall();
            w.init(sc, 50 * i, Game.BOARD_SIZE.height - 50);
            walls.add(w);
        } 
        
        ArrayList<sidewall> walls2 = new ArrayList<sidewall>();
        for (int i = 0; i < 30; i++) {
            final sidewall w = new sidewall();
            w.init(sc, 0, 50 * i);
            walls2.add(w);
        }
        for (int i = 0; i < 30; i++) {
            final sidewall w = new sidewall();
            w.init(sc, Game.BOARD_SIZE.width - 50, 50 * i);
            walls2.add(w);
        }

        final Wall w = new Wall();
        w.init(sc, 400, 400);

        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        for (int i = 0; i < ENEMIES; i++) {
            final Enemy e = new Enemy();
            e.init(sc);
            enemies.add(e);
        }

        bf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                Bullet b = new Bullet();
                b.init(sc, s, ke.getKeyCode());
                Control c = new Control();
                c.init(s, ke.getKeyCode());
            }

            public void keyReleased(KeyEvent ke) {
                Control c = new Control();
                c.init2(s, ke.getKeyCode());
                Bullet b = new Bullet();
                b.init2(sc, s, ke.getKeyCode(),5,5);
                Bullet b2 = new Bullet();
                b2.init2(sc, s, ke.getKeyCode(),-5,-5);
            }
        });
        
        final tophud th = new tophud();
        th.init(sc, 0, 0);
        
       
//       for(int i = 0; i < 4; i++){
//       final health h = new health();
//       h.init(sc,10+20*i,5);
//       health.add(h);
//       }

        bf.add("sc", sc, 0, 0, 1, 1);

        bf.show();
        sc.start(0, 10);
    }
   
}

//class upgrade extends Sprite{
//    //SpriteComponent landing;
//    static boolean red = true;
//    static boolean green = false;
//
//    public void init (SpriteComponent sc) throws IOException{
//        setX(350);
//        setY(350);
//        setPicture(new Picture ("landhereyo.png"));
//        sc.addSprite(this);
//    }
//    
//       @Override
//    public void processEvent(SpriteCollisionEvent ev){
//        if (ev.eventType == CollisionEventType.SPRITE) {
//            if(ev.sprite2 instanceof Shooter){
//                red = false;
//                green = true;  
//                setActive(false);
//             
//            }      
//        }  
//    }
//}



//        if (level == 1) {
//            ArrayList<Enemy> enemies = new ArrayList<Enemy>();
//            for (int i = 0; i < ENEMIES * 1; i++) {
//                final Enemy e = new Enemy();
//                e.init(sc);
//                enemies.add(e);
//            }
//        } else if (level == 2) {
//            ArrayList<Enemy> enemies = new ArrayList<Enemy>();
//            for (int i = 0; i < ENEMIES * 2; i++) {
//                final Enemy e = new Enemy();
//                e.init(sc);
//                enemies.add(e);
//            }
//        } else if (level == 3) {
//            ArrayList<Enemy> enemies = new ArrayList<Enemy>();
//            for (int i = 0; i < ENEMIES * 3; i++) {
//                final Enemy e = new Enemy();
//                e.init(sc);
//                enemies.add(e);
//            }
//        }


//                if (e.getKeyCode() == KeyEvent.VK_1) {
//                    level = 1;
//                } else if (e.getKeyCode() == KeyEvent.VK_2) {
//                    level = 2;
//                } else if (e.getKeyCode() == KeyEvent.VK_3) {
//                    level = 3;
//                }
