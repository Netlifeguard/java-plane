package www.plane.com.www.plane.com.util;

import www.plane.com.GameWin;

import java.awt.*;

public class bulletObj extends gameObj{
    public bulletObj() {
        super();
    }

    public bulletObj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    public bulletObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        super(image, x, y, width, height, speed, gameWin);
    }

    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);
        y-=speed;
        if (y<0){
            this.x=-100;
            this.y=-100;
            gameUtils.removeObjs.add(this);
        }
    }

    @Override
    public Rectangle getRect() {
        return super.getRect();
    }
}
