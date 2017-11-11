import java.io.IOException;
import java.net.Socket;

/**
 * Created by ф on 11.11.2017.
 */
public class TalkToServer extends IOException {

    public static Socket socket;

    TalkToServer() throws IOException {

        socket = new Socket("client",44501);
    }

    public static void main(String[] args) {


    }
}
