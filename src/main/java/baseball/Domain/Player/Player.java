package baseball.Domain.Player;

import baseball.Domain.BallNumber.BallNumber;

public abstract class Player {
    BallNumber ball;

    public abstract BallNumber generateBallNumber();
}