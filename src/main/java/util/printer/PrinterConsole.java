package util.printer;

public class PrinterConsole implements Printer {
    @Override
    public void print(String value) {
        System.out.println(value);
    }
}
