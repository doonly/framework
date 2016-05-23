package greatbone.framework.grid;

import greatbone.framework.Configurable;
import greatbone.framework.Greatbone;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * A dataset or fileset.
 */
public abstract class GridSet implements Configurable {

    // the container grid instance
    final GridUtility grid;

    // the identifying name of this grid set
    final String name;

    // configurative xml element, can be null when no store on this VM for a registered set
    final Element config;

    // spec for the parts attribute, null when no local attribute is found, empty when the local atrribute is empty
    final List<String> parts;

    GridSet(GridUtility grid) {
        this.grid = grid;

        // derive the key
        Class c = getClass();
        this.name = c.getSimpleName().toLowerCase(); // from class name

        // derive the config tag
        Class p = c;
        String tag = null;
        while ((c = c.getSuperclass()) != GridSet.class) {
            String n = c.getSimpleName().toLowerCase();
            if (n.startsWith("grid") && n.endsWith("set") && n.length() > 8) {
                tag = n.substring(4);
            }
        }
        this.config = Greatbone.getChildElementOf(grid.config, tag, name);

        // parse the local attribute
        List<String> lst = null;
        if (config != null) {
            String attlocal = config.getAttribute("local");
            if (!attlocal.isEmpty()) {
                lst = new ArrayList<>(16);
                StringTokenizer st = new StringTokenizer(attlocal, ",");
                while (st.hasMoreTokens()) {
                    String tok = st.nextToken().trim();
                    if (!tok.isEmpty()) lst.add(tok);
                }
            }
        }
        this.parts = lst;
    }

    abstract void flush();

    @Override
    public Element config() {
        return config;
    }

}
