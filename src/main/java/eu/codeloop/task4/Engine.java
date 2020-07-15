package eu.codeloop.task4;

public class Engine extends Part{

    private final int horsepower;

    public Engine(int horsepower, String brand) {
        super(brand);
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "horsepower=" + horsepower +
                '}';
    }
}
