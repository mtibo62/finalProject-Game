 package basicgraphics.images;
import basicflyer.Falcon;
import basicflyer.Plasma;
import basicgraphics.*;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Math.abs;
import javax.swing.JOptionPane;
import static java.lang.Math.abs;

public class Project {

    
 public static void main(String[] args) throws IOException{
        BasicFrame bf = new BasicFrame("Lunar Lander");
        final SpriteComponent sc = new SpriteComponent();
        sc.setSize(1000,1000);
        sc.setPreferredSize(sc.getSize());
        final shooter Shooter = new shooter();
        Shooter.init(sc);
        upgrade l = new upgrade();
        l.init(sc);
        bf.add("sc", sc, 0,0,1,1);
        



        bf.addKeyListener(new KeyAdapter() {   
            @Override
            public void keyPressed(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Shooter.setVelX(3);
                } else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    Shooter.setVelX(-3);
                } else if(ke.getKeyCode() == KeyEvent.VK_UP) {
                    Shooter.setVelY(-3);
                }else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    Shooter.setVelY(3);
                }else if(upgrade.red == true){
                    switch (ke.getKeyCode()) {
                        case KeyEvent.VK_W:
                            {
                                Plasma pl = new Plasma();
                                pl.setVelY(-5);
                                pl.setX(Shooter.getX()+Shooter.getWidth()*.5);
                                pl.setY(Shooter.getY()+Shooter.getHeight()*.5);
                                pl.init(sc);
                                sc.addSprite(pl);
                                break;
                            }
                        case KeyEvent.VK_D:
                            {
                                Plasma pl = new Plasma();
                                pl.setVelX(5);
                                pl.setX(Shooter.getX()+Shooter.getWidth()*.5);
                                pl.setY(Shooter.getY()+Shooter.getHeight()*.5);
                                pl.init(sc);
                                sc.addSprite(pl);
                                break;
                            }
                        case KeyEvent.VK_S:
                            {
                                Plasma pl = new Plasma();
                                pl.setVelY(5);
                                pl.setX(Shooter.getX()+Shooter.getWidth()*.5);
                                pl.setY(Shooter.getY()+Shooter.getHeight()*.5);
                                pl.init(sc);
                                sc.addSprite(pl);
                                break;
                            }
                        case KeyEvent.VK_A:
                            {
                                Plasma pl = new Plasma();
                                pl.setVelX(-5);
                                pl.setX(Shooter.getX()+Shooter.getWidth()*.5);
                                pl.setY(Shooter.getY()+Shooter.getHeight()*.5);
                                pl.init(sc);
                                sc.addSprite(pl);
                                break;
                            }
                        default:
                            break;
                    }
                }else if(upgrade.green == true){
                    if(ke.getKeyCode() == KeyEvent.VK_W) {
                        Plasma pl = new Plasma();
                        pl.setVelY(-5);
                        pl.setX(Shooter.getX()+Shooter.getWidth()*.5);
                        pl.setY(Shooter.getY()+Shooter.getHeight()*.5);
                        pl.init2(sc);
                        sc.addSprite(pl);
                    }else if(ke.getKeyCode() == KeyEvent.VK_D) {
                        Plasma pl = new Plasma();
                        pl.setVelX(5);
                        pl.setX(Shooter.getX()+Shooter.getWidth()*.5);
                        pl.setY(Shooter.getY()+Shooter.getHeight()*.5);
                        pl.init2(sc);
                        sc.addSprite(pl);
                    }else if(ke.getKeyCode() == KeyEvent.VK_S) {
                        Plasma pl = new Plasma();
                        pl.setVelY(5);
                        pl.setX(Shooter.getX()+Shooter.getWidth()*.5);
                        pl.setY(Shooter.getY()+Shooter.getHeight()*.5);
                        pl.init2(sc);
                        sc.addSprite(pl);
                    }else if(ke.getKeyCode() == KeyEvent.VK_A) {
                        Plasma pl = new Plasma();
                        pl.setVelX(-5);
                        pl.setX(Shooter.getX()+Shooter.getWidth()*.5);
                        pl.setY(Shooter.getY()+Shooter.getHeight()*.5);
                       pl.init2(sc);
                        sc.addSprite(pl);
                    }
            }
         }
            public void keyReleased(KeyEvent ke){
                if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Shooter.setVelX(0);
                }else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
                   Shooter.setVelX(0);
                }else if(ke.getKeyCode() == KeyEvent.VK_UP) {
                    Shooter.setVelY(0);
                }else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    Shooter.setVelY(0);
                } 
            }
        });

         bf.show();
         sc.start(0, 10);
    }
}

class upgrade extends Sprite{
    
    //SpriteComponent landing;
    static boolean red = true;
    static boolean green = false;
    static boolean brown = false;
    static boolean orange = false;

    public void init (SpriteComponent sc) throws IOException{
        setX(350);
        setY(350);
        setPicture(new Picture ("landhereyo.png"));
        sc.addSprite(this);
    }
    
       @Override
    public void processEvent(SpriteCollisionEvent ev){
        if (ev.eventType == CollisionEventType.SPRITE) {
            if(ev.sprite2 instanceof shooter){
                red = false;
                green = true;  
                setActive(false);
             
            }      
        }  
    }
}
class shooter extends Sprite{
    SpriteComponent sprite;


    public void init (SpriteComponent sc)throws IOException{
        setX(10);
        setY(10);
        setPicture(new Picture("greenrocket.png"));
        sc.addSprite(this);
        sprite = sc;
    }
   

}  

