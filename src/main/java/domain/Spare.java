package domain;

public class Spare extends Frame {

    public Spare(Roll firstRoll, Roll secondRoll, Integer total) {
        super(firstRoll, secondRoll, total);
    }

    public Spare(Roll firstRoll, Roll secondRoll, Roll thirdRoll, Integer total) {
        super(firstRoll, secondRoll, thirdRoll, total);
    }

    @Override
    public boolean isSpare() {
        return true;
    }
}
