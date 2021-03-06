package com.richardcheng.javaserver;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by richardcheng on 7/14/16.
 */
public class ServerTest {
    @Test
    public void testServerStart() {
        MockSocketService socketService = new MockSocketService();
        MockController controller = new MockController();
        Server subject = new Server(socketService, controller);
        int port = 5000;

        subject.start(port);

        Assert.assertTrue(socketService.socketCreated);
        Assert.assertTrue(socketService.socketAccepted);
    }

    @Test
    public void testServerStop() {
        MockSocketService socketService = new MockSocketService();
        MockController controller = new MockController();
        Server subject = new Server(socketService, controller);

        subject.stop();

        Assert.assertTrue(socketService.socketClosed);
    }

    @Test
    public void testServerRequest() {
        String expectedRequest = "GET / HTTP/1.1";
        MockSocketService socketService = new MockSocketService();
        socketService.request = expectedRequest;
        MockController controller = new MockController();
        Server subject = new Server(socketService, controller);
        String actualRequest;

        actualRequest = subject.request();

        Assert.assertEquals(expectedRequest, actualRequest);
    }

    @Test
    public void testServerResponse() {
        String request = "GET / HTTP/1.1";
        String expectedResponse = "response";
        MockSocketService socketService = new MockSocketService();
        socketService.request = request;
        MockController controller = new MockController();
        Server subject = new Server(socketService, controller);

        subject.request();
        subject.response();

        Assert.assertTrue(socketService.responseSent);
        Assert.assertEquals(expectedResponse, socketService.responseMessage);
    }
}
