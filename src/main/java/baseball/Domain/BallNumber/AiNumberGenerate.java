package baseball.Domain.BallNumber;

import java.util.ArrayList;

import nextstep.utils.Randoms;

public class AiNumberGenerate implements NumberGenerate {
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    @Override
    public String generate() {
        while(numbers.size() < 3) {
            addNumber(Randoms.pickNumberInRange(1, 9));
        }

        return makeBallNumber();
    }

    private void addNumber(int number) {
        if(!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    private String makeBallNumber() {
        String numberString = "";

        for(Integer number : numbers) {
            numberString += number.toString();
        }

        return numberString;
    }
}