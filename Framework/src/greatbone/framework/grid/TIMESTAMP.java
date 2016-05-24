package greatbone.framework.grid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 */
public class TIMESTAMP extends GridColumn<Timestamp> {

    @Override
    public int size() {
        return 8;
    }

    @Override
    String dbtype() {
        return "TIMESTAMP";
    }

    @Override
    void load(GridRecord dat, ResultSet rs) throws SQLException {

    }

    @Override
    void param(GridRecord dat, PreparedStatement pstmt) throws SQLException {

    }

}
