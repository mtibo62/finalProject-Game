package basicshooter;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicgraphics.sounds.ReusableClip;
import java.applet.AudioClip;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Upgrade extends Sprite {

    static boolean red = true;
    static boolean green = false;
    SpriteComponent sc = new SpriteComponent();
    AudioClip clip2 = new ReusableClip("Door.wav");
    SpriteComponent sprite;

    public void init(SpriteComponent sc, int X, int Y) throws IOException {
        if (X == 0 || Y == 0) {
            setX(Game.RAND.nextInt(900) + 450);
            setY(Game.RAND.nextInt(900) + 450);
        } else {
            setX(X);
            setY(Y);
        }
        setPicture(new Picture("shotup.png"));
        sc.addSprite(this);
    }

    @Override
    public void processEvent(SpriteCollisionEvent ev) {
        if (ev.eventType == CollisionEventType.SPRITE) {
            if (ev.sprite2 instanceof Shooter) {
                red = false;
                green = true;
                clip2.play();

                final shotupicon si = new shotupicon();
                try {
                    si.init(sc, 200, 20);
                } catch (IOException ex) {
                    Logger.getLogger(Upgrade.class.getName()).log(Level.SEVERE, null, ex);
                }

//                final tophud h = new tophud();
//                try {
//                    h.init(sc, 0, 0);
//                } catch (IOException ex) {
//                    Logger.getLogger(Upgrade.class.getName()).log(Level.SEVERE, null, ex);
//                }
                Game.BULLET_COLOR = Color.green;
                Bullet.damage = 2;
                setActive(false);
            }
        }
    }
}
