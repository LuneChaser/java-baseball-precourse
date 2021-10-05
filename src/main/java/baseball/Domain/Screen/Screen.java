package baseball.Domain.Screen;

import baseball.GameMainLoop;
import baseball.Enum.ScreenSequence;

public abstract class Screen {
    GameMainLoop gameLoop;

    public Screen(GameMainLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    protected void changeScreenSequence(ScreenSequence screenSequence) {
        gameLoop.setScreenSequence(screenSequence);
    }

    public abstract void run();
}
