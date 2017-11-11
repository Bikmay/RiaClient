import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Ivliev on 11.11.2017.
 */
public class TransportProtocol {

    static Socket socketClient = TalkToServer.socket;

    public static void takeSystemFile() throws IOException {

        OutputStream out = socketClient.getOutputStream();
        DataOutputStream dout = new DataOutputStream(out);


        dout.writeUTF("SYSTEM GETLIST");

        Path path = Paths.get("//systemXML//listfonts.xml");
        byte[] byteMass = Files.readAllBytes(path);
        out.write(byteMass);

        out.close();

    }


    public static void takeFileFont(String nameFile) throws IOException {
        OutputStream out = socketClient.getOutputStream();
        DataOutputStream dout = new DataOutputStream(out);


        dout.writeUTF("SYSTEM FONT");

        Path path = Paths.get("//data//"+nameFile+".ttf");
        byte[] byteMass = Files.readAllBytes(path);
        out.write(byteMass);

        dout.close();
        out.close();
    }

    public static void giveFontFile() throws IOException {

        int lenMass;
        String name;

        InputStream in = socketClient.getInputStream();
        DataInputStream din = new DataInputStream(in);

        name=din.readUTF();//Get name font

       lenMass = din.readInt();//How many bytes?

        byte[] file = new byte[lenMass];

        in.read(file);

        FileOutputStream fileOutputStream = new FileOutputStream(new File("//data//fonts//"+name+".ttf"));

        fileOutputStream.write(file);
        fileOutputStream.close();



    }

}
