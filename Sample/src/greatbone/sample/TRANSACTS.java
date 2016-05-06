package greatbone.sample;

import greatbone.framework.grid.Copy;
import greatbone.framework.grid.GridDataSet;
import greatbone.framework.grid.GridUtility;
import greatbone.framework.grid.Table;

/**
 */
@Table
@Copy
public class TRANSACTS extends GridDataSet<Transact> {

    public TRANSACTS(GridUtility grid) {
        super(grid, 12);
    }

}
