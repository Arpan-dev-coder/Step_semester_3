package abstraction.assigment_problems;

public interface Trackable {
    String getLocation();

    static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            return ((Trackable) o).getLocation();
        }
        return "Tracking not available";
    }
}