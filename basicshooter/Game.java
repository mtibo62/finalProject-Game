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
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Game {

    final public static Random RAND = new Random();
    public static Color SHOOTER_COLOR = Color.blue;
    public static Color BULLET_COLOR = Color.blue;
    final public static Color ENEMY_COLOR = Color.red;
    final public static Color EXPLOSION_COLOR = Color.orange;
    final public static int BIG = 20;
    final public static int SMALL = 5;
    final public static int ENEMIES = 50;
    final public static Dimension BOARD_SIZE = new Dimension(1500, 1500);
    public static int shooterHealth = 4;

    BasicFrame bf = new BasicFrame("Shooter!");

    static Picture makeBall(Color color, int size) {
        Image im = BasicFrame.createImage(size, size);
        Graphics g = im.getGraphics();
        g.setColor(color);
        g.fillOval(0, 0, size, size);
        return new Picture(im);
    }

    public static void main(String[] args) throws IOException {
        final BasicFrame bf = new BasicFrame("Lunar Lander");
        final SpriteComponent sc = new SpriteComponent();
        sc.setSize(1500, 1500);
        sc.setPreferredSize(sc.getSize());
        
        bf.addMenuAction("Help", "Game Instructions", new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(bf.getContentPane(), "Play the Game!");
            }
        });

        final Shooter s = new Shooter();
        s.init(sc);

        final Upgrade l = new Upgrade();
        l.init(sc);

        final speedupgrade su = new speedupgrade();
        su.init(sc);

        ArrayList<Wall> walls = new ArrayList<Wall>();
        for (int i = 0; i < 30; i++) {
            final Wall w = new Wall();
            w.init(sc, 50 * i, 30);
            walls.add(w);
        }
        for (int i = 0; i < 30; i++) {
            final Wall w = new Wall();
            w.init(sc, 50 * i, Game.BOARD_SIZE.height - 50);
            walls.add(w);
        }

        for (int i = 0; i < 30; i++) {
            final Wall w = new Wall();
            w.init(sc, 0, 50 * i);
            walls.add(w);
        }
        for (int i = 0; i < 30; i++) {
            final Wall w = new Wall();
            w.init(sc, Game.BOARD_SIZE.width - 50, 50 * i);
            walls.add(w);
        }

        final Wall w = new Wall();
        w.init(sc, 400, 400);

        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        for (int i = 0; i < ENEMIES; i++) {
            final Enemy e = new Enemy();
            e.init(sc);
            enemies.add(e);
        }

        final tophud h = new tophud();
        h.init(sc, 0, 0);

        bf.add("sc", sc, 0, 0, 1, 1);

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
            }
        });

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
