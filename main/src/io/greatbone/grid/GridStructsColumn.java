package io.greatbone.grid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A column that contains an array of structs.
 */
class GridStructsColumn extends GridColumn {

    final STRUCT[] structs;

    int size;

    GridStructsColumn(STRUCT[] structs) {
        this.structs = structs;
    }

    @Override
    int size() {
        return 0;
    }

    @Override
    String dbtype() {
        return "JSONB";
    }

    @Override
    void load(GridData dat, ResultSet rs) throws SQLException {

    }

    @Override
    void param(GridData dat, PreparedStatement pstmt) throws SQLException {

    }

}
