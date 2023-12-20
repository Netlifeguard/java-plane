package www.plane.com.www.plane.com.util;

import www.plane.com.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class planeObj extends gameObj {
    public planeObj() {
        super();
    }

    public planeObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        super(image, x, y, width, height, speed, gameWin);
        //实现鼠标对飞机的控制，在这里添加鼠标滚动事件
        this.gameWin.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                planeObj.super.x = e.getX() - 11;
                planeObj.super.y = e.getY() - 11;
            }
        });
    }

    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);
    }

    @Override
    public Rectangle getRect() {
        return super.getRect();
    }
}
