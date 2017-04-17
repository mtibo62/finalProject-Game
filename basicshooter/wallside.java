
package basicshooter;

import basicgraphics.Sprite;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.io.IOException;


public class wallside extends Sprite{
    public void init(SpriteComponent sc, int X, int Y) throws IOException {
        SpriteComponent sprite;
        setX(X);
        setY(Y);
        setPicture(new Picture("wallside.png"));
        sc.addSprite(this);
        double wallX = getX();
    }
    
}
