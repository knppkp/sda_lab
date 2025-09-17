package Task1;

public class WrapPrinter extends DrawingService {
    private Printer printer;
    
    public WrapPrinter() {
        this.printer = new Printer();
    }

    @Override
    public void draw_line(int x1, int y1, int x2, int y2) {
        printer.print_line(x1, y1, x2, y2);
    }

    @Override
    public void draw_pixel(int x, int y) {
        printer.print_pixel(x, y);
    }

    @Override
    public void draw_circle(int x, int y, int r) {
        printer.print_circle(x, y, r);
    }
}
