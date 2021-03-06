package basicshooter;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.io.IOException;

public class Wall extends Sprite {

    public void init(SpriteComponent sc, int X, int Y) throws IOException {
        SpriteComponent sprite;
        setX(X);
        setY(Y);
        setPicture(new Picture("wall.png"));
        sc.addSprite(this);
    }
}
