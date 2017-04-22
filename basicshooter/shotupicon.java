package basicshooter;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.io.IOException;

public class shotupicon extends Sprite{
    
    static SpriteComponent se;
    
    public void init(SpriteComponent sc, int X, int Y) throws IOException{       
        setX(X);
        setY(Y);
        setPicture(new Picture("shotsmall.png"));
        sc.addSprite(this);
    }
}
