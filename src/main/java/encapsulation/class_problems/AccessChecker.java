package encapsulation.class_problems;

public class AccessChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }
        fieldModifier = fieldModifier.trim().toLowerCase();
        accessorContext = accessorContext.trim();

        switch (accessorContext) {
            case "SAME_CLASS":
                return "ALLOWED";

            case "SAME_PACKAGE":
                if (fieldModifier.equals("private")) {
                    return "DENIED";
                }
                return "ALLOWED";

            case "DIFFERENT_PACKAGE":
                if (fieldModifier.equals("public")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE":
                if (fieldModifier.equals("public") || fieldModifier.equals("protected")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE":
                if (fieldModifier.equals("public")) {
                    return "ALLOWED";
                }
                return "DENIED";

            default:
                return "DENIED";
        }
    }

    public static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;
        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String result = classifyAccess(attempt[0], attempt[1]);
                    if ("ALLOWED".equals(result)) {
                        allowed++;
                    } else {
                        denied++;
                    }
                }
            }
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }
}