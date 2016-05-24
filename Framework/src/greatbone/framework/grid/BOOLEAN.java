package greatbone.framework.grid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 */
public class BOOLEAN extends GridColumn<Boolean> {

    @Override
    public int size() {
        return 1;
    }

    @Override
    String dbtype() {
        return "BOOLEAN";
    }

    public int tryValue(GridRecord dat, boolean v) {
        return -1;
    }

    public boolean getValue(GridRecord dat) {
        return false;
    }

    public void putValue(GridRecord dat, boolean v) {
//        dat.putShort(offset, v);
    }


    @Override
    void load(GridRecord dat, ResultSet rs) throws SQLException {
        putValue(dat, rs.getBoolean(ordinal));
    }

    @Override
    void param(GridRecord dat, PreparedStatement pstmt) throws SQLException {
        pstmt.setBoolean(ordinal, getValue(dat));
    }

}
