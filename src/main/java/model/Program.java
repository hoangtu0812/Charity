package model;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;

public class Program {
    private int id;
    private String name;
    private String des;
    private String detail;
    private String foundation;
    private String src;
    private int target;
    private Date end;
    private String moneyString;
    private int current;
    private int status;
    private String moneyStringCurrent;
    private double progress;
    private int sum = 0;



    public String getMoneyStringCurrent() {
        Locale vn = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(vn);
        this.moneyStringCurrent = formatter.format(this.current);
        return moneyStringCurrent;
    }

    public double getProgress() {
        this.progress =(double) this.current/(double) this.target * 100;
        return progress;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMoneyString() {
        Locale vn = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(vn);
        this.moneyString = formatter.format(this.target);
        return moneyString;
    }

    public Program () {}

    public Program(int id, String name, String des, String detail, String foundation, String src, int target, Date end) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.detail = detail;
        this.foundation = foundation;
        this.src = src;
        this.target = target;
        this.end = end;
    }

    public Program(String name, String des, String detail, String foundation, String src, int target, Date end) {
        this.name = name;
        this.des = des;
        this.detail = detail;
        this.foundation = foundation;
        this.src = src;
        this.target = target;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public long getLeft() {
        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());
        LocalDate start = LocalDate.parse(date1.toString());
        LocalDate end = LocalDate.parse(this.end.toString());

        long diff1 = DAYS.between(start, end);
        return diff1;
    }
}
