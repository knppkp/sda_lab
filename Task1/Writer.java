package Task1;

public class Writer {
    public Writer() {}

    public void write_line(int x1, int y1, int x2, int y2) {
        System.out.println(String.format("Write a line from (%d, %d) to (%d, %d)", x1, y1, x2, y2));
    }

    public void write_pixel(int x, int y) {
        System.out.println(String.format("Write a pixel at (%d, %d)", x, y));
    }

    public void write_circle(int x, int y, int r) {
        System.out.println(String.format("Write a circle at (%d, %d) with radius %d", x, y, r));
    }

}
