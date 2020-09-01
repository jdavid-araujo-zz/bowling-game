package util.parse;

import domain.Roll;
import org.apache.commons.lang3.math.NumberUtils;
import util.regex.RollRegex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RollParse {

    private RollParse() {}

    /**
     * Convert the Roll of the input
     * @param inputRolls The Rolls of the input
     * @return A map of each roll organized by player
     */
    static public Map<String, List<Roll>> getRollWithPlayer(List<String> inputRolls) {
        Map<String, List<Roll>> rollMap = new HashMap<>();

        inputRolls.forEach(r -> {
            String[] inputRoll = RollRegex.getRoll(r);
            Roll roll = convertInputRollToRoll(inputRoll[1]);

            List<Roll> rolls  = rollMap.get(inputRoll[0]) == null ? new ArrayList<>() : rollMap.get(inputRoll[0]);
            rolls.add(roll);
            rollMap.put(inputRoll[0], rolls);
        });

        return rollMap;
    }

    /**
     * Convert the input of the roll to a model
     * @param inputRoll A input of the Roll
     * @return The model
     */
    static private Roll convertInputRollToRoll(String inputRoll)  {
        if(NumberUtils.isDigits(inputRoll)) {
            return new Roll(Integer.valueOf(inputRoll));
        }

        return Roll.foul();
    }

}
