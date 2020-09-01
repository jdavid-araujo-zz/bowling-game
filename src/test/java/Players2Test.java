import domain.service.FrameService;
import org.junit.Before;
import org.junit.Test;
import util.reader.Read;
import util.reader.ReadFile;

import static org.junit.Assert.assertTrue;

public class Players2Test {

    private static final String PATH = "2_players_exemple.txt";
    private FrameService frameService;

    @Before
    public void setup() {
        String path = BowlingGame.class.getResource(PATH).getPath();
        Read read = new ReadFile();
        this.frameService = new FrameService(read, path);
    }

    @Test
    public void theResulToJeffIs167() {
        this.frameService.start();

        assertTrue("The total value of the game is wrong", this.frameService.getGameData().get("Jeff").get(9).getTotal() .equals(167));
    }

    @Test
    public void theResulToJohnIs151() {
        this.frameService.start();

        assertTrue("The total value of the game is wrong", this.frameService.getGameData().get("John").get(9).getTotal() .equals(151));
    }

}
