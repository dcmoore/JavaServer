package com.richardcheng.javaserver;

import java.net.*;
import java.io.*;

/**
 * Created by richardcheng on 7/18/16.
 */
public class SocketService implements ISocketService {
    private ServerSocket serverSocket;
    private Socket connectionSocket;

    public void create(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void accept() {
        try {
            connectionSocket = serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close()
    {
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String read() {
        try {
            BufferedReader requestMessage = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            return requestMessage.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String message) {
        try {
            DataOutputStream response = new DataOutputStream(connectionSocket.getOutputStream());
            response.writeBytes(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
