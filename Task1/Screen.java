package Task1;

public class Screen {
    public Screen() {}

    public void draw_line(int x1, int y1, int x2, int y2) {
        System.out.println(String.format("Display a line from (%d, %d) to (%d, %d)", x1, y1, x2, y2));
    }

    public void draw_pixel(int x, int y) {
        System.out.println(String.format("Display a pixel at (%d, %d)", x, y));
    }

    public void draw_circle(int x, int y, int r) {
        System.out.println(String.format("Display a circle at (%d, %d) with radius %d", x, y, r));
    }

}