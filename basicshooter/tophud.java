package basicshooter;

import basicgraphics.SpriteComponent;
import java.io.*;
import basicgraphics.Sprite;
import basicgraphics.images.Picture;

public class tophud extends Sprite {

    public static int healthBar = 4;
    static SpriteComponent se;

    public void init(SpriteComponent sc, int X, int Y) throws IOException {
        se = sc;
        setX(X);
        setY(Y);
        if (Control.high == false && Upgrade.red == true) {
            if (Game.shooterHealth == 4) {

                setPicture(new Picture("fullhealth.png"));
            }
            if (Game.shooterHealth == 3) {
                setPicture(new Picture("fullhealth-1.png"));
            }
            if (Game.shooterHealth == 2) {
                setPicture(new Picture("fullhealth-2.png"));
            }

            if (Game.shooterHealth == 1) {
                setPicture(new Picture("fullhealth-3.png"));
            }

            if (Game.shooterHealth == 0) {
                setPicture(new Picture("nohealth.png"));
            }

            se.addSprite(this);

//        } else if (Control.high == true && Upgrade.red == true) {
//            switch (Game.shooterHealth) {
//                case 4:
//                    setPicture(new Picture("fullhealth-red.png"));
//                    break;
//                case 3:
//                    setPicture(new Picture("health-3-red.png"));
//                    break;
//                case 2:
//                    setPicture(new Picture("health-2-red.png"));
//                    break;
//                case 1:
//                    setPicture(new Picture("health-1-red.png"));
//                    break;
//                case 0:
//                    setPicture(new Picture("nohealth-red.png"));
//                    break;
//                default:
//                    break;
//            }
//            se.addSprite(this);
//
//        } else if (Control.high == false && Upgrade.red == false) {
//            switch (Game.shooterHealth) {
//                case 4:
//                    setPicture(new Picture("fullhealth-green.png"));
//                    break;
//                case 3:
//                    setPicture(new Picture("health-3-green.png"));
//                    break;
//                case 2:
//                    setPicture(new Picture("health-2-green.png"));
//                    break;
//                case 1:
//                    setPicture(new Picture("health-1-green.png"));
//                    break;
//                case 0:
//                    setPicture(new Picture("nohealth-green.png"));
//                    break;
//                default:
//                    break;
//            }
//            se.addSprite(this);
//
//        } else if (Control.high == true && Upgrade.red == false) {
//            switch (Game.shooterHealth) {
//                case 4:
//                    setPicture(new Picture("fullhealth-both.png"));
//                    break;
//                case 3:
//                    setPicture(new Picture("fullhealth-3-both.png"));
//                    break;
//                case 2:
//                    setPicture(new Picture("fullhealth-2-both.png"));
//                    break;
//                case 1:
//                    setPicture(new Picture("fullhealth-3-both.png"));
//                    break;
//                case 0:
//                    setPicture(new Picture("nohealth-both.png"));
//                    break;
//                default:
//                    break;
//            }
//            se.addSprite(this);
        }
  }
}