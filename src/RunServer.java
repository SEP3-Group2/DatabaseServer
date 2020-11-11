import model.DatabaseManagerImpl;
import networking.SocketServer;

public class RunServer
{
    public static void main(String[] args)
    {
        SocketServer ss = new SocketServer(new DatabaseManagerImpl());
        ss.start();
    }
}
