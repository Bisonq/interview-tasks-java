package eu.codeloop.task4;

public abstract class Vehicle implements Runnable, Fixable {

    private Person owner;

    public Vehicle(Person owner) {
        this.owner = owner;
    }

    public Vehicle() {

    }

    public final Person getOwner() {
        return owner;
    }

    public final void setOwner(Person owner) {
        this.owner = owner;
    }

    public final boolean hasOwner() {
        return owner != null;
    }
}