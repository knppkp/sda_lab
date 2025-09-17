package Task1;

public class Printer {
    public Printer() {}

    public void print_line(int x1, int y1, int x2, int y2) {
        System.out.println(String.format("Print a line from (%d, %d) to (%d, %d)", x1, y1, x2, y2));
    }

    public void print_pixel(int x, int y) {
        System.out.println(String.format("Print a pixel at (%d, %d)", x, y));
    }

    public void print_circle(int x, int y, int r) {
        System.out.println(String.format("Print a circle at (%d, %d) with radius %d", x, y, r));
    }

}
