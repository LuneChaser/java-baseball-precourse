package baseball.Domain.BallNumber;

public class BallNumber {
    String number;

    public BallNumber() {
        number = "";
    }

    public BallNumber generate(NumberGenerate numberStrategy) {
        number = numberStrategy.generate();

        return this;
    }

    public String getNumber() {
        return number;
    }
}