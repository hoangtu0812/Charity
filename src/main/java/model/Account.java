package model;

public class Account {
    private String userMail;
    private String password;
    private String userName;
    private int role;
    private String address;
    private String phoneNumber;

    public  Account() {

    }

    public Account(String userMail, String password, String userName, int role, String address, String phoneNumber) {
        this.userMail = userMail;
        this.password = password;
        this.userName = userName;
        this.role = role;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public int getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
