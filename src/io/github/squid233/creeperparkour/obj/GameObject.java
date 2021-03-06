package io.github.squid233.creeperparkour.obj;

import java.awt.*;

/**
 * @author squid233
 */
public class GameObject {

    /**
     * 坐标x
     */
    protected int x;
    /**
     * 坐标y
     */
    protected int y;

    /**
     * 渲染此GameObject
     *
     * @param g 目标Graphics
     */
    public void draw(Graphics g) {

    }

    /**
     * 设置坐标
     */
    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * 移动指定偏移坐标
     */
    public void transfer(int x, int y) {
        setPosition(this.x + x, this.y + y);
    }

    //下面就不解释了

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * 在游戏的每帧被调用
     */
    public void onTick() {

    }

}
