package io.greatbone.grid;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * evictable file  cache
 */
class GridFolderRef extends GridFolder {

    String name;

    GridFolderRef(int capacity) {
        super(capacity);
    }


    public GridFile get(String key) throws IOException {
        GridFile info = files.get(key);
        if (info == null) {
            // It's OK to construct a Heavy that ends up not being used
            info = new GridFile(Paths.get(key));
            GridFile other = files.putIfAbsent(key, info);
            if (other != null) {
                info = other;
            }
        }
        return info;
    }

}
