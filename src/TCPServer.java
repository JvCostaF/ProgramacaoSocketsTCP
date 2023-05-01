import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class TCPServer {

    public static void main(String[] args) throws IOException {

        String portgueseWord;
        String capitalizedSentence;

        ServerSocket serverSocket = new ServerSocket(4000);
        Map<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("HOSPEDEIRO", "HOST");
        dictionary.put("PORTA", "PORT");
        dictionary.put("PROTOCOLO", "PROTOCOL");
        dictionary.put("REQUISIÇÃO", "REQUEST");
        dictionary.put("RESPOSTA", "RESPONSE");
        dictionary.put("CABEÇALHO", "HEADER");
        dictionary.put("CORPO", "BODY");
        dictionary.put("CONEXÃO", "CONNECTION");
        dictionary.put("NAVEGADOR", "BROWSER");
        dictionary.put("SERVIDOR", "SERVER");
        dictionary.put("CLIENTE", "CLIENT");

        while (true) {
            Socket connectionSocket = serverSocket.accept();

            System.out.println("Servidor ouvindo!");

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            portgueseWord = inFromClient.readLine();

            capitalizedSentence = portgueseWord.toUpperCase();

            if(dictionary.containsKey(capitalizedSentence)) {
                String englishWord = dictionary.get(capitalizedSentence);
                outToClient.writeBytes(englishWord+"\n");
            } else {
                outToClient.writeBytes("Palavra não encontrada");
                System.out.println("Palavra não encontrada");
            }
        }
    }
}