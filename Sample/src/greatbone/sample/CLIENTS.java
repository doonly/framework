package greatbone.sample;

import greatbone.framework.grid.GridRecordCache;
import greatbone.framework.grid.GridUtility;
import greatbone.framework.grid.Storage;

/**
 * All client participants of the business operation that can be either a customer or a delivery person.
 */

@Storage
public class CLIENTS extends GridRecordCache<Shop> {

    public CLIENTS(GridUtility grid) {
        super(grid, 12);
    }

}
