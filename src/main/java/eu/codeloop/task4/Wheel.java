package eu.codeloop.task4;

public class Wheel extends Part{

    private final double diameter;

    public Wheel(double diameter, String brand) {
        super(brand);
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "diameter=" + diameter +
                '}';
    }
}
