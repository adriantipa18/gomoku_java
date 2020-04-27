package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * the class that starts the server at a specified PORT
 */

public class GameServer {

    /**
     * @PORT the specified PORT user to set the connection (used to set the socket)
     * @socket the socket used for the tcp connection
     *          the server waits and accepts clients
     * @ClientThread instantiating a thread that deals with the client requests
     *      after all the needs were satisfied the connection is closed
     */

    public static final int PORT = 8100;
    public GameServer() throws IOException {
        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }
}