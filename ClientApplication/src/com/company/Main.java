package com.company;

import java.io.IOException;

/**
 * Basic main class that deals with instantiating a client application.
 */

public class Main {

/**
 * @serverAddress IP address of the server (we're using local IP address)
 * @PORT the server port, which we'll use te set the connection
 */

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        GameClient client1 = new GameClient(serverAddress,PORT);
    }
}
