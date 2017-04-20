package basicshooter;

import basicgraphics.Sprite;
import java.awt.event.KeyEvent;

public class Control extends Sprite {

    double x;
    double y;
    public static int speed = 3;
    public static boolean high = false;
    public static double hitX;
    public static boolean upMove = false;
    public static boolean downMove = false;
    public static boolean rightMove = false;
    public static boolean leftMove = false;
    
    public void init(Sprite sp, int direction) {
 
        switch (direction) {
            case KeyEvent.VK_RIGHT:
                x = sp.getX();
                rightMove = true;
                if (x > Game.BOARD_SIZE.width - 5) {
                    x = Game.BOARD_SIZE.width - 5;
                }   sp.setX(x);
                sp.setVelX(speed);
                break;
            case KeyEvent.VK_LEFT:
                x = sp.getX();
                leftMove = true;
                if (x < 5) {
                    x = 5;
                }   sp.setX(x);
                sp.setVelX(-speed);
                break;
            case KeyEvent.VK_UP:
                y = sp.getY();
                upMove = true;
                if (y < 5) {
                    y = 5;
                }   sp.setY(y);
                sp.setVelY(-speed);
                break;
            case KeyEvent.VK_DOWN:
                y = sp.getY();
                downMove = true;
                if (y > Math.abs(Game.BOARD_SIZE.height) - 5) {
                    y = Game.BOARD_SIZE.height - 5;
                }   sp.setY(y);
                sp.setVelY(speed);
                break;
            default:
                break;
        }
    
    }

    public void init2(Sprite sp, int direction) {
        switch (direction) {
            case KeyEvent.VK_RIGHT:
                rightMove = false;
                sp.setVelX(0);
                break;
            case KeyEvent.VK_LEFT:
                leftMove = false;
                sp.setVelX(0);
                break;
            case KeyEvent.VK_UP:
                upMove = false;
                sp.setVelY(0);
                break;
            case KeyEvent.VK_DOWN:
                downMove = false;
                sp.setVelY(0);
                break;
            default:
                break;
        }
    }
}
