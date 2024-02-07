# Client_Server
- This Java program consists of a client-server application using sockets for communication.

# Client (client.java):

- The client establishes a connection with the server using the localhost address and port 4999.
- It reads user input from the console and sends it to the server.
- The client continues sending input until the user types "END".
- The client also listens for responses from the server and prints them to the console.

# Server (server.java):

- The server listens on port 4999 for incoming client connections.
- Upon accepting a connection, it creates a new thread (MultiClientHandler) to handle client requests concurrently.
- The MultiClientHandler thread receives messages from the client, converts them to uppercase, reverses the words and letters, and sends the modified message back to the client.
- The server continues listening for and processing client requests indefinitely.

# MultiClientHandler (MultiClientHandler.java):

- This class represents a thread responsible for handling communication with a single client.
- It receives messages from the client, processes them (converts to uppercase, reverses words and letters), and sends the modified message back to the client.
- Upon receiving the "END" message from the client, it closes the connection and terminates the thread.
- This application demonstrates the use of sockets for establishing communication between a client and server, as well as multithreading to handle multiple client connections simultaneously. It showcases basic networking concepts and concurrent programming techniques in Java.



