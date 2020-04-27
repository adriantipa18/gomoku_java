package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * A class that deals with the server connection
 * sending a request to server, receiving a response and printing it.
 */

public class GameClient {

    /**
     * @serverAddress IP address of the server (we're using local IP address)
     * @PORT the server port, which we'll use te set the connection
     *          serverAddress and PORT are transmitted as parameters
     * @response the response from the server
     * @request the request sent to the server
     * @readRequest used to read the request of the client
     * @throws IOException
     *          a new socket is created ( the channel used to communicate to the server )
     *          then the input/output channels are set
     *          and the client and server communicate until the client stops the server
     *          by sending the "stop" request or the client exits using "exit" request
     */

    GameClient(String serverAddress,int PORT) throws IOException {

        String request="undefined",response="undefined";
        Scanner readRequest = new Scanner(System.in);

        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream())) ) {
            while(!response.equals("Server stopped") && !request.equals("exit")) {
                System.out.print("Introduceti o comanda: ");
                request = readRequest.nextLine();

                out.println(request);
                response = in.readLine();
                System.out.println(response);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}