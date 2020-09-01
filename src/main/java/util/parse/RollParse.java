package util.parse;

import domain.Roll;

public class RollParse {

    static Roll converStringToRoll(String roll) {
        if(roll.equals("F")) {
            return Roll.foul();
        }

        return new Roll(Integer.valueOf(roll));
    }


}
