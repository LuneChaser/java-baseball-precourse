package baseball.Domain.BallNumber;

import nextstep.utils.Console;

public class UserNumberGenerate implements NumberGenerate {
    @Override
    public String generate() {
        String numbers = Console.readLine();

        checkInputSize(numbers);

        for(char numberChar : numbers.toCharArray())
        {
            checkInputValue(numberChar);
        }

        return numbers;
    }

    private void checkInputSize(String numbers) {
        if(numbers.length() < 1 || numbers.length() > 3) {
            throw  new IllegalArgumentException("[ERROR] 사용자 입력값이 잘못되었습니다. - 3자리로 입력해주세요.");
        }
    }

    private void checkInputValue(char numberChar) {
        if( numberChar < '1' || numberChar > '9' ) {
            throw  new IllegalArgumentException("[ERROR] 사용자 입력값이 잘못되었습니다. - 1~9값만 입력이 가능합니다.");
        }
    }
}