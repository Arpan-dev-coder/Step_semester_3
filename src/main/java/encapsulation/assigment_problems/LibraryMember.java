package encapsulation.assigment_problems;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LibraryMember {
    // Access modifier demonstration fields from Problem 1
    private int membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;

    // JavaBean fields from Problem 4
    private String membershipId = null;
    private String name;
    private boolean premiumMember;
    @SuppressWarnings("unused")
    private String securityAnswerHash;

    public LibraryMember() {
    }

    public LibraryMember(int membershipPin, String branchCode, double finesOwed, String displayName) {
        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }

    public int getMembershipPin() {
        return membershipPin;
    }

    // Write-once setter for membershipId
    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (this.membershipId == null) {
            this.membershipId = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    // Write-only securityAnswer with deterministic one-way transformation
    public void setSecurityAnswer(String answer) {
        if (answer == null) {
            this.securityAnswerHash = null;
            return;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(answer.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            this.securityAnswerHash = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            this.securityAnswerHash = String.valueOf(answer.hashCode());
        }
    }
}