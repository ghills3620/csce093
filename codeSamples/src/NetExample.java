import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NetExample
{

    public NetExample() // method
    {   }
        private ServerSocket listener = null; // 'listener' aka Serversocket for a client on a port
        private BufferedReader input_from_client = null;
        public void waitForClient () throws IOException // throws excpetion because it could fail
        {
            this.listener = new ServerSocket(10000); // say what port our listener should pay attnetion to
            Socket clientSocket = this.listener.accept();

           this.input_from_client = new BufferedReader( new InputStreamReader( clientSocket.getInputStream()));
            System.out.println("A client has connected...");


        }

        public void echoClientInput () throws IOException
        {
            String s;

            s = this.input_from_client.readLine();
            System.out.println("Client says:" + s);
        }


        public static void main (String[]args )
        {
            System.out.println("This is our echo server.../n");

            try {
                NetExample echoServer = new NetExample();
                echoServer.waitForClient();   // wrote this first because this is how we want the server to behave
                echoServer.echoClientInput(); // wrote this first because this is how we want the server to behave
            } catch (Exception e) {
                System.out.println("Exception:" + e.toString());
            }
        }
}