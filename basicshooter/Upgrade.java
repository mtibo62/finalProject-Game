package basicshooter;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Upgrade extends Sprite{
    
    static boolean red = true;
    static boolean green = false;

    public void init (SpriteComponent sc) throws IOException{
        SpriteComponent sprite;
        setX(350);
        setY(350);
        setPicture(new Picture ("landhereyo.png"));
        sc.addSprite(this);
    }
    
       @Override
    public void processEvent(SpriteCollisionEvent ev){
        if (ev.eventType == CollisionEventType.SPRITE) {
            if(ev.sprite2 instanceof Shooter){
                red = false;
                green = true; 
                Game.BULLET_COLOR = Color.green;
                Bullet.damage = 2;
                setActive(false);           
            }      
        }  
    }
}
