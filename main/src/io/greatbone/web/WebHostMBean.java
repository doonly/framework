package io.greatbone.web;

import java.io.IOException;

/**
 */
public interface WebHostMBean {

    void start() throws IOException;

    void stop() throws IOException;

}
