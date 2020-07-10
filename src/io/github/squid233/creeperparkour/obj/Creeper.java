package io.github.squid233.creeperparkour.obj;

import io.github.squid233.creeperparkour.client.Main;
import io.github.squid233.creeperparkour.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author squid233
 */
public class Creeper extends Sprite {

    private int var0 = 1;
    private boolean isSpaceKeyDown = false;

    public Creeper(String filePath) {
        super(filePath);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x + Main.BORDER_SIDE, y, 16, 52, null);
    }

    @Override
    public void onTick() {
        //移动速度
        int speed = 4;

        //按下左方向键时
        if (Input.getKeyDown(KeyEvent.VK_LEFT)) {
            //左移(x轴负方向)
            this.transfer(-1 * speed, 0);
        }
        if (Input.getKeyDown(KeyEvent.VK_RIGHT)) {
            //右移(x轴正方向)
            this.transfer(speed, 0);
        }
        if (Input.getKeyDown(KeyEvent.VK_SPACE)) {
            /*if (var0 <= image.getHeight(null) >> 1 && var0 != 0) {
                //上移(y轴负方向)
                this.transfer(0, -1);
                ++var0;
            } else {
                for (int i = 0; i < 26; i++) {
                    fall();
                }
                var0 = 1;
            }*/
            if (isSpaceKeyDown) {
                transfer(0, -26);
                isSpaceKeyDown = false;
            }// FIXME: 2020/7/10 0010 physics engine need to fix!!!
        }
        if (Input.getKeyDown(KeyEvent.VK_ESCAPE)) {
            System.out.println("Game has been quit!");
            System.exit(0);
        }
        isSpaceKeyDown = true;
        /*640-52-8+16
        if (getY() <= 596 && getY() >= 623) {
            transfer(0, 1);
        }*/
    }

    private void fall() {
        transfer(0, 1);
    }
}
