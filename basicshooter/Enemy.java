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
            health = 80;
        } else if (nums <= 80) {
            setPicture(Game.makeBall(Color.blue, Game.BIG));
            health = 5;
        } else if (nums <= 85) {
            setPicture(Game.makeBall(Color.yellow, Game.BIG));
            health = 8;
        } else if (nums <= 100) {
            setPicture(Game.makeBall(Color.black, Game.BIG));
            health = 8;
        }
        setX(Game.RAND.nextInt(900) + 450);
        setY(Game.RAND.nextInt(900) + 450);
        
        // A random speed
        if (nums <= 40) {
            setVelX(2);
            setVelY(0);
        } else if (nums <= 80) {
            setVelX(0);
            setVelY(2);
        } else if (nums <= 85) {
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
                
                doubleshotup.shot = false;

                Upgrade.green = false;
                Upgrade.red = true;
                Game.BULLET_COLOR = Color.blue;
                Bullet.damage = 1;

                Control.speed = 3;
                Control.high = false;

                if(getVelX() < 0 && getVelY() == 0) {
                    setVelX(getVelX() * -1);
                } else if (getVelX() > 0 && getVelY() == 0) {
                    setVelX(-getVelX());
                } else if (getVelY() < 0 && getVelX()==0) {
                    setVelY(getVelY() * -1);
                } else if (getVelY() > 0 && getVelX()==0) {
                    setVelY(-Math.abs(getVelY()));
                } else if(getVelX() < 0 && getVelY() < 0) {
                    setVelX(getVelX() * -1);
                    setVelY(-1* getVelY());
                } else if (getVelX() > 0 && getVelY() > 0) {
                    setVelX(-getVelX());
                    setVelY(getVelY() * -1);
                } else if (getVelX() < 0 && getVelY() > 0) {
                    setVelY(getVelY() * -1);
                    setVelX(getVelX() * -1);
                } else if (getVelX() > 0 && getVelY() < 0) {
                    setVelY(-Math.abs(getVelY()));
                    setVelX(-getVelX());
                } 

//                Game.health.remove(4);
                
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
                    clip.stop();
                    setActive(false);
                }
                se.sprite2.setActive(false);
                if (enemyCount == 0) {
                    JOptionPane.showMessageDialog(sc, "You win! Game Over!");
                    System.exit(0);
                }
            }

            if (se.sprite2 instanceof Wall) {
                if(getVelX() < 0 && getVelY() == 0) {
                    setVelX(getVelX() * -1);
                } else if (getVelX() > 0 && getVelY() == 0) {
                    setVelX(-getVelX());
                } else if (getVelY() < 0 && getVelX()==0) {
                    setVelY(getVelY() * -1);
                } else if (getVelY() > 0 && getVelX()==0) {
                    setVelY(-1 * getVelY());
                } else if(getVelX() < 0 && getVelY() < 0) {
                    setVelX(getVelX() * -1);
                    setVelY(-1* getVelY());
                } else if (getVelX() > 0 && getVelY() > 0) {
                    setVelX(-getVelX());
                    setVelY(getVelY() * -1);
                } else if (getVelX() < 0 && getVelY() > 0) {
                    setVelY(getVelY() * -1);
                    setVelX(getVelX() * -1);
                } else if (getVelX() > 0 && getVelY() < 0) {
                    setVelY(-1 * getVelY());
                    setVelX(-getVelX());
                } 
            }
        }
    }
}

