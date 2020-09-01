package domain;

public class Frame {

    private Roll firstRoll;
    private Roll secondRoll;
    private Roll thirdRoll;
    private Integer total;

    protected Frame(Roll roll) {
        this(roll, new Roll(0));
    }

    public Frame(Roll firstRoll, Roll secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public Frame(Roll firstRoll, Roll secondRoll, Integer total) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.total = total;
    }

    public Frame(Roll firstRoll, Roll secondRoll, Roll thirdRoll, Integer total) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.thirdRoll = thirdRoll;
        this.total = total;
    }

    public Roll getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(Roll firstRoll) {
        this.firstRoll = firstRoll;
    }

    public Roll getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(Roll secondRoll) {
        this.secondRoll = secondRoll;
    }

    public Roll getThirdRoll() {
        return thirdRoll;
    }

    public void setThirdRoll(Roll thirdRoll) {
        this.thirdRoll = thirdRoll;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isSpare() {
        return false;
    }
}
