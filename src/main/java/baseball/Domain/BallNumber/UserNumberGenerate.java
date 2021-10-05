package baseball.Domain.BallNumber;

import nextstep.utils.Console;

public class UserNumberGenerate implements NumberGenerate {
    @Override
    public String generate() {
        String numbers = "";

        do {
            numbers = Console.readLine();
        } while(isInvalidInput(numbers));

        return numbers;
    }

    private boolean isInvalidInput(String numbers) {
        if(isInvalidInputSize(numbers)) {
            System.out.println("[ERROR] 사용자 입력값이 잘못되었습니다. - 3자리로 입력해주세요.");
            return true;
        }
        
        if(isInvalidInputValues(numbers)) {
            System.out.println("[ERROR] 사용자 입력값이 잘못되었습니다. - 1~9값만 입력이 가능합니다.");
            return true;
        }

        return false;
    }

    private boolean isInvalidInputSize(String numbers) {
        if(numbers.length() != 3) {
            return true;
        }

        return false;
    }

    private boolean isInvalidInputValues(String numbers) {
        boolean isInvalid = false;

        for(char numberChar : numbers.toCharArray())
        {
            isInvalid |= isInvalidInputValue(numberChar);
        }

        return isInvalid;
    }
    
    private boolean isInvalidInputValue(char numberChar) {
        if(numberChar < '1' || numberChar > '9') {
            return true;
        }

        return false;
    }
}