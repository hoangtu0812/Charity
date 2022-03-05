package dao;

import model.DonationCOM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DonationDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional
    public void update(String userMail, String userName, String userPhone, int programID, int amount) {
        String SQL = "insert into Donations (user_mail,user_name,user_phone,donation_status) values (?,?,?,?)";
        jdbcTemplate.update(SQL, userMail, userName, userPhone, 1);
        String SQLMAX = "select MAX(donation_id) from Donations";
        int donationID = jdbcTemplate.queryForObject(SQLMAX, Integer.class);
        String SQL1 = "insert into Donation_details (donation_id, program_id, donation_amount) values (?, ?, ?)";
        jdbcTemplate.update(SQL1, donationID, programID, amount);
    }

    public List<DonationCOM> getDonationByEmail(String email) {
        String SQL = "select Donations.donation_id, Donations.user_mail, Donations.user_name, Donations.user_phone, Donations.donation_date, Donation_details.program_id, Donation_details.donation_amount, Programs.program_name from Donations" +
                " inner join Donation_details on Donations.donation_id = Donation_details.donation_id" +
                " inner join Programs on Donation_details.program_id = Programs.program_id" + " where user_mail=?";
        return jdbcTemplate.query(SQL, new Object[]{email}, new DonationMapper());
    }
}