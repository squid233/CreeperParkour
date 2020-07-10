package io.github.squid233.creeperparkour.obj;

import io.github.squid233.creeperparkour.client.Main;

import java.awt.*;

/**
 * @author squid233
 */
public class GrassBlock extends Sprite {
    public GrassBlock(String filePath) {
        super(filePath);
    }

    @Override
    public void onTick() {
        while (getX() < Main.game.getWidth()) {
            transfer(1, 0);
        }
    }
}
