package networking;

import model.DatabaseManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
    private DatabaseManager databaseManager;

    public void start()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(2910);
            System.out.println("Server started");

            while (true)
            {
                Socket socket = serverSocket.accept();
                System.out.println("Connection established");
                new Thread(new Handler(socket, databaseManager)).start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public SocketServer(DatabaseManager databaseManager)
    {
        this.databaseManager = databaseManager;
    }
}
