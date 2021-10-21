package echoserver;
import java.net.*;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

class EchoClient{
    public static void main(String[] args){
        try {
            InputStream consoleInput = System.in;
            OutputStream serverOutput = System.out;

            Socket socket = new Socket("localhost", 3502);//connect to ServerSocket

            InputStream fromServer = consoleInput;
            OutputStream toServer = socket.getOutputStream();

            byte[] bytes = new byte[16 * 1024];

            int count;
            while ((count = fromServer.read(bytes)) > 0) {
                serverOutput.write(bytes, 0, count);
            }


        } catch(Exception e){
            System.out.println(e);
         }
    }
}