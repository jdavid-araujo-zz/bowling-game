package domain;

public class Frame {

    private Integer firstRoll;
    private Integer secondRoll;
    private  Integer thirdRoll;
    private Integer total;

    protected Frame(Integer roll) {
        this(roll, 0);
    }

    public Frame(Integer firstRoll, Integer secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public Frame(Integer firstRoll, Integer secondRoll, Integer total) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.total = total;
    }

    public Frame(Integer firstRoll, Integer secondRoll, Integer thirdRoll, Integer total) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.thirdRoll = thirdRoll;
        this.total = total;
    }

    public Integer getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(Integer firstRoll) {
        this.firstRoll = firstRoll;
    }

    public Integer getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(Integer secondRoll) {
        this.secondRoll = secondRoll;
    }

    public Integer getThirdRoll() {
        return thirdRoll;
    }

    public void setThirdRoll(Integer thirdRoll) {
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
