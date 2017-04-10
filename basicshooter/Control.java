
package basicshooter;

import basicgraphics.Sprite;
import java.awt.event.KeyEvent;


public class Control extends Sprite {
    double x;
    double y;
           public void init(Sprite sp,int direction) {   
     
                if(direction == KeyEvent.VK_RIGHT) {
                    x = sp.getX();
                    if(x>Game.BOARD_SIZE.width-5){
                        x=Game.BOARD_SIZE.width-5;
                    }
                    sp.setX(x);
                    sp.setVelX(3);
                } else if(direction == KeyEvent.VK_LEFT) {
                    x = sp.getX();
                    if(x<5){
                        x=5;
                    }
                    sp.setX(x);
                    sp.setVelX(-3);
                } else if(direction == KeyEvent.VK_UP) {
                    y = sp.getY();
                    if(y<5){
                        y=5;
                    }
                    sp.setY(y);
                    sp.setVelY(-3);
                }else if(direction == KeyEvent.VK_DOWN) {
                    y = sp.getY();
                    if(y>Math.abs(Game.BOARD_SIZE.height)-5){
                        y=Game.BOARD_SIZE.height-5;
                    }
                    sp.setY(y);
                    sp.setVelY(3);
                }
           }
            public void init2(Sprite sp, int direction){
                 if(direction == KeyEvent.VK_RIGHT) {
                    sp.setVelX(0);
                }else if(direction == KeyEvent.VK_LEFT) {
                   sp.setVelX(0);
                }else if(direction == KeyEvent.VK_UP) {
                    sp.setVelY(0);
                }else if(direction == KeyEvent.VK_DOWN) {
                    sp.setVelY(0);
                } 
            }    
}
