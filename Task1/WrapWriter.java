package Task1;

public class WrapWriter extends DrawingService {
    private Writer writer;
    
    public WrapWriter() {
        this.writer = new Writer();
    }

    @Override
    public void draw_line(int x1, int y1, int x2, int y2) {
        writer.write_line(x1, y1, x2, y2);
    }

    @Override
    public void draw_pixel(int x, int y) {
        writer.write_pixel(x, y);
    }

    @Override
    public void draw_circle(int x, int y, int r) {
        writer.write_circle(x, y, r);
    }
}
