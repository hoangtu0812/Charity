package dao;

import model.DonationCOM;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DonationMapper implements RowMapper<DonationCOM> {
    public DonationCOM mapRow(ResultSet rs, int rowNum) throws SQLException {
        DonationCOM donationCOM = new DonationCOM();
        donationCOM.setId(rs.getInt("donation_id"));
        donationCOM.setUserMail(rs.getString("user_mail"));
        donationCOM.setUserName(rs.getString("user_name"));
        donationCOM.setUserPhone(rs.getString("user_phone"));
        donationCOM.setDate(rs.getDate("donation_date"));
        donationCOM.setProgramID(rs.getInt("program_id"));
        donationCOM.setAmount(rs.getInt("donation_amount"));
        donationCOM.setProgramName(rs.getString("program_name"));
        donationCOM.setTcode(rs.getString("t_code"));
        return donationCOM;
    }
}
