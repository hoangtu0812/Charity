package model;

public class DonationDetail {
    private int donationID;
    private int programID;
    private float amount;

    public DonationDetail(String programID, String amount) {
        //this.donationID = donationID;
        this.programID = Integer.parseInt(programID);
        this.amount = Float.parseFloat(amount);
    }

    public int getDonationID() {
        return donationID;
    }

    public void setDonationID(int donationID) {
        this.donationID = donationID;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
