package util;

import domain.Frame;
import java.util.List;
import java.util.Map;

public class ConvertGameResultToString {

    public String convert(Map<String, List<Frame>> game) {
        StringBuffer result = new StringBuffer();

        result.append(this.getHeader());

        game.forEach((keys, values) -> result.append(this.getPlayerLines(keys, values)));

        return result.toString();
    }

    /**
     * Create the Header
     * @return The header of the print
     */
  String getHeader() {
      StringBuffer result = new StringBuffer();

      result.append("Frame         ");
      result.append("1     ");
      result.append("2     ");
      result.append("3     ");
      result.append("4     ");
      result.append("5     ");
      result.append("6     ");
      result.append("7     ");
      result.append("8     ");
      result.append("9     ");
      result.append("10    ");
      result.append("\n");

      return result.toString();
  }

    /**
     * Create the line of the players
     * @param player The name of the plauer
     * @param values The list of the Frame
     * @return The result formatted to the player
     */
  String getPlayerLines(String player, List<Frame> values) {
      StringBuffer result = new StringBuffer();
      result.append(player);
      result.append("\n");
      result.append("Pinfall       ");
      result.append(this.getRollsLine(values));
      result.append("\n");
      result.append("Score         ");
      result.append(this.getScoreLine(values));
      result.append("\n");

      return result.toString();
  }

    /**
     * Create the print to the rolls
     * @param values A list of Frame
     * @return The print of the rolls
     */
  String getRollsLine(List<Frame> values) {
      StringBuffer result = new StringBuffer();

      for(Frame frame: values) {
            if(frame.isStrike()) {
                if(frame.getThirdRoll() == null) {
                    result.append("  X   ");
                } else {
                    result.append("X ");
                    result.append(!frame.getSecondRoll().isFoul() ?  this.convertRollValue(frame.getSecondRoll().getNumberOfPins()) : "F");
                    result.append(" ");
                    result.append(!frame.getThirdRoll().isFoul() ? this.convertRollValue(frame.getThirdRoll().getNumberOfPins()) : "F");
                }
          } else if(frame.isSpare()) {
                result.append(!frame.getFirstRoll().isFoul() ? frame.getFirstRoll().getNumberOfPins() : "F");
                result.append(" ");
                if(frame.getThirdRoll() == null) {
                    result.append("/   ");
                } else {
                    result.append("/ ");
                    result.append(!frame.getThirdRoll().isFoul() ? this.convertRollValue(frame.getThirdRoll().getNumberOfPins()) : "F");

                }
            } else {
                result.append(!frame.getFirstRoll().isFoul() ? frame.getFirstRoll().getNumberOfPins() : "F");
                result.append(" ");
                result.append(!frame.getSecondRoll().isFoul() ? frame.getSecondRoll().getNumberOfPins() : "F");
                result.append("   ");
            }
      }

      return result.toString();
  }

  String getScoreLine(List<Frame> values) {
      StringBuffer result = new StringBuffer();
      for(Frame frame: values) {
          result.append(frame.getTotal());
          result.append(this.getNumberOfSpaceBasedOnNumberOfDigits(frame.getTotal()));
      }

      return result.toString();
  }

  String convertRollValue(Integer value) {
        switch (value) {
            case 10: return "X";
            default: return value.toString();
        }
  }

  private String getNumberOfSpaceBasedOnNumberOfDigits(Integer number) {
      int length = 0;
      long temp = 1;
      while (temp <= number) {
          length++;
          temp *= 10;
      }

      switch (length) {
          case 0:
          case 1: return "     ";
          case 3: return "   ";
          default: return  "    ";
      }
  }

}
