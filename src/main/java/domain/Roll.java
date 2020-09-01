package domain;

public class Roll {

    private Integer numberOfPins;

    private boolean foul;

    public Roll(Integer numberOfPins) {
        this.numberOfPins = numberOfPins;
    }

    public Roll(Integer numberOfPins, boolean foul) {
        this.numberOfPins = numberOfPins;
        this.foul = foul;
    }

    public Integer getNumberOfPins() {
        return numberOfPins;
    }

    public void setNumberOfPins(Integer numberOfPins) {
        this.numberOfPins = numberOfPins;
    }

    public boolean isFoul() {
        return foul;
    }

    public void setFoul(boolean foul) {
        this.foul = foul;
    }

    public static Roll foul() {
        return new Roll(0, true);
    }
}
