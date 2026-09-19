package abstraction.class_problems;

public abstract class Toy {
    private static int counter = 1000;
    protected String name;
    private final String toyId;

    public Toy(String name) {
        this.name = name;
        counter++;
        this.toyId = "TOY-" + counter;
    }

    public String getToyId() {
        return toyId;
    }

    public abstract String makeSound();

    public static void resetCounterForTesting() {
        counter = 1000;
    }
}