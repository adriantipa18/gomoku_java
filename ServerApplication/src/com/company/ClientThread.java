package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * a class that creates a thread for a specific client
 * using the socket received when instantiated
 */

public class ClientThread extends Thread {

    /**
     * @socket the channel used or communication
     * @response a string used to store the response
     * @request a string used to store the request
     *      for compulsory only two commands are relevant
     *      when exit is requested the " la revedere !" response is sent and the connection is ended
     *      when "stop" is requested, the server shuts down and all connection are closed.
     */

    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            String response="undefined";
            while(true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                if (request.equals("stop")) {
                    response = "Server stopped";
                    out.println(response);
                    out.flush();
                    System.exit(0);
                } else
                    if(request.equals("exit")){
                        out.println("La revedere !");
                        out.flush();
                        break;
                    }else
                    {
                    response = "Server received the request --> " + request + "!";
                }
                out.println(response);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println (e); }
        }
    }
}
