package io.github.squid233.creeperparkour.client;

import io.github.squid233.creeperparkour.client.engine.Game;
import io.github.squid233.creeperparkour.obj.Creeper;
import io.github.squid233.creeperparkour.obj.GrassBlock;

/**
 * @author squid233
 */
public class Main {

    public static final int BORDER_SIDE = 8;
    public static final int BORDER_TOP = 39;
    public static Game game;
    public static Creeper creeper = new Creeper("creeper.png");

    public static void main(String[] args) {

        try {
            game = new Game(Boolean.parseBoolean(args[0]), 30);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Start args is not found, default false");
            game = new Game(false, 30);
        }

        creeper.setPosition(0, game.getHeight() - (BORDER_SIDE + 52) - 16);
        GrassBlock grassBlock = new GrassBlock("grass_block.png");
        grassBlock.setPosition(0, game.getHeight() - (BORDER_SIDE + 16));
        game.addGameObjects(grassBlock, creeper);

    }

}
