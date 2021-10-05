package baseball;

import java.util.HashMap;

import baseball.Domain.Screen.MenuScreen;
import baseball.Domain.Screen.PlayScreen;
import baseball.Domain.Screen.Screen;
import baseball.Enum.ScreenSequence;

public class GameMainLoop {
    ScreenSequence screenSequence;
    HashMap<ScreenSequence, Screen> screenMap = new HashMap<ScreenSequence, Screen>();

    GameMainLoop() {
        screenMap.put(ScreenSequence.MENU, new MenuScreen(this));
        screenMap.put(ScreenSequence.GAMEPLAY, new PlayScreen(this));

        screenSequence = ScreenSequence.GAMEPLAY;
    }

    public void Run() {
        while(acceptScreenSequence(screenSequence)) {
        }
    }

    private boolean acceptScreenSequence(ScreenSequence screenSequence) {
        if(screenSequence == ScreenSequence.QUIT) {
            return false;
        }

        screenMap.get(screenSequence).run();

        return true;
    }

    public void setScreenSequence(ScreenSequence screenSequence) {
        this.screenSequence = screenSequence;
    }
}