package scenes;

import controllers.BackgroundController;
import controllers.DoorController;
import game.GameConfig;
import managers.EnemyManager;
import managers.ItemManager;
import models.Door;
import models.MainCharacter;
import utils.Utils;
import views.SingleView;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nhan on 5/1/2017.
 */
public class PlayScene2 extends PlayScene {
    public PlayScene2(){
        super(0, ActionType.PLAY_STAGE_2);
        this.sceneType = ActionType.PLAY_STAGE_2;
        MainCharacter.mainCharacter.setX(100);
        MainCharacter.mainCharacter.setDrawX(100);
        MainCharacter.mainCharacter.setZ(400);
        MainCharacter.mainCharacter.setDrawY(400);
        Dimension dimension = new Dimension(2400, 600);
        BufferedImage backgroundImage = Utils.setSize(Utils.loadImage("res/background_2.png"), dimension);
        backgroundController = new BackgroundController(bgScene, new SingleView(backgroundImage));
        controllerManager.clear();
        controllerManager.addController(mainCharacterController);
        doorController = new DoorController(new Door(GameConfig.MAP_START_X , 0, 400, sceneType));
        controllerManager.addController(doorController);
        enemyManager = new EnemyManager(0, 3);
        itemManager = new ItemManager(1, 1, 1);
    }
}
