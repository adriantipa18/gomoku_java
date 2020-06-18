# laboratorul10_java
The application contains a pretty basic TCP Server Application and a Client Application.
Those two communicate throw a socket and based on request and responses.

The ServerApplication contains 3 classes:

The Main class that just instantiate a server.

The GameServer class that created the server at a specified PORT and deals with accepting the clients, creating a thread for each client and closing the connection after.

And the ClientThread that created the effective thread that constant communicates with the client until it meets the "exit" or "stop" request.

The ClientApplication contains only 2 classes:

The Main class that just instantiate a client at a specified port, and an specified IP address. 

And the GameClient that creates the connection, creates the socket throw which the communication is sustained.

More details in the applications.  
