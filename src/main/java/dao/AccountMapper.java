package dao;

import model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setUserMail(rs.getString("user_mail"));
        account.setPassword(rs.getString("user_password"));
        account.setUserName(rs.getString("user_name"));
        account.setRole(rs.getInt("account_roles"));
        account.setAddress(rs.getString("user_address"));
        account.setPhoneNumber(rs.getString("user_phone"));
        return account;
    }
}
