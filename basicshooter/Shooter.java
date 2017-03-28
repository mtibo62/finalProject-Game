
package basicshooter;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Shooter extends Sprite {

    public void init(SpriteComponent sc) throws IOException {
        SpriteComponent sprite;
//        setPicture(Game.makeBall(Game.SHOOTER_COLOR, Game.BIG));
//        setX(Game.BOARD_SIZE.width/2);
//        setY(Game.BOARD_SIZE.height/2);
//        sc.addSprite(this);
        setX(10);
        setY(10);
        setPicture(new Picture("greenrocket.png"));
        sc.addSprite(this);
        sprite = sc;
    }

     @Override
              public void processEvent(SpriteCollisionEvent ce) {
                  if (ce.eventType == CollisionEventType.WALL) {
                      if (ce.xlo) {
                          setVelX(Math.abs(getVelX()));
                      }
                      if (ce.xhi) {
                          setVelX(-Math.abs(getVelX()));
                      }
                      if (ce.ylo) {
                          setVelY(Math.abs(getVelY()));
                      }
                      if (ce.yhi) {
                          setVelY(-Math.abs(getVelY()));
                      }
//    public void init2( int direction) {
//        
//        if (direction == KeyEvent.VK_RIGHT) {
//            setVelX(3);
//        } else if (direction == KeyEvent.VK_LEFT) {
//            setVelX(-3);
//        } else if (direction == KeyEvent.VK_UP) {
//            setVelY(-3);
//        } else if (direction == KeyEvent.VK_DOWN) {
//            setVelY(3);
//        }
//    }
}
              }
}
