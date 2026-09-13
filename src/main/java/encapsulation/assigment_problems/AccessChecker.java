package encapsulation.assigment_problems;

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

    public static String summarizeByModifier(String[][] attempts) {
        int privateAllowed = 0, privateDenied = 0;
        int defaultAllowed = 0, defaultDenied = 0;
        int protectedAllowed = 0, protectedDenied = 0;
        int publicAllowed = 0, publicDenied = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String mod = attempt[0].trim().toLowerCase();
                    String res = classifyAccess(attempt[0], attempt[1]);
                    boolean isAllowed = "ALLOWED".equals(res);

                    switch (mod) {
                        case "private":
                            if (isAllowed) privateAllowed++; else privateDenied++;
                            break;
                        case "default":
                            if (isAllowed) defaultAllowed++; else defaultDenied++;
                            break;
                        case "protected":
                            if (isAllowed) protectedAllowed++; else protectedDenied++;
                            break;
                        case "public":
                            if (isAllowed) publicAllowed++; else publicDenied++;
                            break;
                    }
                }
            }
        }

        return "private: " + privateAllowed + " allowed / " + privateDenied + " denied | " +
               "default: " + defaultAllowed + " allowed / " + defaultDenied + " denied | " +
               "protected: " + protectedAllowed + " allowed / " + protectedDenied + " denied | " +
               "public: " + publicAllowed + " allowed / " + publicDenied + " denied";
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        if (attempts != null) {
            for (int i = 0; i < attempts.length; i++) {
                String[] attempt = attempts[i];
                if (attempt != null && attempt.length >= 2) {
                    String mod = attempt[0].trim();
                    String ctx = attempt[1].trim();
                    String res = classifyAccess(mod, ctx);
                    if ("DENIED".equals(res)) {
                        return mod.toLowerCase() + " via " + ctx + " (attempt #" + (i + 1) + ")";
                    }
                }
            }
        }
        return "None Denied";
    }
}