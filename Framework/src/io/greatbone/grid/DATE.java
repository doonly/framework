package io.greatbone.grid;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 */
public class DATE extends GridColumn<Date> {

    @Override
    int size() {
        return 8;
    }

    @Override
    String dbtype() {
        return "DATE";
    }

    @Override
    void load(GridData dat, ResultSet rs) throws SQLException {

    }

    @Override
    void param(GridData dat, PreparedStatement pstmt) throws SQLException {

    }

}
