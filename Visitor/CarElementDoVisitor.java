package Visitor;

class CarElementDoVisitor implements CarElementVisitor {

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Kicking " + wheel.getName() + " wheel");
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }

    @Override
    public void visit(Body body) {
        System.out.println("Waxing my body");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Starting my car");
    }
}
