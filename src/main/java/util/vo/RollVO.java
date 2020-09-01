package util.vo;

public class RollVO {
    private String player;
    private Integer value;

    public RollVO(String player, Integer value) {
        this.player = player;
        this.value = value;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
