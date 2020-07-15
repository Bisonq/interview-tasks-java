package eu.codeloop.task4;

import java.util.List;

public class Car extends Vehicle {

    private Engine engine;
    private List<Wheel> wheels;
    private boolean functional;

    public Car() {
        this.functional = false;
    }

    public Car(Engine engine) {
        this.engine = engine;
        this.functional = false;
    }

    public Car(List<Wheel> wheels) {
        this.wheels = wheels;
        this.functional = false;
    }

    public Car(Engine engine, List<Wheel> wheels) {
        this.engine = engine;
        this.wheels = wheels;
        this.functional = true;
    }

    public Car(Person owner) {
        super(owner);
        this.functional = false;
    }

    public Car(Person owner, Engine engine) {
        super(owner);
        this.engine = engine;
        this.functional = false;
    }

    public Car(Person owner, List<Wheel> wheels) {
        super(owner);
        this.wheels = wheels;
        this.functional = false;
    }

    public Car(Person owner, Engine engine, List<Wheel> wheels) {
        super(owner);
        this.engine = engine;
        this.wheels = wheels;
        this.functional = true;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
        if (engine != null && this.wheels != null)
            this.functional = true;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
        if (wheels != null && this.engine != null)
            this.functional = true;
    }

    @Override
    public void go() {
        if (this.functional) {
            System.out.println("The car is driving!");
            this.functional = false;
        } else
            System.out.println("The car is broken!");
    }

    @Override
    public void fix() {
        if (this.engine != null && this.wheels != null)
            this.functional = true;
    }
}
