package domain.service;

import domain.Frame;
import domain.Spare;
import domain.Strike;
import util.ConvertGameToSting;
import util.reader.Read;
import util.regex.RollRegex;
import util.vo.RollVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrameService {

    private Read read;
    private List<RollVO> gameValues;
    private static final Integer FRAMES_NUMBER = 10;
    private static final Integer SPARE_STRIKE_VALUE = 10;
    private Map<String, List<Frame>> game = new HashMap<>();
    Map<String, List<Integer>> rollTest = new HashMap<>();

    public FrameService(Read read, String path) {
        this.read = read;
        this.read.open(path);
        this.gameValues = new ArrayList<>();
    }

    public List<RollVO>  readAllRoll() {
        List<String> rolls = read.readlAll();
        List<RollVO> values = new ArrayList<>();

        rolls.forEach(r -> {
            String[] data = RollRegex.getRoll(r);
            values.add(new RollVO(data[0], Integer.valueOf(data[1])));
        });

        return values;
    }

    public void start() {
        List<Integer> test = null;
            this.gameValues = this.readAllRoll();
            for(RollVO roll : this.gameValues) {
                test = this.rollTest.get(roll.getPlayer()) == null ? new ArrayList<>() : this.rollTest.get(roll.getPlayer());
                test.add(roll.getValue());
            this.rollTest.put(roll.getPlayer(), test);
         }
            this.rollTest.forEach((key, values) -> this.calcule(key, values));

        ConvertGameToSting sa = new ConvertGameToSting();
        System.out.println(sa.convert(this.game));
        }

    public void calcule(String player, List<Integer> values) {
        Integer currentResult = 0;
        Integer cursor = 0;
            List<Frame> currentFrameList = null;
            for (int frame = 0; frame < SPARE_STRIKE_VALUE; frame++) {
                currentFrameList = this.getListFrame(player);
                if(this.isStrike(values.get(cursor))) {
                    currentResult += getRollValueStrike(cursor, values);
                    if(frame != FRAMES_NUMBER - 1) {
                        currentFrameList.add(new Strike(SPARE_STRIKE_VALUE, currentResult));
                    } else {
                        currentFrameList.add(new Strike(SPARE_STRIKE_VALUE,values.get(cursor+1), values.get(cursor+2), currentResult));
                    }
                    this.game.put(player, currentFrameList);
                    cursor++;
                } else if(this.isSpare(cursor, values)) {
                    currentResult += getRollValueSpare(cursor, values);
                    if(frame != FRAMES_NUMBER - 1) {
                        currentFrameList.add(new Spare(values.get(cursor), values.get(cursor + 1), currentResult));
                    } else {
                        currentFrameList.add(new Spare(values.get(cursor), values.get(cursor + 1), values.get(cursor + 2), currentResult));
                    }
                    this.game.put(player, currentFrameList);
                    cursor += 2;
                } else {
                    currentResult += getRollValue(cursor, values);
                    if(frame != FRAMES_NUMBER - 1) {
                        currentFrameList.add(new Frame(values.get(cursor), values.get(cursor + 1), currentResult));
                    } else {
                        currentFrameList.add(new Frame(values.get(cursor), values.get(cursor + 1), values.get(cursor + 1), currentResult));
                    }
                    this.game.put(player, currentFrameList);
                    cursor += 2;
                }
            }
    }

    List<Frame> getListFrame(String player) {
        return this.game.get(player) == null ? new ArrayList<>() : this.game.get(player);
    }

    Integer getRollValueStrike(Integer roll, List<Integer> values) {
        return SPARE_STRIKE_VALUE + values.get(roll + 1) + values.get(roll + 2);
    }

    Integer getRollValueSpare(Integer roll, List<Integer> values) {
        return  SPARE_STRIKE_VALUE + values.get(roll + 2);
    }

    Integer getRollValue(Integer roll, List<Integer> values) {
        return values.get(roll) + values.get(roll + 1);

    }

    boolean isStrike(Integer value) {
        return  (value.equals(SPARE_STRIKE_VALUE));
    }

    boolean isSpare(Integer roll, List<Integer> values) {
        return  (values.get(roll) + values.get(roll+1) == SPARE_STRIKE_VALUE);
    }

}
