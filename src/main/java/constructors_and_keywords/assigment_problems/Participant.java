package constructors_and_keywords.assigment_problems;

public class Participant {
    public String name;
    public String teamName;
    public boolean registered;

    public Participant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    public Participant(String name) {
        this(name, "Unassigned");
    }

    public void printStatus() {
        System.out.println(name + " | " + teamName + " | Registered: " + registered);
    }

    public String getStatusString() {
        return name + " | " + teamName + " | Registered: " + registered;
    }
}