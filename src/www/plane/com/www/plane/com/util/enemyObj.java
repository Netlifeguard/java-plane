package www.plane.com.www.plane.com.util;

import www.plane.com.GameWin;

import java.awt.*;

public class enemyObj extends gameObj{
    public enemyObj() {
        super();
    }

    public enemyObj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    public enemyObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        super(image, x, y, width, height, speed, gameWin);
    }

    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);
        y+=speed;
        if (this.getRect().intersects(this.gameWin.planeObj.getRect())){
            gameWin.state=3;
        }
        if (y>600){
            this.x=-200;
            this.y=200;
            gameUtils.removeObjs.add(this);
        }
        for(bulletObj bullet:gameUtils.bullets){
                if (this.getRect().intersects(bullet.getRect())){
                    //若碰撞，需将坐标改变，该到哪里都可以。
                    bullet.setX(-100);
                    bullet.setY(100);
                    this.setX(-200);
                    this.setY(200);
                    gameUtils.removeObjs.add(bullet);
                    gameUtils.removeObjs.add(this);
                    this.gameWin.score++;
                }
        }
    }

    @Override
    public Rectangle getRect() {
        return super.getRect();
    }

}
