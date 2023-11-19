import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {

        // Creating a socket on port 8000.
        try (ServerSocket serverSocket = new ServerSocket(8000)) {

            System.out.println("Server started.");
            while (true) {
                // Waiting for a client to connect.
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Overriding the run() method for multithreaded connection.
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // Initializing objects for reading and writing data.
                        try (BufferedReader reader =
                                     new BufferedReader(
                                             new InputStreamReader(
                                                     socket.getInputStream()));
                             BufferedWriter writer =
                                     new BufferedWriter(
                                             new OutputStreamWriter(
                                                     socket.getOutputStream()));) {
                            while (true) {
                                String request = reader.readLine();
                                String pingMsg = "ping";
                                System.out.println("Message from clinet: " + request);

                                /*If the received message is equal to 'ping', the server responds to the client
                                with the message 'pong'.
                                 */
                                if (request.equals(pingMsg)) {
                                    writer.write("pong");
                                    System.out.println("PONG was sent");
                                    writer.newLine();
                                    writer.flush();
                                }
                            }
                        } catch (IOException e) {
                            // Recording error information in the 'serverErrorsLogs.txt' file.
                            ErrorLogging.logError(e.toString());
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            // Recording error information in the 'serverErrorsLogs.txt' file.
            ErrorLogging.logError(e.toString());
            e.printStackTrace();
        }
    }
}


