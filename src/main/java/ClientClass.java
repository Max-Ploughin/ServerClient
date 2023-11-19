import java.io.*;
import java.net.Socket;

public class ClientClass implements Closeable {

    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;

    // Constructor for creating a socket and objects for reading and writing.
    public ClientClass(String ipAddress, int port) {
        try {
            socket = new Socket(ipAddress, port);
            reader = createReader();
            writer = createWriter();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Initializing objects for reading data.
    private BufferedReader createReader() throws IOException {
        return  new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    // Initializing objects for writing data.
    private BufferedWriter createWriter() throws IOException {
        return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    // Method for sending messages to the server and receiving messages from the server.
    public void startWork() {
        try {
            while (true) {
                // Sending messages once per second.
                Thread.sleep(1000);
                String request = "ping";
                writer.write(request);
                System.out.println("Message PING was sent.");
                writer.newLine();
                writer.flush();

                String response = reader.readLine();
                System.out.println("Server response: " + response);
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws IOException {
        writer.close();
        reader.close();
        socket.close();
    }
}
