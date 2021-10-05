package baseball.Domain.Player;

import baseball.Domain.BallNumber.AiNumberGenerate;
import baseball.Domain.BallNumber.BallNumber;

public class AiPlayer extends Player {
    @Override
    public BallNumber generateBallNumber() {
        BallNumber ballNumber = new BallNumber();
        return ballNumber.generate(new AiNumberGenerate());
    }
}