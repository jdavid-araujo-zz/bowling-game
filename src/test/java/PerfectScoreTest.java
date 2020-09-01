import domain.service.FrameService;
import org.junit.Before;
import org.junit.Test;
import util.reader.Read;
import util.reader.ReadFile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PerfectScoreTest {
    private static final String PATH = "perfect_score_exemple.txt";
    private FrameService frameService;

    @Before
    public void setup() {
        String path = BowlingGame.class.getResource(PATH).getPath();
        Read read = new ReadFile();
        this.frameService = new FrameService(read, path);
    }

    @Test
    public void theResultIsAPerfectScore() {
        this.frameService.start();

        assertTrue("The total value of the game is wrong", this.frameService.getGameData().get("Carl").get(9).getTotal() .equals(300));
    }

    @Test
    public void theResultOfTheFrame9Is270() {
        this.frameService.start();

        assertTrue("The value of the frame 9 should be 270", this.frameService.getGameData().get("Carl").get(8).getTotal() .equals(270));
    }
}
