package eu.codeloop.task4;

import java.util.List;

public class Boat extends Vehicle {

    private List<Engine> engines;
    private boolean functional;

    public Boat() {
        this.functional = false;
    }

    public Boat(List<Engine> engines) {
        this.engines = engines;
        this.functional = true;
    }

    public Boat(Person owner) {
        super(owner);
        this.functional = false;
    }

    public Boat(Person owner, List<Engine> engines) {
        super(owner);
        this.engines = engines;
        this.functional = true;
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public void setEngines(List<Engine> engines) {
        this.engines = engines;
        if (engines != null)
            this.functional = true;
    }

    @Override
    public void go() {
        if (this.functional) {
            System.out.println("The boat is flowing!");
            this.functional = false;
        } else
            System.out.println("The boat is broken!");
    }

    @Override
    public void fix() {
        if (this.engines != null)
            this.functional = true;
    }
}
