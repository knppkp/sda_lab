package Task1;

public class Demo {
    public static void main(String[] args) {
        // Create shapes
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        Shape polygon = new Polygon();

        // Draw shapes using their own draw method
        circle.draw();       // Output: Drawing a Circle
        rectangle.draw();    // Output: Drawing a Rectangle
        polygon.draw();      // Output: Drawing a Polygon

        System.out.println("\n--- Using WrapScreen ---");
        // Use WrapScreen to draw shapes
        DrawingService screenService = new WrapScreen();
        screenService.draw_line(0, 0, 100, 100);
        screenService.draw_pixel(50, 50);
        screenService.draw_circle(75, 75, 20);

        System.out.println("\n--- Using WrapPrinter ---");
        // Use WrapPrinter to draw shapes
        DrawingService printerService = new WrapPrinter();
        printerService.draw_line(10, 10, 200, 200);
        printerService.draw_pixel(100, 100);
        printerService.draw_circle(150, 150, 30);

        System.out.println("\n--- Using WrapWriter ---");
        // Use WrapWriter to draw shapes
        DrawingService writerService = new WrapWriter();
        writerService.draw_line(5, 5, 50, 50);
        writerService.draw_pixel(25, 25);
        writerService.draw_circle(40, 40, 10);
    }
}
