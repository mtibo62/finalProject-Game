
package basicshooter;

import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import java.awt.event.KeyEvent;

class Bullet extends Sprite {
    public static int damage = 1;
    public void init(SpriteComponent sc,Sprite sp,int direction) {
        if(Upgrade.red == true && (direction == KeyEvent.VK_W||direction == KeyEvent.VK_A||direction == KeyEvent.VK_S||direction == KeyEvent.VK_D)){
            setPicture(Game.makeBall(Game.BULLET_COLOR, Game.BIG));
            setX(sp.getX()+(Game.BIG-Game.SMALL)/2);
            setY(sp.getY()+(Game.BIG-Game.SMALL)/2);
            if(direction == KeyEvent.VK_S)
                setVelY(5.0);
            else if(direction == KeyEvent.VK_W)
                setVelY(-5.0);
            else if(direction == KeyEvent.VK_D)
                setVelX(5.0);
            else if(direction == KeyEvent.VK_A)
                setVelX(-5.0);
            sc.addSprite(this);
        }else if(direction == KeyEvent.VK_W||direction == KeyEvent.VK_A||direction == KeyEvent.VK_S||direction == KeyEvent.VK_D){
            
            setPicture(Game.makeBall(Game.BULLET_COLOR, Game.BIG));
            setX(sp.getX()+(Game.BIG-Game.SMALL)/2);
            setY(sp.getY()+(Game.BIG-Game.SMALL)/2);

            if(direction == KeyEvent.VK_S)
                setVelY(5.0);
            else if(direction == KeyEvent.VK_W)
                setVelY(-5.0);
            else if(direction == KeyEvent.VK_D)
                setVelX(5.0);
            else if(direction == KeyEvent.VK_A)
                setVelX(-5.0);
            sc.addSprite(this);
            
        }
    }
    
    @Override
    public void processEvent(SpriteCollisionEvent se) {
        if(se.sprite2 instanceof Shooter) {
        } else {
            setActive(false);
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
