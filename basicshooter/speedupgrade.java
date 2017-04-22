package basicshooter;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicgraphics.sounds.ReusableClip;
import java.applet.AudioClip;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class speedupgrade extends Sprite {

    static boolean high = false;
    SpriteComponent sc = new SpriteComponent();
    AudioClip clip2 = new ReusableClip("Door.wav");

    public void init(SpriteComponent sc, int X , int Y) throws IOException {
        SpriteComponent sprite;
        if (X == 0 || Y == 0) {
            setX(Game.RAND.nextInt(900) + 450);
            setY(Game.RAND.nextInt(900) + 450);
        } else {
            setX(X);
            setY(Y);
        }
        setPicture(new Picture("speedup.png"));
        sc.addSprite(this);
    }

    @Override
    public void processEvent(SpriteCollisionEvent ev) {
        if (ev.eventType == CollisionEventType.SPRITE) {
            if (ev.sprite2 instanceof Shooter) {
                Control.high = true;
                clip2.play();
                final tophud h = new tophud();
                try {
                    h.init(sc, 0, 0);
                } catch (IOException ex) {
                    Logger.getLogger(speedupgrade.class.getName()).log(Level.SEVERE, null, ex);
                }
                Control.speed = 10;
                setActive(false);
            }
        }
    }
}
