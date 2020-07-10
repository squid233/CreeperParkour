package io.github.squid233.creeperparkour.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 * @author squid233
 */
public class Input implements KeyListener {
    private static HashMap<Integer, Boolean> keys;
    /**存放的按键数量*/
    public final static int KEY_COUNTS = 300;

    public void init() {
        keys = new HashMap<>(KEY_COUNTS);
        for (int i = 0; i < KEY_COUNTS; i++) {
            keys.put(i, false);
        }
    }

    @Override
    public void keyPressed(KeyEvent key)//有按键按下时
    {
        //设置对应按键状态为true
        keys.put(key.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent key)//有按键松开时
    {
        //设置对应按键状态为false
        keys.put(key.getKeyCode(), false);
    }

    @Override
    public void keyTyped(KeyEvent key) {

    }

    public static boolean getKeyDown(int keyCode) {
        //返回对应按键的状态
        return keys.get(keyCode);
    }

}
