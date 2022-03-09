package dao;


import javax.sql.DataSource;

import model.Account;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

@Repository
public class AccountDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private String message;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int count() {
        String SQL = "select count(*) from Account";
        return jdbcTemplate.queryForObject(SQL, Integer.class);
    }

    /**
     * Get all Account from Database
     */
    public List<Account> getAccountList() {
        String SQL = "select * from Account";
        return jdbcTemplate.query(SQL, new AccountMapper());
    }

    /**
     * Update an exist record
     */
    public void update(String userMail, String userName, int role, String address, String phone) {
        String SQL = "update Account set user_name = ?, account_roles = ?, user_address = ?, user_phone = ? where user_mail = ? ";
        jdbcTemplate.update(SQL, userName, role, address, phone, userMail);
    }

    /**
     * Delele an Account from Database
     */
    public void delete(String userMail) {

        String SQL = "delete from Account where user_mail = ?";
        jdbcTemplate.update(SQL, userMail);

    }

    public int countEmail(String email) {
        String SQL = "select count (*) from Account where user_mail = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{email}, Integer.class);
    }

    public int role(String email) {
        String SQL = "select account_roles from Account where user_mail = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{email}, Integer.class);
    }

    /**
     * Insert an Account to database
     */
    public void create(String userMail, String password, String userName, int role, String address, String phone) {
        String hashPassword = hashPassword(password);
        String SQL = "insert into Account(user_mail,user_password,user_name,account_roles,user_address,user_phone) values(?,?,?,?,?,?)";
        jdbcTemplate.update(SQL, userMail, hashPassword, userName, role, address, phone);
    }

    /**
     * Get how many pages can display
     * 10 account / page
     */
    public int getPage() {
        int allAccount = count();
        int n = allAccount / 10;
        int r = allAccount % 10;
        if (r == 0) {
            return n;
        } else {
            return n + 1;
        }
    }

    /**
     * Get list account by index
     */
    public List<Account> getAccountList(int first, int last) {
        List<Account> accountList = getAccountList();
        List<Account> accountList1 = new ArrayList<>();
        for (int i = first; i <= last; i++) {
            accountList1.add(accountList.get(i));
        }
        return accountList1;
    }

    public Account getAccount(String email) {
        String SQL = "SELECT * FROM Account WHERE user_mail = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{email}, new AccountMapper());
    }

    public boolean exist(String email) {
        String SQL = "SELECT COUNT(*) FROM Account WHERE user_mail = ?";
        int count = jdbcTemplate.queryForObject(SQL, new Object[]{email}, Integer.class);
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validate(String email, String password) {
        if (email == null) {
            this.message = "No email address set!";
            return false;
        } else if (!email.matches(".+@.+\\.[a-z]+")) {
            this.message = "Địa chỉ email không hợp lệ!";
            return false;
        } else if (password == null) {
            this.message = "No password set!";
            return false;
        } else if (password.length() < 8) {
            this.message = "Mật khẩu phải có ít nhất 8 ký tự!";
            return false;
        } else {
            return true;
        }
    }

    public String getMessage() {
        return message;
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            String hashText = no.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(String email, String password) {
        String hashPassword = hashPassword(password);
        String SQL = "select count (*) from Account where user_mail=? and user_password=?";
        int count = jdbcTemplate.queryForObject(SQL, new Object[]{email, hashPassword}, Integer.class);
        if(count == 0) {
            this.message = "Email hoặc mật khẩu không chính xác!";
            return false;
        } else {
            return true;
        }
    }

    public String newPassword(String email) {
        String randomPassword = RandomStringUtils.randomAlphanumeric(10);

        String SQL = "update Account set user_password = ? where user_mail = ?";
        jdbcTemplate.update(SQL, hashPassword(randomPassword), email);
        return randomPassword;

    }
    public void changePassword(String email, String password) {
        String SQL = "update Account set user_password = ? where user_mail = ?";
        jdbcTemplate.update(SQL, hashPassword(password), email);
    }
}
