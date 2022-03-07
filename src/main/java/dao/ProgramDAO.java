package dao;

import model.Program;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class ProgramDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    /**
     * Get all Charity program from Database
     * */
    public List<Program> getProgramList() {
        String SQL = "select * from Programs";
        return jdbcTemplate.query(SQL, new ProgramMapper());
    }
    public List<Program> getSortedProgramList() {
        String SQL = "select * from Programs order by program_endtime";
        return jdbcTemplate.query(SQL, new ProgramMapper());
    }
    public List<Program> getActiveProgram() {
        String SQL = "select * from Programs where program_status = 1 order by program_endtime";
        return jdbcTemplate.query(SQL, new ProgramMapper());
    }
    public List<Program> getInActiveProgram() {
        String SQL = "select * from Programs where program_status = 0";
        return jdbcTemplate.query(SQL, new ProgramMapper());
    }
    public int count() {
        String SQL = "select count(*) from Programs";
        int count = jdbcTemplate.queryForObject(SQL, Integer.class);
        return count;
    }

    /**
     * Get how many pages can display
     * */
    public int getPage() {
        int allPrograms = count();
        int n = allPrograms/10;
        int r = allPrograms%10;
        if(r == 0) {
            return n;
        } else {
            return n+1;
        }

    }
    /**
     *
     * */
    public List<Program> getProgramList(int first, int last) {
        List<Program> programList = getProgramList();
        List<Program> programList1 = new ArrayList<>();
        for(int i = first; i <= last; i++) {
            programList1.add(programList.get(i));
        }
        return programList1;
    }
    public List<Program> getSortedProgramList(int first, int last) {
        List<Program> programList = getSortedProgramList();
        List<Program> programList1 = new ArrayList<>();
        for(int i = first; i <= last; i++) {
            programList1.add(programList.get(i));
        }
        return programList1;
    }

    public List<Program> getActiveProgramList(int first, int last) {
        List<Program> programList = getActiveProgram();
        List<Program> programList1 = new ArrayList<>();
        for(int i = first; i <= last; i++) {
            programList1.add(programList.get(i));
        }
        return programList1;
    }

    public List<Program> getInActiveProgramList(int first, int last) {
        List<Program> programList = getInActiveProgram();
        List<Program> programList1 = new ArrayList<>();
        for(int i = first; i <= last; i++) {
            programList1.add(programList.get(i));
        }
        return programList1;
    }
    /**
     * Insert new Charity program to Database
     * */
    public void create (String name, String des, String detail, String foundation, String src, float target, Date end) {
        String SQL = "insert into Programs(program_name,program_des,program_detail,program_foundation,program_imgsrc,program_target,program_endtime) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(SQL, name, des,detail,foundation,src,target,end);
    }

    /**
     * Delete a Charity program from Database by ID
     * */
    public void delete (int id) {
        String SQL = "delete from Programs where program_id = ?";
        jdbcTemplate.update(SQL, id);
    }
    /**
     * Get a Program by ID
     * */
    public Program getProgram(int id) {
        String SQL = "select * from Programs where program_id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new ProgramMapper());
    }
    /**
     * Update a record
     * */
    public void update(int id, String name, String des, String detail, String foundation, String src, float target, Date end) {
        String SQL = "update Programs set program_name=?, program_des=?, program_detail=?, program_foundation=?, program_imgsrc=?, program_target=?, program_endtime=? where program_id = ?";
        jdbcTemplate.update(SQL, name, des, detail, foundation, src, target, end, id);
    }
    /**
     * Search
     * */
    public List<Program> search(String characters) {
        List<Program> programList = getProgramList();
        List<Program> returnList = new ArrayList<>();
        for(Program program : programList) {
            if(program.getName().trim().toLowerCase().contains(characters.toLowerCase())) {
                returnList.add(program);
            }
        }
        return returnList;
    }
    public void disable(int id) {
        String SQL = "update Programs set program_status = 0 where program_id = ?";
        jdbcTemplate.update(SQL,id);
    }
    public void enable(int id) {
        String SQL = "update Programs set program_status = 1 where program_id = ?";
        jdbcTemplate.update(SQL, id);
    }
}
