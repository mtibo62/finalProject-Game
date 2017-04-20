package basicshooter;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.io.IOException;

public class speedupicon extends Sprite{
    
    static SpriteComponent se;
    
    public void init(SpriteComponent sc, int X, int Y) throws IOException {       
        se = sc;
        setX(X);
        setY(Y);
        setPicture(new Picture("speedsmall.png"));
        se.addSprite(this);
    }
}
