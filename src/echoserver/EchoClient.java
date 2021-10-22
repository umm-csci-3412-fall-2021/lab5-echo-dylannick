package echoserver;
import java.net.*;
import java.io.*;


class EchoClient{
    public static void main(String[] args){
        try {
            String hostName;

            if (args.length == 0) {
                hostName = "127.0.0.1";
            } else {
                hostName = args[0];
            }

            InputStream consoleInput = System.in;
            OutputStream serverOutput = System.out;

            Socket socket = new Socket(hostName, 6013);//connect to ServerSocket

            InputStream fromServer = socket.getInputStream();
            OutputStream toServer = socket.getOutputStream();


            int b = 0;
            while(true) {
                b = consoleInput.read();
                if(b == -1) {
                    toServer.flush();
                    socket.shutdownOutput();
                    socket.close();
                }
                toServer.write(b);
                serverOutput.write(fromServer.read());
            }


        } catch(Exception e){
            System.out.println(e);
         }
    }
}