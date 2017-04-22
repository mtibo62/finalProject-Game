package basicshooter;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.io.IOException;

public class Shooter extends Sprite {

    public void init(SpriteComponent sc, int X, int Y) throws IOException {
        SpriteComponent sprite;
        setX(X);
        setY(Y);
        setPicture(new Picture("greenrocket.png"));
        sc.addSprite(this);
        sprite = sc;
    }

    @Override
    public void processEvent(SpriteCollisionEvent ce) {
        if (ce.eventType == CollisionEventType.WALL) {
            if (ce.xlo) {
                setVelX(0);
            }
            if (ce.xhi) {
                setVelX(0);
            }
            if (ce.ylo) {
                setVelY(0);
            }
            if (ce.yhi) {
                setVelY(0);
            }
        }
        if (ce.eventType == CollisionEventType.SPRITE) {
            if (ce.sprite2 instanceof tophud) {
                setY(30);
            }

            if (ce.sprite2 instanceof Wall) {
                if (getVelX() < 0) {
                    setX(ce.sprite2.getX() + ce.sprite2.getWidth()+5);
                }
                else if (getVelX() > 0) {
                    setX(ce.sprite2.getX() - getWidth()-5);
                }
                else if (getVelY() < 0) {
                    setY(ce.sprite2.getY() + ce.sprite2.getHeight()+5);
                }
                else if (getVelY() > 0) {
                    setY(ce.sprite2.getY() - getHeight()-5);
                }       
            }
        }
    }
}

//                if (ce.sprite2.getY() + ce.sprite2.getHeight() > getY() && (getX() > ce.sprite2.getX() && getX() < ce.sprite2.getX() +ce.sprite2.getWidth())) {
//                    setY(ce.sprite2.getY() + getHeight()+1);
//                }
//                else if (ce.sprite2.getY() < getY()+getHeight() && (getX() > ce.sprite2.getX() && getX() < ce.sprite2.getX() +ce.sprite2.getWidth())) {
//                    setY(ce.sprite2.getY() - getHeight()-1);
//                }
//                else if (ce.sprite2.getX() + ce.sprite2.getWidth()  > getX()) {
//                    setX(ce.sprite2.getX() + ce.sprite2.getWidth()+1);
//                }
//                else if (ce.sprite2.getX() < getX() + getWidth()) {
//                    setX(ce.sprite2.getX() - getWidth()-1);
//                }
//                if(Control.upMove == true){
//                    //setY(ce.sprite2.getY()+ce.sprite2.getHeight()+3);
//                    setY(getY()+3);
//                    setVelY(0);
//                }
//                else if(Control.downMove == true){
//                    //setY(ce.sprite2.getY()-getHeight()-3);
//                    setVelY(0);
//                    setY(getY()-3);
//                }
//                else if(Control.rightMove == true){
//                    //setX(ce.sprite2.getX()- getWidth()-3);
//                    setVelX(0);
//                }
//                else if(Control.leftMove == true){
//                    //setX(ce.sprite2.getX()+ ce.sprite2.getWidth()+3);
//                    setVelX(0);
//                }
//                else if(ce.sprite2.getX() + ce.sprite2.getWidth() == getX()|| ce.sprite2.getY() + ce.sprite2.getHeight() == getY())
//                    setX(ce.sprite2.getX()- getWidth());
//                    setY(ce.sprite2.getY()-getHeight());
