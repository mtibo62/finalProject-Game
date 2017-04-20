package basicshooter;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.io.IOException;

public class doubleshoticon extends Sprite{
    
    static SpriteComponent se;
    
    public void init(SpriteComponent sc, int X, int Y) throws IOException {       
        se = sc;
        setX(X);
        setY(Y);
        setPicture(new Picture("doublesmall.png"));
        se.addSprite(this);
    }
}
