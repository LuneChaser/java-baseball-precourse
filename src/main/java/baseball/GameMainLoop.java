package baseball;

import baseball.Enum.ScreenSequence;

public class GameMainLoop {
    ScreenSequence screenSequence;

    GameMainLoop() {
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
        
        return true;
    }

    public void setScreenSequence(ScreenSequence screenSequence) {
        this.screenSequence = screenSequence;
    }
}