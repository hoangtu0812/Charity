package dao;

import model.Program;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramMapper implements RowMapper<Program> {
    public Program mapRow(ResultSet rs, int rowNum) throws SQLException {
        Program program = new Program();
        program.setId(rs.getInt("program_id"));
        program.setName(rs.getString("program_name"));
        program.setDes(rs.getString("program_des"));
        program.setDetail(rs.getString("program_detail"));
        program.setFoundation(rs.getString("program_foundation"));
        program.setSrc(rs.getString("program_imgsrc"));
        program.setTarget(rs.getInt("program_target"));
        program.setEnd(rs.getDate("program_endtime"));
        program.setCurrent(rs.getInt("program_current"));
        program.setStatus(rs.getInt("program_status"));
        return program;
    }
}
