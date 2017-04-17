package basicshooter;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Upgrade extends Sprite {

    static boolean red = true;
    static boolean green = false;
    SpriteComponent sc = new SpriteComponent();

    public void init(SpriteComponent sc) throws IOException {
        SpriteComponent sprite;
        setX(Game.RAND.nextInt(1000) + 200);
        setY(Game.RAND.nextInt(1000) + 200);
        setPicture(new Picture("landhereyo.png"));
        sc.addSprite(this);
    }

    @Override
    public void processEvent(SpriteCollisionEvent ev) {
        if (ev.eventType == CollisionEventType.SPRITE) {
            if (ev.sprite2 instanceof Shooter) {
                red = false;
                green = true;
                final tophud h = new tophud();
                try {
                    h.init(sc, 0, 0);
                } catch (IOException ex) {
                    Logger.getLogger(Upgrade.class.getName()).log(Level.SEVERE, null, ex);
                }
                Game.BULLET_COLOR = Color.green;
                Bullet.damage = 2;
                setActive(false);
            }
        }
    }
}
