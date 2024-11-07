package exp1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000);
             Socket clientSocket = serverSocket.accept();
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
                        System.out.println("Client: " + msg);
                    }
                    System.out.println("Client disconnected");
                } catch (IOException e) {
                    System.out.println("Error reading from client: " + e.getMessage());
                }
            });
            receiver.start();

            // Wait for sender to finish
            sender.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
