package util.regex;

import java.util.List;
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

    static public String[] getRoll(String roll) {
        Matcher m = checkMatch(ROLL_PATTER, roll);
        String [] data = null;
        if(m.find()) {
            data = m.group().split("\\s");

            data[1] = isSmallerThan11rKnockedDown(data[1]);

            return data;
        } else {
            throw new RuntimeException("Roll não está no formato adequado");
        }

    }

    static private String isSmallerThan11rKnockedDown(String value) {
        Matcher m = checkMatch(POSITIVE_NUMBER_PATTER, value);

        if(m.find()) {
            Integer roll = Integer.valueOf(value);

            if(roll > 10) {
                throw new RuntimeException("Uma jogada não pode ter valor maior que 10");
            }
        } else {
            if (!value.equals(KNOCKED_DOWN)) {
                throw new RuntimeException("String não pode ter valor diferente de F");
            } else {
                return "0";
            }
        }

        return value;
    }

}
