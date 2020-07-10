package io.github.squid233.creeperparkour.obj;

import io.github.squid233.creeperparkour.client.Main;

import java.awt.*;

/**
 * @author squid233
 */
public class Sprite extends GameObject {
    protected final Image image;

    public Sprite(String filePath) {
        //从文件里加载图片
        image = Toolkit.getDefaultToolkit().createImage(filePath);
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void draw(Graphics g) {
        //在(x,y)处绘制图片，不拉伸，原图片多大，画出来就多大
        g.drawImage(image, x + Main.BORDER_SIDE, y, null);
    }

}
