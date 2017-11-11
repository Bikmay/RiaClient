import java.io.*;
import java.net.Socket;

/**
 * Created by ф on 11.11.2017.
 */
public class TalkToServer extends IOException {

    public static Socket socket;



    public static void main(String[] args) throws IOException, InterruptedException {




        while (true)
        {

            socket = new Socket("client",44501);//TODO Get InetAdress
            OutputStream out = socket.getOutputStream();
            DataOutputStream dout = new DataOutputStream(out);

            dout.writeUTF("CHECK "+1);

            XML.createListFonts();

            TransportProtocol.takeSystemFile();

            InputStream in = socket.getInputStream();
            DataInputStream din = new DataInputStream(in);

            String comand = din.readUTF();

            String[] massComand;
            massComand=comand.split(" ");
            int count = Integer.parseInt(massComand[1]);




                switch (massComand[0]) {

                    case "TAKEFONT":
                        for (int i = 0; i < count ; i++) {
                            TransportProtocol.giveFontFile();
                        }
                        break;
                    case "GIVEFONT":
                        for (int i = 0; i <count ; i++) {
                            TransportProtocol.takeFileFont();
                        }
                }



            out.close();
            socket.close();
            Thread.sleep(300000);
        }


    }
}
