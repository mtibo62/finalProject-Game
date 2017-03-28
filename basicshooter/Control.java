
package basicshooter;

import basicgraphics.Sprite;
import java.awt.event.KeyEvent;


public class Control extends Sprite {
           public void init(Sprite sp,int direction) {   
     
                if(direction == KeyEvent.VK_RIGHT) {
                    sp.setVelX(3);
                } else if(direction == KeyEvent.VK_LEFT) {
                    sp.setVelX(-3);
                } else if(direction == KeyEvent.VK_UP) {
                    sp.setVelY(-3);
                }else if(direction == KeyEvent.VK_DOWN) {
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
