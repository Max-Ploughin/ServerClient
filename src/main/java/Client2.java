import java.io.IOException;

public class Client2 {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 8000;
        try (ClientClass client1 = new ClientClass(ip, port)){
            client1.startWork();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
