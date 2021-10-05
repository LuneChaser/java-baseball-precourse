package baseball.Domain.Screen;

import baseball.Domain.BallNumber.BallNumber;
import baseball.Domain.Player.AiPlayer;
import baseball.Domain.Player.UserPlayer;
import baseball.Enum.ScreenSequence;
import baseball.GameMainLoop;

public class PlayScreen extends Screen {
    private AiPlayer aiPlayer;
    private UserPlayer userPlayer;

    public PlayScreen(GameMainLoop gameLoop) {
        super(gameLoop);

        aiPlayer = new AiPlayer();
        userPlayer = new UserPlayer();
    }

    @Override
    public void run() {
        BallNumber aiBallNumber = aiPlayer.generateBallNumber();

        while(play(aiBallNumber)) {
        }
    }

    private boolean play(BallNumber defenderNumber) {
        this.changeScreenSequence(ScreenSequence.MENU);
        return false;
    }
}
