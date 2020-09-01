import domain.service.FrameService;
import util.reader.Read;
import util.reader.ReadFile;

public class BowlingGame {

    public static void main(String[] args) {

      String path =  BowlingGame.class.getResource("2_players_exemple.txt").getPath();
        Read read = new ReadFile();
        FrameService frameService = new FrameService(read, path);
        frameService.start();
    }
}
