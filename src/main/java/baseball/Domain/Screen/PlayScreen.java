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
        final BallNumber aiBallNumber = aiPlayer.generateBallNumber();

        while(play(aiBallNumber)) {
        }
    }

    private boolean play(BallNumber defenderNumber) {
        BallNumber userNumber = userPlayer.generateBallNumber();

        int strikeCount = getStrikeCount(defenderNumber, userNumber);
        int ballCount = getBallCount(defenderNumber, userNumber);

        if(isComplete(strikeCount, ballCount)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            
            this.changeScreenSequence(ScreenSequence.MENU);
            
            return false;
        }

        return true;
    }

    private int getStrikeCount(BallNumber userNumber, BallNumber aiNumber) {
        int strikeCount = 0 ;

        String tempUserNumber = userNumber.getNumber();

        for(int i = 0; i < tempUserNumber.getBytes().length; i++) {
            strikeCount += checkStrike(tempUserNumber.getBytes()[i], i , aiNumber);
        }

        return strikeCount;
    }

    private int checkStrike(byte attackerNumber, int checkIndex, BallNumber defenserNumber) {
        String tempUserNumber = defenserNumber.getNumber();

        if( tempUserNumber.getBytes()[checkIndex] == attackerNumber) {
            return 1;
        }

        return 0;
    }

    private int getBallCount(BallNumber userNumber, BallNumber aiNumber) {
        int ballCount = 0 ;

        String tempUserNumber = userNumber.getNumber();

        for(int i = 0; i < tempUserNumber.getBytes().length; i++) {
            ballCount += checkBall(tempUserNumber.getBytes()[i], i , aiNumber);
        }

        return ballCount;
    }

    private int checkBall(byte attackerNumber, int checkIndex, BallNumber defenserNumber) {
        String tempUserNumber = defenserNumber.getNumber();

        if(checkStrike(attackerNumber, checkIndex, defenserNumber) == 0 && tempUserNumber.indexOf(attackerNumber) > -1) {
            return 1;
        }

        return 0;
    }

    private boolean isComplete(int strikeCount, int ballCount) {
        if(strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            return true;
        } else if(strikeCount < 1 && ballCount < 1) {
            System.out.println("낫싱");
            return false;
        }

        String printText = "";

        printText += strikeCount > 0 ? strikeCount + "스트라이크 " : "";
        printText += ballCount > 0 ? ballCount + "볼" : "";

        System.out.println(printText);

        return false;
    }
}
