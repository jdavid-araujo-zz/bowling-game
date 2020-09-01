package util.vo;

import domain.Roll;

public class RollVO {
    private String player;
    private Roll value;

    public RollVO(String player, Roll value) {
        this.player = player;
        this.value = value;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Roll getValue() {
        return value;
    }

    public void setValue(Roll value) {
        this.value = value;
    }
}
