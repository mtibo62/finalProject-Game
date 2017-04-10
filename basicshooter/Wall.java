/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicshooter;

import basicgraphics.Sprite;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.io.IOException;

/**
 *
 * @author Mark
 */
public class Wall extends Sprite {

    public void init(SpriteComponent sc) throws IOException {
        SpriteComponent sprite;
        setX(300);
        setY(300);
        setPicture(new Picture("wall.png"));
        sc.addSprite(this);
    }

    public void processEvent(SpriteCollisionEvent ce) {
        double x = getX();
        if (ce.eventType == CollisionEventType.SPRITE) {
           if(ce.sprite2 instanceof Shooter){
               
           }
        }
    }
}
