import java.io.*;
import java.net.*;
public class TCPServer {

    public static void main(String[] args) throws IOException {

        String clientSentence;
        String capitalizedSentence;

        ServerSocket serverSocket = new ServerSocket(4000);

        while (true) {
            Socket connectionSocket = serverSocket.accept();

            System.out.println("Servidor ouvindo!");

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            clientSentence = inFromClient.readLine();

            capitalizedSentence = clientSentence.toUpperCase() + '\n';

            outToClient.writeBytes(capitalizedSentence);
        }
    }
}