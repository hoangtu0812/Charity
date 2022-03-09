package model;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;

public class DonationCOM {
    private int id;
    private String userMail;
    private String userName;
    private String userPhone;
    private Date date;
    private int programID;
    private int amount;
    private String programName;
    private String amountVND;

    public String getAmountVND() {
        Locale vn = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(vn);
        this.amountVND = formatter.format(this.amount);
        return amountVND;
    }

    public DonationCOM() {

    }
    public DonationCOM(int id, String userMail, String userName, String userPhone, Date date, int programID, int amount, String programName) {
        this.id = id;
        this.userMail = userMail;
        this.userName = userName;
        this.userPhone = userPhone;
        this.date = date;
        this.programID = programID;
        this.amount = amount;
        this.programName = programName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
