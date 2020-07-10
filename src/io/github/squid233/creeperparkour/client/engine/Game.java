package io.github.squid233.creeperparkour.client.engine;

import io.github.squid233.creeperparkour.client.CreeperParkourClient;
import io.github.squid233.creeperparkour.input.Input;
import io.github.squid233.creeperparkour.obj.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

/**
 * @author squid233
 */
public class Game extends JFrame {

    /**
     * 游戏的FPS
     */
    private int fps;
    private final int width = 800;
    private final int height = 640;
    private final ArrayList<GameObject> gameObjects;

    public Game(boolean resizable, int fps) {

        setFps(fps);

        //初始化
        gameObjects = new ArrayList<>();

        createWindow(resizable);

        //初始化线程
        RenderThread render = new RenderThread(this);
        //启动线程
        render.start();

        //初始化输入设备
        Input input = new Input();
        input.init();
        //设置游戏窗口的键盘监听器
        this.addKeyListener(input);

    }

    /**
     * 重写窗体绘制方法
     *
     * @param g 目标Graphins
     */
    @Override
    public void paint(Graphics g) {
        //双缓冲
        //在内存里创建一个和窗口长宽一样的图片(画布)
        Image img = this.createImage(width, height);
        //获得画布的Graphics
        Graphics tempGraphics = img.getGraphics();
        //将画布清除为背景色
        clear(tempGraphics, Color.decode("#6CB7E2"));

        //渲染所有的sprite
        for (GameObject gameObject : gameObjects) {
            gameObject.onTick();
            //在画布上画出每个物体
            gameObject.draw(tempGraphics);
        }

        //将内存画布的内容复制回窗口上
        g.drawImage(img, 0, 0, null);

        // do something
    }

    /**
     * 绘制背景
     *
     * @param g 目标Graphics
     * @param c 背景颜色
     */
    public void clear(Graphics g, Color c) {
        // 设置画笔为c
        g.setColor(c);
        // 填充整个窗口为c
        g.fillRect(0, 0, width, height);
    }

    /**
     * 添加文本到面板
     *
     * @param g    目标Graphics
     * @param c    文字颜色
     * @param text 文本
     */
    @Deprecated
    public void drawText(Graphics g, Color c, String text, int x, int y) {
        g.setColor(c);
        g.drawString(text, x + 8, y + 39);
    }

    @Deprecated
    public void drawImage(Graphics g, Image i, int x, int y) {
        drawImage(g, i, x, y, null);
    }

    @Deprecated
    public void drawImage(Graphics g, Image i, int x, int y, ImageObserver io) {
        g.drawImage(i, x + 8, y + 39, io);
    }

    public void createWindow(boolean resizable) {
        // set title
        this.setTitle("Creeper Parkour " + CreeperParkourClient.client.getVersion() + "[Esc:exit game]");
        // set size: width 800, height 600
        this.setSize(width, height);
        // set exit after close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置false为不可改变大小
        this.setResizable(true);
        // set visible
        this.setVisible(true);
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void addGameObjects(GameObject... gameObjects) {
        for (GameObject gameObject : gameObjects) {
            addGameObject(gameObject);
        }
    }


    /**
     * 退出游戏
     */
    public void exit() {
        System.exit(-1);
    }

    /**
     * 返回游戏的FPS
     */
    public int getFps() {
        if (fps == 0) {
            return 30;
        }
        return fps;
    }

    /**
     * 设置游戏的FPS
     *
     * @param fps 新FPS
     * @return 是否设置成功
     */
    public boolean setFps(int fps) {
        if (fps <= 0) {
            return false;
        } else {
            this.fps = fps;
            return true;
        }
    }

}
