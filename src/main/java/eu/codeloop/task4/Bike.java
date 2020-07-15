package eu.codeloop.task4;

import java.util.List;

public class Bike extends Vehicle {

    private List<Wheel> wheels;

    private boolean functional;

    public Bike() {
        this.functional = false;
    }

    public Bike(Person owner) {
        super(owner);
        this.functional = false;
    }

    public Bike(List<Wheel> wheels) {
        this.wheels = wheels;
        this.functional = true;
    }

    public Bike(Person owner, List<Wheel> wheels) {
        super(owner);
        this.wheels = wheels;
        this.functional = true;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
        if (wheels != null)
            this.functional = true;
    }

    @Override
    public void go() {
        if (this.functional) {
            System.out.println("The bike is riding!");
            this.functional = false;
        } else
            System.out.println("The bike is broken!");
    }

    @Override
    public void fix() {
        if (this.wheels != null)
            this.functional = true;
    }
}
