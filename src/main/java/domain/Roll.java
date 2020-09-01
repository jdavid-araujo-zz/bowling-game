package domain;

public class Roll {

    private Integer numberOfPins;

    public Roll(Integer numberOfPins) {
        this.numberOfPins = numberOfPins;
    }

    public Integer getNumberOfPins() {
        return numberOfPins;
    }

    public void setNumberOfPins(Integer numberOfPins) {
        this.numberOfPins = numberOfPins;
    }

    public void setNumberOfPins(String numberOfPins) {
        this.numberOfPins = Integer.valueOf(numberOfPins);
    }

    public static Roll foul() {
        return new Roll(0);
    }


}
