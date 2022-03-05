package model;

public class Donations {
    private int id;
    private String userMail;
    private String userName;
    private String userPhone;
    private String status;

    public Donations(String userMail, String userName, String userPhone) {
        this.userMail = userMail;
        this.userName = userName;
        this.userPhone = userPhone;
    }

    public int getId() {
        return id;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getStatus() {
        return status;
    }
}
