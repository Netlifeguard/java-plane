package www.plane.com.www.plane.com.util;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class gameUtils {
    public static Image bj() {
        return Toolkit.getDefaultToolkit().getImage("D:\\A--Projects\\java\\java1\\plane\\imgs\\bj.png");
    }

    public static Image bz() {
        return Toolkit.getDefaultToolkit().getImage("D:\\A--Projects\\java\\java1\\plane\\imgs\\bz.png");
    }

    public static Image dr() {
        return Toolkit.getDefaultToolkit().getImage("D:\\A--Projects\\java\\java1\\plane\\imgs\\dr.png");
    }
    public static Image dr2() {
        return Toolkit.getDefaultToolkit().getImage("D:\\A--Projects\\java\\java1\\plane\\imgs\\dr2.png");
    }

    public static Image me() {
        return Toolkit.getDefaultToolkit().getImage("D:\\A--Projects\\java\\java1\\plane\\imgs\\me.png");

    }

    public static Image bullet() {
        return Toolkit.getDefaultToolkit().getImage("D:\\A--Projects\\java\\java1\\plane\\imgs\\bullet.png");

    }
    public static Image boss() {
        return Toolkit.getDefaultToolkit().getImage("D:\\A--Projects\\java\\java1\\plane\\imgs\\boss.png");

    }
    public static Image enemyBullet() {
        return Toolkit.getDefaultToolkit().getImage("D:\\A--Projects\\java\\java1\\plane\\imgs\\enemyBullet.png");

    }
    //我方子弹的批量添加，就是用集合存储多个子弹对象
    public  static  List<bulletObj> bullets = new ArrayList<>();
    //地方子弹
    public static  List<enemyBullet> enemyBullets = new ArrayList<>();
    //所有物体的集合
    public static List<gameObj> objs = new ArrayList<>();
    //敌方战斗机
    public static List<enemyObj> enemys = new ArrayList<>();
    //碰撞后，子弹和敌机应该一起删除，将需要删除的元素保存在这里
    public static List<gameObj> removeObjs = new ArrayList();
    public static void drawWord(Graphics g,String str,Color color,int size,int x,int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }
}
