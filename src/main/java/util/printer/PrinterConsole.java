package util.printer;

public class PrinterConsole implements Printer {

    /**
     * Print the result of the gome on the console
     * @param value The result of the game
     */
    @Override
    public void print(String value) {
        System.out.println(value);
    }
}
