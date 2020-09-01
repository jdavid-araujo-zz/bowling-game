package util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RollRegex {

    private static final String ROLL_PATTER = "\\D+\\s(\\d{1,2}|F{1})";
    private static final String POSITIVE_NUMBER_PATTER = "\\d++";
    private static final String KNOCKED_DOWN = "F";
    private static Pattern p;

    static private Matcher checkMatch(String patter, String value) {
        p = Pattern.compile(patter);

        return p.matcher(value);
     }

    /**
     * Check the input of the roll has the required parameters
     * @param roll The input of the roll(player roll)
     * @return A array with the player and the value of the roll
     */
    static public String[] getRoll(String roll) {
        Matcher m = checkMatch(ROLL_PATTER, roll);
        String [] data = null;
        if(m.find()) {
            data = m.group().split("\\s");

            isSmallerThan11rKnockedDown(data[1]);

            return data;
        } else {
            throw new RuntimeException("Roll is not in the proper format");
        }

    }

    /**
     * Check is the roll is more than 10 and if get  String different of F
     * @param value
     */
    static private void isSmallerThan11rKnockedDown(String value) {
        Matcher m = checkMatch(POSITIVE_NUMBER_PATTER, value);

        if(m.find()) {
            Integer roll = Integer.valueOf(value);

            if(roll > 10) {
                throw new RuntimeException("A play cannot have a value greater than 10");
            }
        } else {
            if (!value.equals(KNOCKED_DOWN)) {
                throw new RuntimeException("String cannot have a value other than F");
            }
        }
    }

}
