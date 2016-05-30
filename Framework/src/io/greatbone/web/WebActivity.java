package io.greatbone.web;

import io.greatbone.util.Roll;
import io.netty.handler.codec.http.HttpMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * A set of actions working on request/response eachanges to carry out management tasks on a collection of resources.
 */
public abstract class WebActivity {

    // the root handler
    protected final WebHost vhost;

    // the parent of this work instance, if any
    protected final WebActivity parent;

    // the key by which this control is added to a parent
    String key;

    final Roll<String, Action> actions = new Roll<>(32);

    // access checker
    Authorizer authorizer;

    // execution of background tasks
    Thread cycler;

    protected WebActivity(WebHost vhost, WebActivity parent) {
        this.vhost = (vhost != null) ? vhost : (WebHost) this;
        this.parent = parent;

        // initialize web methods
        for (Method m : getClass().getMethods()) {
            int mod = m.getModifiers();
            // public non-static void
            if (Modifier.isPublic(mod) && !Modifier.isStatic(mod)) {
                Class<?>[] pts = m.getParameterTypes();
                // with the two parameters
                if (pts.length == 1 && WebContext.class == pts[0]) {
                    String key = m.getName().toLowerCase();
                    if ("$".equals(key)) {
                        key = "";
                    }
                    actions.put(key, new Action(this, m));
                }
            }
        }

        // initialize the cycler thread if any
        if (this instanceof Runnable) {
            cycler = new Thread((Runnable) this);
            cycler.start();
        }
    }

    public String key() {
        return key;
    }

    /**
     * To handle a request/response exchange by this or by an appropriate sub controller.
     *
     * @param base the relative URI that this controller is based
     * @param exch the request.response exchange
     */
    protected void perform(String base, WebContext exch) throws Exception {
        int slash = base.indexOf('/');
        if (slash == -1) { // without a slash then handle by this controller instance
            exch.control = this;
            HttpMethod method = exch.method();
            if (method == HttpMethod.GET) default_(exch);
//        } else if (subordinates != null) { // resolve the sub structure
//            WebControl control = subordinates.locateSub(base.substring(0, slash), exch);
//            if (control != null) {
//                control.perform(base.substring(slash + 1), exch);
//            } else {
//                exch.sendNotFound();
//            }
        } else {
            exch.sendNotFound();
        }
    }

    public void default_(WebContext wc) throws Exception {
    }

}