package domain;

public class Spare extends Frame {

    public Spare(Integer firstRoll, Integer secondRoll, Integer total) {
        super(firstRoll, secondRoll, total);
    }

    public Spare(Integer firstRoll, Integer secondRoll, Integer thirdRoll, Integer total) {
        super(firstRoll, secondRoll, thirdRoll, total);
    }

    @Override
    public boolean isSpare() {
        return true;
    }
}
