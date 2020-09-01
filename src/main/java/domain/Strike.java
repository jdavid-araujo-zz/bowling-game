package domain;

public class Strike extends Frame {
    public Strike(Roll roll, Integer total) {
        super(roll, new Roll(0), total);
    }

    public Strike(Roll firstRoll, Roll secondRoll, Roll thirdRoll, Integer total) {
        super(firstRoll, secondRoll, thirdRoll, total);
    }

    @Override
    public boolean isStrike() {
        return true;
    }
}
