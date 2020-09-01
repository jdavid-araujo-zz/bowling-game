import domain.Roll;
import domain.service.FrameService;
import org.junit.Before;
import org.junit.Test;
import util.reader.Read;
import util.reader.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GetRollTest {
    private static final String PATH = "perfect_score_exemple.txt";
    private FrameService frameService;
    private List<Roll> rolls;
    private String player1;

    @Before
    public void setup() {
        String path = BowlingGame.class.getResource(PATH).getPath();
        Read read = new ReadFile();
        this.frameService = new FrameService();
        this.player1 = "Jeff";
        this.rolls = new ArrayList<>(Arrays.asList(new Roll(10), new Roll(3),
                new Roll(7), new Roll(3), new Roll(4), new Roll(10), new Roll(3), new Roll(4),
                    new Roll(10), new Roll(10), new Roll(10), new Roll(10), new Roll(10), new Roll(10), new Roll(10)));
    }

    @Test
    public void shouldBeStrikeToRoll1() {
        assertTrue("Should be Strike", this.frameService.isStrike(new Roll(this.rolls.get(0).getNumberOfPins())));
    }

    @Test
    public void shouldBeSpareToRoll2() {
        assertTrue("Should be Spare", this.frameService.isSpare(1, this.rolls));
    }

    @Test
    public void sumOfStrikeShoudBe20toRol1() {
        assertTrue("Should be 20", this.frameService.getRollValueStrike(0, this.rolls).equals(20));
    }

    @Test
    public void sumOfSpareShoudBe13toRol2() {
        assertTrue("Should be 13", this.frameService.getRollValueSpare(1, this.rolls).equals(13));
    }

    @Test
    public void calculeTheFrame2ToOnePLayer() {
        this.frameService.calcule(this.player1, this.rolls);

        assertTrue("Should be 33", this.frameService.getGameData().get(this.player1).get(1).getTotal().equals(33));
    }
}
