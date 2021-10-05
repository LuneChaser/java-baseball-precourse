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

        while(isPlay(aiBallNumber)) {
        }
    }

    private boolean isPlay(BallNumber defenderNumber) {
        BallNumber attackerNumber = userPlayer.generateBallNumber();

        int strikeCount = getStrikeCount(defenderNumber, attackerNumber);
        int ballCount = getBallCount(defenderNumber, attackerNumber);

        renderResult(strikeCount, ballCount);

        if(isWin(strikeCount)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            
            this.changeScreenSequence(ScreenSequence.MENU);
            
            return false;
        }

        return true;
    }

    private int getStrikeCount(BallNumber defenderNumber, BallNumber attackerNumber) {
        int strikeCount = 0 ;

        byte[] attackerNumberItems = attackerNumber.getNumber().getBytes();

        for(int i = 0; i < attackerNumberItems.length; i++) {
            strikeCount += countStrike(attackerNumberItems[i], i , defenderNumber);
        }

        return strikeCount;
    }

    private int countStrike(byte attackerNumber, int checkIndex, BallNumber defenserNumber) {
        if(defenserNumber.getNumber().getBytes()[checkIndex] == attackerNumber) {
            return 1;
        }

        return 0;
    }

    private int getBallCount(BallNumber defenderNumber, BallNumber attackerNumber) {
        int ballCount = 0 ;

        byte[] attackerNumberItems = attackerNumber.getNumber().getBytes();

        for(int i = 0; i < attackerNumberItems.length; i++) {
            ballCount += countBall(attackerNumberItems[i], i , defenderNumber);
        }

        return ballCount;
    }

    private int countBall(byte attackerNumber, int checkIndex, BallNumber defenserNumber) {
        String tempUserNumber = defenserNumber.getNumber();

        if(countStrike(attackerNumber, checkIndex, defenserNumber) == 0 && tempUserNumber.indexOf(attackerNumber) > -1) {
            return 1;
        }

        return 0;
    }

    private void renderResult(int strikeCount, int ballCount) {
        if(strikeCount < 1 && ballCount < 1) {
            System.out.println("낫싱");
            return;
        }

        String printText = "";

        printText += strikeCount > 0 ? strikeCount + "스트라이크 " : "";
        printText += ballCount > 0 ? ballCount + "볼" : "";

        System.out.println(printText);
    }

    private boolean isWin(int strikeCount) {
        if(strikeCount == 3) {
            return true;
        }

        return false;
    }
}
