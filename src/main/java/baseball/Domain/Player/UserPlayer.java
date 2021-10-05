package baseball.Domain.Player;

import baseball.Domain.BallNumber.BallNumber;
import baseball.Domain.BallNumber.UserNumberGenerate;

public class UserPlayer extends Player {
    @Override
    public BallNumber generateBallNumber() {
        BallNumber ballNumber = new BallNumber();

        System.out.println("숫자를 입력해주세요");

        return ballNumber.generate(new UserNumberGenerate());
    }
}