package basicshooter;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.sounds.ReusableClip;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.KeyEvent;

class Bullet extends Sprite {

    public static int damage = 1;
    AudioClip clip = new ReusableClip("Bow_Fire_Arrow.wav");

    public void init(SpriteComponent sc, Sprite sp, int direction) {
        if (Upgrade.red == true && (direction == KeyEvent.VK_W || direction == KeyEvent.VK_A || direction == KeyEvent.VK_S || direction == KeyEvent.VK_D)) {
            setPicture(Game.makeBall(Game.BULLET_COLOR, Game.BIG));
            setX(sp.getX() + (Game.BIG - Game.SMALL) / 2);
            setY(sp.getY() + (Game.BIG - Game.SMALL) / 2);
            clip.play();
            if (direction == KeyEvent.VK_S) {
                setVelY(5.0);
            } else if (direction == KeyEvent.VK_W) {
                setVelY(-5.0);
            } else if (direction == KeyEvent.VK_D) {
                setVelX(5.0);
            }else if (direction == KeyEvent.VK_A) {
                setVelX(-5.0);
            }
            sc.addSprite(this);
        } else if (direction == KeyEvent.VK_W || direction == KeyEvent.VK_A || direction == KeyEvent.VK_S || direction == KeyEvent.VK_D) {

            setPicture(Game.makeBall(Game.BULLET_COLOR, Game.BIG));
            setX(sp.getX() + (Game.BIG - Game.SMALL) / 2);
            setY(sp.getY() + (Game.BIG - Game.SMALL) / 2);

            if (direction == KeyEvent.VK_S) {
                setVelY(10.0);
            } else if (direction == KeyEvent.VK_W) {
                setVelY(-10.0);
            } else if (direction == KeyEvent.VK_D) {
                setVelX(10.0);
            } else if (direction == KeyEvent.VK_A) {
                setVelX(-10.0);
            }
            sc.addSprite(this);

        }
    }
    
        public void init2(SpriteComponent sc, Sprite sp, int direction, int X, int Y) {
        if (doubleshotup.shot == true && (direction == KeyEvent.VK_W || direction == KeyEvent.VK_A || direction == KeyEvent.VK_S || direction == KeyEvent.VK_D)) {
            setPicture(Game.makeBall(Color.yellow, Game.BIG));
            setX(sp.getX() + (Game.BIG - Game.SMALL) / 2);
            setY(sp.getY() + (Game.BIG - Game.SMALL) / 2);
            
            if (direction == KeyEvent.VK_S) {
                setVelY(5.0);
                setVelX(-X);
            } else if (direction == KeyEvent.VK_W) {
                setVelY(-5.0);
                setVelX(-X);
            } else if (direction == KeyEvent.VK_D) {
                setVelX(5.0);
                setVelY(-Y);
            } else if (direction == KeyEvent.VK_A) {
                setVelX(-5.0);
                setVelY(-Y);
            }
            sc.addSprite(this);
        }
    }

    @Override
    public void processEvent(SpriteCollisionEvent se) {
        if (se.eventType == CollisionEventType.WALL) {
            setActive(false);
        }else if (se.eventType == CollisionEventType.SPRITE) {
            if(se.sprite2 instanceof Wall){
                setActive(false);
            }
        }
    }

//    void init(SpriteComponent sc, Shooter sp, int x, int y) {
//        setPicture(Game.makeBall(Game.BULLET_COLOR, Game.SMALL));
//        setX(sp.getX()+(Game.BIG-Game.SMALL)/2);
//        setY(sp.getY()+(Game.BIG-Game.SMALL)/2);
//        double delx = x-sp.getX()-sp.getWidth()/2;
//        double dely = y-sp.getY()-sp.getHeight()/2;
//        double dist = Math.sqrt(delx*delx+dely*dely);
//        setVelX(2*delx/dist);
//        setVelY(2*dely/dist);
//        sc.addSprite(this);
//    }
}
