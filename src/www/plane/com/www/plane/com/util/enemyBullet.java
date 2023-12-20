package www.plane.com.www.plane.com.util;

import www.plane.com.GameWin;

import java.awt.*;

public class enemyBullet extends gameObj{
    public enemyBullet() {
        super();
    }

    public enemyBullet(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    public enemyBullet(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        super(image, x, y, width, height, speed, gameWin);
    }

    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);
        y+=speed;
        if (this.getRect().intersects(this.gameWin.planeObj.getRect())){
            this.gameWin.state=3;
        }
        if (y>600){
            this.x=-300;
            this.y=300;
            gameUtils.removeObjs.add(this);
        }
    }

    @Override
    public Rectangle getRect() {
        return super.getRect();
    }
}
