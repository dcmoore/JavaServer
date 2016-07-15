package com.richardcheng.javaserver;

import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;

/**
 * Created by richardcheng on 7/14/16.
 */
public class ServerTest {
    @Test
    public void testServerInitWithPort() throws IOException {
        int expectedPort = 5000;

        Server server = new Server(expectedPort);

        Assert.assertEquals(expectedPort, server.getPort());
    }

    @Test
    public void testServerStartStop() throws IOException {
        int port = 5000;

        Server server = new Server(port);
        server.start();
        server.close();

        Assert.assertTrue(true);
    }

    @Test
    public void testServerRead() throws IOException {
        Server server = new Server(5000);

        String reply = server.read();

        Assert.assertNotNull(reply);
    }
}