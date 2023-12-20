package www.plane.com.www.plane.com.util;

import www.plane.com.GameWin;

import java.awt.*;
import www.plane.com.www.plane.com.util.*;

public class bossObj extends gameObj{
    public bossObj() {
        super();
    }

    public bossObj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    public bossObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        super(image, x, y, width, height, speed, gameWin);
    }

    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);
        if (this.getRect().intersects(this.gameWin.planeObj.getRect())){
            this.gameWin.state=3;
        }
        for(bulletObj bulletObj :gameUtils.bullets ){
            if (this.getRect().intersects(bulletObj.getRect())){
                bulletObj.setX(-100);
                bulletObj.setY(200);
                gameUtils.removeObjs.add(bulletObj);
                this.gameWin.blood--;
                if (this.gameWin.blood==0){
                    this.gameWin.state=4;
                }
            }
        }
        if (x>400||x<0){
            speed=-speed;
        }
        x+=speed;
    }

    @Override
    public Rectangle getRect() {
        return super.getRect();
    }
}
