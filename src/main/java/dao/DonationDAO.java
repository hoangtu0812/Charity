package dao;

import model.DonationCOM;
import model.Program;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Connect with database and get information of Donations
 */
@Repository
public class DonationDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    /**
     * Datasource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Create a new Donations and detail
     *
     * @param userMail  user's email type String
     * @param userName  name of user type String
     * @param userPhone user's phone number type String
     * @param programID id of program type int
     * @param amount    amount of this donation type float
     */
    @Transactional
    public void update(String userMail, String userName, String userPhone, int programID, float amount, String tcode) {
        String SQL = "insert into Donations (user_mail,user_name,user_phone,donation_status) values (?,?,?,?)";
        jdbcTemplate.update(SQL, userMail, userName, userPhone, 1);
        String SQLMAX = "select MAX(donation_id) from Donations";
        int donationID = jdbcTemplate.queryForObject(SQLMAX, Integer.class);
        String SQL1 = "insert into Donation_details (donation_id, program_id, donation_amount, t_code) values (?, ?, ?, ?)";
        jdbcTemplate.update(SQL1, donationID, programID, amount, tcode);
        String SQL2 = "select program_current from Programs where program_id = ?";
        float current = jdbcTemplate.queryForObject(SQL2, new Object[]{programID}, Float.class);
        current = current + amount;
        String SQL3 = "update Programs set program_current = ? where program_id = ?";
        jdbcTemplate.update(SQL3, new Object[]{current, programID});
    }
    /**
     * Get list of all donation
     * */
    public List<DonationCOM> getDonationList() {
        String SQL = "select Donations.donation_id, Donations.user_mail, Donations.user_name, Donations.user_phone, Donations.donation_date, Donation_details.program_id, Donation_details.donation_amount,Donation_details.t_code, Programs.program_name from Donations" +
                " inner join Donation_details on Donations.donation_id = Donation_details.donation_id" +
                " inner join Programs on Donation_details.program_id = Programs.program_id";
        return jdbcTemplate.query(SQL, new DonationMapper());
    }
    /**
     * Get list of donation by email
     * */
    public List<DonationCOM> getDonationByEmail(String email) {
        String SQL = "select Donations.donation_id, Donations.user_mail, Donations.user_name, Donations.user_phone, Donations.donation_date, Donation_details.program_id, Donation_details.donation_amount,Donation_details.t_code, Programs.program_name from Donations" +
                " inner join Donation_details on Donations.donation_id = Donation_details.donation_id" +
                " inner join Programs on Donation_details.program_id = Programs.program_id" + " where user_mail=?";
        return jdbcTemplate.query(SQL, new Object[]{email}, new DonationMapper());
    }
    /**
     * Get list of donation by Program ID
     * */
    public List<DonationCOM> getDonationByProgramID(int id) {
        String SQL = "select Donations.donation_id, Donations.user_mail, Donations.user_name, Donations.user_phone, Donations.donation_date, Donation_details.program_id, Donation_details.donation_amount, Donation_details.t_code, Programs.program_name from Donations" +
                " inner join Donation_details on Donations.donation_id = Donation_details.donation_id" +
                " inner join Programs on Donation_details.program_id = Programs.program_id" + " where Programs.program_id = ?";
        return jdbcTemplate.query(SQL, new Object[]{id}, new DonationMapper());
    }
    /**
     *
     * */
    public int count() {
        String SQL = "select count(*) from Donations" +
                " inner join Donation_details on Donations.donation_id = Donation_details.donation_id" +
                " inner join Programs on Donation_details.program_id = Programs.program_id";
        return jdbcTemplate.queryForObject(SQL, Integer.class);
    }

    public List<DonationCOM> getDonationList(int first, int last) {
        List<DonationCOM> donationCOMS = getDonationList();
        List<DonationCOM> donationCOMS1 = new ArrayList<>();
        for (int i = first; i <= last; i++) {
            donationCOMS1.add(donationCOMS.get(i));
        }
        return donationCOMS1;
    }

    public int getPage() {
        int allDonation = count();
        int n = allDonation / 10;
        int r = allDonation % 10;
        if (r == 0) {
            return n;
        } else {
            return n + 1;
        }

    }

    public List<DonationCOM> getDonationByTCode(String tcode) {
        String SQL = "select Donations.donation_id, Donations.user_mail, Donations.user_name, Donations.user_phone, Donations.donation_date, Donation_details.program_id, Donation_details.donation_amount,Donation_details.t_code, Programs.program_name from Donations" +
                " inner join Donation_details on Donations.donation_id = Donation_details.donation_id" +
                " inner join Programs on Donation_details.program_id = Programs.program_id" + " where t_code= ?";
        return jdbcTemplate.query(SQL, new Object[]{tcode}, new DonationMapper());
    }
}
