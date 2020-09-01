import domain.service.FrameService;
import org.junit.Before;
import org.junit.Test;
import util.reader.Read;
import util.reader.ReadFile;

import static org.junit.Assert.assertTrue;

public class ZeroScoreTest {

    private static final String PATH = "zero_score_exemple.txt";
    private FrameService frameService;

    @Before
    public void setup() {
        String path = BowlingGame.class.getResource(PATH).getPath();
        Read read = new ReadFile();
        this.frameService = new FrameService(read, path);
    }

    @Test
    public void theResulToCarlIs0() {
        this.frameService.start();

        assertTrue("The total value of the game is wrong", this.frameService.getGameData().get("Carl").get(9).getTotal() .equals(0));
    }

}
