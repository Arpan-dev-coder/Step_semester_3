package abstraction.assigment_problems;

public interface Ringable {
    String ring();

    static void ringAll(Ringable[] devices) {
        if (devices != null) {
            for (Ringable device : devices) {
                if (device != null) {
                    System.out.println(device.ring());
                }
            }
        }
    }
}