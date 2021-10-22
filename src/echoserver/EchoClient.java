package echoserver;
import java.net.*;
import java.io.*;


class EchoClient{
    public static void main(String[] args){
        String hostName;
        byte[] buffer = new byte[4096];
        int bytesRead;

        if (args.length == 0) {
            hostName = "127.0.0.1";
        } else {
            hostName = args[0];
        }

        try {
            Socket socket = new Socket(hostName, 6013);

            InputStream fromServer = socket.getInputStream();
            OutputStream toServer = socket.getOutputStream();

            while ((bytesRead = System.in.read(buffer)) != -1) {
                toServer.write(buffer, 0, bytesRead);
                toServer.flush();

                bytesRead = fromServer.read(buffer);
                System.out.write(buffer, 0, bytesRead);
                System.out.flush();
            }

            socket.shutdownOutput();

            while ((bytesRead = fromServer.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
                System.out.flush();
            }

            socket.close();

        } catch(Exception e){
            System.out.println(e);
         }
    }
}