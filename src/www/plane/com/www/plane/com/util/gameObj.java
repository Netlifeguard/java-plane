package www.plane.com.www.plane.com.util;

import www.plane.com.GameWin;

import java.awt.*;

public class gameObj {
    Image image;
    int x;
    int y;
    int width;
    int height;
    double speed;
    GameWin gameWin;

    public gameObj() {
    }
    public gameObj(Image image, int x, int y,double speed){
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    public gameObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.gameWin = gameWin;
    }
   //绘制自身
    public void painSelf(Graphics g){

        g.drawImage(image,x,y,null);
    }
    //获取自身矩形，用于碰撞检测
    public Rectangle getRect(){
        return new Rectangle(x,y,width,height);
    }
    /**
     * 获取
     * @return image
     */
    public Image getImage() {
        return image;
    }

    /**
     * 设置
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * 获取
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * 设置
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 获取
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * 设置
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 获取
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * 设置
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 获取
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * 设置
     * @param speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * 获取
     * @return gameWin
     */
    public GameWin getGameWin() {
        return gameWin;
    }

    /**
     * 设置
     * @param gameWin
     */
    public void setGameWin(GameWin gameWin) {
        this.gameWin = gameWin;
    }

    public String toString() {
        return "gameObj{image = " + image + ", x = " + x + ", y = " + y + ", width = " + width + ", height = " + height + ", speed = " + speed + ", gameWin = " + gameWin + "}";
    }
}
