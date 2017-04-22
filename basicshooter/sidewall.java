package basicshooter;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.io.IOException;

public class sidewall extends Sprite {

    static SpriteComponent se;

    public void init(SpriteComponent sc, int X, int Y) throws IOException {
        se = sc;
        setX(X);
        setY(Y);
        setPicture(new Picture("wall.png"));
        sc.addSprite(this);
    }

    @Override
    public void processEvent(SpriteCollisionEvent se) {
        if (se.eventType == CollisionEventType.SPRITE) {
            if (se.sprite2 instanceof Enemy) {
                if (se.sprite2.getVelX() < 0 && se.sprite2.getVelY() == 0) {
                    se.sprite2.setVelX(se.sprite2.getVelX() * -1);
                } else if (se.sprite2.getVelX() > 0 && se.sprite2.getVelY() == 0) {
                    se.sprite2.setVelX(-se.sprite2.getVelX());
//                if (se.sprite2.getVelY() < 0 && se.sprite2.getVelX()==0) {
//                    se.sprite2.setVelY(se.sprite2.getVelY() * -1);
//                } else if (se.sprite2.getVelY() > 0 && se.sprite2.getVelX()==0) {
//                    se.sprite2.setVelY(-1 * se.sprite2.getVelY());
                }
                if (se.sprite2.getVelX() < 0 && se.sprite2.getVelY() < 0) {
                    se.sprite2.setVelX(se.sprite2.getVelX() * -1);
                    se.sprite2.setVelY(-1 * se.sprite2.getVelY());
                } else if (se.sprite2.getVelX() > 0 && se.sprite2.getVelY() > 0) {
                    se.sprite2.setVelX(-se.sprite2.getVelX());
                    se.sprite2.setVelY(se.sprite2.getVelY() * -1);
                } else if (getVelX() < 0 && getVelY() > 0) {
                    se.sprite2.setVelY(se.sprite2.getVelY() * -1);
                    se.sprite2.setVelX(se.sprite2.getVelX() * -1);
                } else if (se.sprite2.getVelX() > 0 && se.sprite2.getVelY() < 0) {
                    se.sprite2.setVelY(-1 * se.sprite2.getVelY());
                    se.sprite2.setVelX(-se.sprite2.getVelX());
                }
            }
            if (se.sprite2 instanceof Shooter) {
                if (se.sprite2.getVelX() < 0) {
                    se.sprite2.setX(getX() + getWidth() + 1);
                } else if (se.sprite2.getVelX() > 0) {
                    se.sprite2.setX(getX() - se.sprite2.getWidth() - 1);
                }
            }
        }
    }
}
