package echoserver;
import java.net.*;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

class EchoClient{
    public static void main(String[] args){
        try {
            int b = 0;
            InputStream consoleInput = System.in;
            Socket socket = new Socket("localhost", 3501);//connect to ServerSocket



            while(b != 255) {
                InputStream fromServer = socket.getInputStream();
                OutputStream toServer = socket.getOutputStream();  //generate InputStream from Socket

                b = consoleInput.read();

                toServer.write(b);  // Write what we input into the console directly to the server
                System.out.println(fromServer.read()); // Print the response from the server
            }

            socket.shutdownOutput();

        } catch(Exception e){
            System.out.println(e);
         }
    }
}