package domain.service;

import domain.Frame;
import domain.Roll;
import domain.Spare;
import domain.Strike;
import util.ConvertGameResultToString;
import util.parse.RollParse;
import util.printer.Printer;
import util.printer.PrinterConsole;
import util.reader.Read;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrameService {

    private static final Integer FRAMES_NUMBER = 10;
    private static final Integer SPARE_STRIKE_VALUE = 10;

    private Read read;
    private String path;
    private Map<String, List<Frame>> gameData;
    Map<String, List<Roll>> playerRollMap;

    public FrameService() {
        playerRollMap = new HashMap<>();
        gameData = new HashMap<>();
    }

    public FrameService(Read read, String path) {
        this.read = read;
        this.path = path;
        playerRollMap = new HashMap<>();
        gameData = new HashMap<>();
    }

    public Map<String, List<Frame>> getGameData() {
        return gameData;
    }

    /**
     * Process the data
     */
    public void start() {
        this.read.open(this.path);
        List<String> rolls = read.readlAll();
        this.playerRollMap = RollParse.getRollWithPlayer(rolls);

        this.playerRollMap.forEach((key, values) -> this.calcule(key, values));

        ConvertGameResultToString gameResult = new ConvertGameResultToString();
        String print = gameResult.convert(this.gameData);

        Printer p = new PrinterConsole();
        p.print(print);
    }

    /**
     * Calcule the frames to a player
     * @param player The name of a current player
     * @param values The list of the roll
     */
    public void calcule(String player, List<Roll> values) {
        Integer currentResult = 0;
        Integer cursor = 0;
        List<Frame> currentFrameList = null;

            for (int frame = 0; frame < SPARE_STRIKE_VALUE; frame++) {
                currentFrameList = this.getListFrame(player);

                if(this.isStrike(values.get(cursor))) {
                    currentResult += getRollValueStrike(cursor, values);
                    currentFrameList.add(this.addNewStrike(frame, currentResult, values.get(cursor+1), values.get(cursor+2)));
                    cursor++;
                } else if(this.isSpare(cursor, values)) {
                    currentResult += getRollValueSpare(cursor, values);
                    currentFrameList.add(this.addNewSpare(frame, cursor, values, currentResult));
                    cursor += 2;
                } else {
                    currentResult += getRollValue(cursor, values);
                    currentFrameList.add(this.addNewFrame(frame, cursor, values, currentResult));
                    cursor += 2;
                }

                this.gameData.put(player, currentFrameList);
            }
    }

    private Strike addNewStrike(int frame, Integer currentResult, Roll nextRoll, Roll nextNextRoll) {
        if(frame != FRAMES_NUMBER - 1) {
            return new Strike(new Roll(SPARE_STRIKE_VALUE), currentResult);
        } else {
            return new Strike(new Roll(SPARE_STRIKE_VALUE), nextRoll, nextNextRoll, currentResult);
        }
    }

    private Spare addNewSpare(int frame, Integer cursor, List<Roll> values, Integer currentResult) {
        if(frame != FRAMES_NUMBER - 1) {
            return new Spare(values.get(cursor), values.get(cursor + 1), currentResult);
        } else {
            return new Spare(values.get(cursor), values.get(cursor + 1), values.get(cursor + 2), currentResult);
        }
    }

    private Frame addNewFrame(int frame, Integer cursor, List<Roll> values, Integer currentResult) {
        if(frame != FRAMES_NUMBER - 1) {
            return new Frame(values.get(cursor), values.get(cursor + 1), currentResult);
        } else {
            return new Frame(values.get(cursor), values.get(cursor + 1), values.get(cursor + 1), currentResult);
        }
    }

    public boolean isStrike(Roll value) {
        return  (value.getNumberOfPins().equals(SPARE_STRIKE_VALUE));
    }

    public boolean isSpare(Integer roll, List<Roll> values) {
        return  (values.get(roll).getNumberOfPins() + values.get(roll+1).getNumberOfPins() == SPARE_STRIKE_VALUE);
    }

    public List<Frame> getListFrame(String player) {
        return this.gameData.get(player) == null ? new ArrayList<>() : this.gameData.get(player);
    }

    public Integer getRollValueStrike(Integer roll, List<Roll> values) {
        return SPARE_STRIKE_VALUE + values.get(roll + 1).getNumberOfPins() + values.get(roll + 2).getNumberOfPins();
    }

    public Integer getRollValueSpare(Integer roll, List<Roll> values) {
        return  SPARE_STRIKE_VALUE + values.get(roll + 2).getNumberOfPins();
    }

    public Integer getRollValue(Integer roll, List<Roll> values) {
        return values.get(roll).getNumberOfPins() + values.get(roll + 1).getNumberOfPins();

    }
}
