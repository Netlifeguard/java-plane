package www.plane.com;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import www.plane.com.www.plane.com.util.*;

public class GameWin extends JFrame {
    //背景声音对象
    private Clip bgMusic;
    public bulletObj bulletObj=null;
    public int blood =100;
    public int bossCome =0;
    //0未开始 1开始  2 暂停  3继续   4  结束
    public int state = 0;
    public int score =0;
    //背景对象
    bjObj bjObj = new bjObj(gameUtils.bj(), 0, 700, 2);
    //我方飞机对象
    public planeObj planeObj = new planeObj(gameUtils.me(), 250, 600, 90, 90, 10, this);
    //boss
    public bossObj bossObj = null;
    //子弹对象
    //bulletObj bulletObj = new bulletObj(gameUtils.bullet(), planeObj.getX(), planeObj.getY(), 20,20,2,this);
    //双缓存，存储临时图像
    Image tempImage = null;
    //通过绘制的次数控制子弹生成的速度
    public int count = 1;

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.winInit();
    }

    public void winInit() {
        playMusic();
        this.setVisible(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("雷霆战机");
        //将要添加的物体全放在集合中
        gameUtils.objs.add(bjObj);
        gameUtils.objs.add(planeObj);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1 && state == 0) {
                    state = 1;
                    repaint();
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==32){
                    switch (state){
                        case 1:
                            state=2;
                            break;
                        case 2:
                            state=1;
                            break;
                    }
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeBackgroundMusic();

            }
        });
        repaint();
        while (true) {
            //游戏只有在运行状态下才不断的产生子弹和敌机
            if (state == 1) {
                createObjs();
                repaint();
            }
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        if (tempImage == null) {
            tempImage = createImage(600, 600);
        }
        //获取临时图像的图形对象以画图
        Graphics temp = tempImage.getGraphics();
        temp.fillRect(0, 0, 600, 600);
        if (state == 0) {
            temp.drawImage(gameUtils.bj(), 0, 0, 700, 700, null);
            temp.drawImage(gameUtils.bz(), 250, 300, 100, 100, null);
            temp.drawImage(gameUtils.dr(), 250, 0, 100, 100, null);
            gameUtils.drawWord(temp,"开始游戏",Color.blue,40,230,300);
        }
        if (state == 1) {
            //bjObj.painSelf(temp);
            //planeObj.painSelf(temp);
            //在运行状态下遍历物体集合，进行绘制
            for (int i = 0; i < gameUtils.objs.size(); i++) {
                gameUtils.objs.get(i).painSelf(temp);
            }
            gameUtils.objs.removeAll(gameUtils.removeObjs);
            gameUtils.drawWord(temp,"分数："+score,Color.white,20,10,50);


        }
        if (state == 3) {
            temp.drawImage(gameUtils.bz(), planeObj.getX() + 30, planeObj.getY(), 100, 100, null);
            gameUtils.drawWord(temp,"游戏失败：",Color.red,40,250,300);
        }
        if (state == 4) {
            temp.drawImage(gameUtils.bz(), planeObj.getX() + 30, planeObj.getY(), 100, 100, null);
            gameUtils.drawWord(temp,"游戏通关：",Color.red,40,250,300);
        }
        //gameUtils.drawWord(temp,);

        if (bossObj !=null){
            gameUtils.drawWord(temp,"生命值"+blood,Color.red,20,490,50);
        }
        g.drawImage(tempImage, 0, 0, null);
        count++;
        System.out.println(gameUtils.objs.size());
    }

    void createObjs() {
        if (count % 6 == 0) {

             bulletObj = new bulletObj(gameUtils.bullet(), planeObj.getX() + 28, planeObj.getY() - 40, 20, 20, 5, this);
            //通过匿名类的方式创建我方子弹
            gameUtils.bullets.add(bulletObj);
            //将子弹对象添加到所有物体的集合中
            gameUtils.objs.add(gameUtils.bullets.get(gameUtils.bullets.size() - 1));

        }
        if (count % 17 == 0&&bossObj!=null) {

         enemyBullet enemyBullet = new enemyBullet(gameUtils.enemyBullet(),bossObj.getX()+20, bossObj.getY(), 30,30,16,this);
         gameUtils.enemyBullets.add(enemyBullet);
         gameUtils.objs.add(gameUtils.enemyBullets.get(gameUtils.enemyBullets.size()-1));

        }
        if (count % 20 == 0) {
            //敌方
            enemyObj enemyObj = new enemyObj(gameUtils.dr2(), (int) (Math.random() * 12) * 50, 0, 50, 50, 5, this);
            gameUtils.enemys.add(enemyObj);
            gameUtils.objs.add(gameUtils.enemys.get(gameUtils.enemys.size() - 1));
            bossCome++;
        }
        if (bossCome>50&&bossObj==null){
            bossObj=new bossObj(gameUtils.boss(),250,0,155,100,5,this);
            gameUtils.objs.add(bossObj);
        }
    }
    private void playMusic(){
        try {
            File sound = new File("D:\\A--Projects\\java\\java1\\plane\\music\\toilet-soap.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sound);
            bgMusic = AudioSystem.getClip();
            bgMusic.open(audioInputStream);
            bgMusic.loop(Clip.LOOP_CONTINUOUSLY); // 循环播放
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void closeBackgroundMusic() {
        if (bgMusic != null && bgMusic.isOpen()) {
            bgMusic.close();
        }
    }
}

