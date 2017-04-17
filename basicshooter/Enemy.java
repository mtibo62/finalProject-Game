package basicshooter;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.sounds.ReusableClip;
import java.applet.AudioClip;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Enemy extends Sprite {

    public int health;
    SpriteComponent sc = new SpriteComponent();
    static int enemyCount;

    Enemy() {
        enemyCount++;
    }

    @Override
    public void setActive(boolean b) {
        if (isActive() == b) {
            return;
        }
        if (b) {
            enemyCount++;
        } else {
            enemyCount--;
        }
        super.setActive(b);
    }

    public void init(SpriteComponent sc) {
        int nums = Game.RAND.nextInt(100) + 1;
        if (nums <= 40) {
            setPicture(Game.makeBall(Game.ENEMY_COLOR, Game.BIG));
            health = 5;
        } else if (nums <= 80) {
            setPicture(Game.makeBall(Color.blue, Game.BIG));
            health = 5;
        } else if (nums <= 90) {
            setPicture(Game.makeBall(Color.yellow, Game.BIG));
            health = 8;
        } else if (nums <= 100) {
            setPicture(Game.makeBall(Color.black, Game.BIG));
            health = 8;
        }
            setX(Game.RAND.nextInt(1000) + 300);
            setY(Game.RAND.nextInt(1000) + 300);
            
        
        // A random speed
        if (nums <= 40) {
            setVelX(2);
            setVelY(0);
        } else if (nums <= 80) {
            setVelX(0);
            setVelY(2);
        } else if (nums <= 90) {
            setVelX(-2);
            setVelY(2);
        } else if (nums <= 100) {
            setVelX(5);
            setVelY(5);
        }
        sc.addSprite(this);
        this.sc = sc;
    }

    AudioClip clip = new ReusableClip("die.wav");

    @Override
    public void processEvent(SpriteCollisionEvent se) {
        if (se.eventType == CollisionEventType.WALL_INVISIBLE) {
            if (se.xlo) {
                setVelX(Math.abs(getVelX()));
            }
            if (se.xhi) {
                setVelX(-Math.abs(getVelX()));
            }
            if (se.ylo) {
                setVelY(Math.abs(getVelY()));
            }
            if (se.yhi) {
                setVelY(-Math.abs(getVelY()));
            }
        }

        if (se.eventType == CollisionEventType.SPRITE) {
            if (se.sprite2 instanceof Shooter) {
                clip.play();
                Game.shooterHealth--;
                setX(getX() + 50);
                Upgrade.green = false;
                Upgrade.red = true;
                Control.speed = 3;
                Control.high = false;
                final tophud h = new tophud();
                try {
                    h.init(sc, 0, 0);
                } catch (IOException ex) {
                    Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (Game.shooterHealth <= 0) {
                    se.sprite2.setActive(false);
                    JOptionPane.showMessageDialog(sc, "You lose! Game Over!");
                    System.exit(0);

                }
            }
            if (se.sprite2 instanceof Bullet) {
                clip.play();
                health -= Bullet.damage;
                if (health <= 0) {
                    setActive(false);
                }
                se.sprite2.setActive(false);
                if (enemyCount == 0) {
                    JOptionPane.showMessageDialog(sc, "You win! Game Over!");
                    System.exit(0);
                }
            }
            if (se.sprite2 instanceof Wall) {
                if (getVelX() < 0 ) {
                    if (getVelY() < 0) {
                        setVelY(Math.abs(getVelY()));
                        setVelX(Math.abs(getVelX()));
                    } else if (getVelY() > 0) {
                        setVelY(-Math.abs(getVelY()));
                        setVelX(Math.abs(getVelX()));
                    } else {
                        setVelX(Math.abs(getVelX()));
                    }
                } else if (getVelX() > 0) {
                    if (getVelY() < 0) {
                        setVelY(Math.abs(getVelY()));
                        setVelX(-Math.abs(getVelX()));
                    } else if (getVelY() > 0) {
                        setVelY(-Math.abs(getVelY()));
                        setVelX(-Math.abs(getVelX()));
                    } else {
                        setVelX(-Math.abs(getVelX()));
                    }
                } else{
                    if (getVelY() < 0) {
                        setVelY(Math.abs(getVelY()));                    
                    } else if (getVelY() > 0) {
                        setVelY(-Math.abs(getVelY()));
                    }
                }
            }
        }
    }
}

//               if (getVelX() < 0  && getVelY() == 0) {
//                    if (getVelY() < 0) {
//                        setVelY(Math.abs(getVelY()));
//                        setVelX(Math.abs(getVelX()));
//                    } else if (getVelY() > 0) {
//                        setVelY(-Math.abs(getVelY()));
//                        setVelX(Math.abs(getVelX()));
//                    } else {
//                        setVelX(Math.abs(getVelX()));
//                    }
//                } else if (getVelX() > 0) {
//                    if (getVelY() < 0) {
//                        setVelY(Math.abs(getVelY()));
//                        setVelX(-Math.abs(getVelX()));
//                    } else if (getVelY() > 0) {
//                        setVelY(-Math.abs(getVelY()));
//                        setVelX(-Math.abs(getVelX()));
//                    } else {
//                        setVelX(-Math.abs(getVelX()));
//                    }
//                } else{
//                    if (getVelY() < 0) {
//                        setVelY(Math.abs(getVelY()));                    
//                    } else if (getVelY() > 0) {
//                        setVelY(-Math.abs(getVelY()));
//                    }