package Task1;

public class WrapScreen extends DrawingService {
    private Screen screen;
    
    public WrapScreen() {
        this.screen = new Screen();
    }

    @Override
    public void draw_line(int x1, int y1, int x2, int y2) {
        screen.draw_line(x1, y1, x2, y2);
    }

    @Override
    public void draw_pixel(int x, int y) {
        screen.draw_pixel(x, y);
    }

    @Override
    public void draw_circle(int x, int y, int r) {
        screen.draw_circle(x, y, r);
    }
}
