package exp1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("127.0.0.1", 5000);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            Scanner sc = new Scanner(System.in);

            // Thread for sending messages
            Thread sender = new Thread(() -> {
                try {
                    while (true) {
                        String msg = sc.nextLine();
                        if (msg.equalsIgnoreCase("exit")) break; // Exit on typing "exit"
                        out.println(msg);
                    }
                } finally {
                    sc.close(); // Close scanner when done
                }
            });
            sender.start();

            // Thread for receiving messages
            Thread receiver = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Server: " + msg);
                    }
                    System.out.println("Server disconnected");
                } catch (IOException e) {
                    System.out.println("Error reading from server: " + e.getMessage());
                }
            });
            receiver.start();

            // Wait for sender to finish
            sender.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
