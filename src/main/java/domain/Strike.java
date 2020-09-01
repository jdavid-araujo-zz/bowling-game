package domain;

public class Strike extends Frame {
    public Strike(Integer roll, Integer total) {
        super(roll, 0, total);
    }

    public Strike(Integer firstRoll, Integer secondRoll, Integer thirdRoll, Integer total) {
        super(firstRoll, secondRoll, thirdRoll, total);
    }

    @Override
    public boolean isStrike() {
        return true;
    }
}
