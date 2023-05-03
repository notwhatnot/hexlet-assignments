package exercise;

import java.util.List;
import java.util.ArrayList;
import exercise.connections.Connection;
import exercise.connections.Disconnected;


// BEGIN
public class TcpConnection {

    private String ipAddress;
    private int port;
    private Connection connectionState;

    public TcpConnection(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.connectionState = new Disconnected(this);
    }

    public String getCurrentState() {
        return this.connectionState.getState();
    }

    public void setCurrentState(Connection connectionState) {
        this.connectionState = connectionState;
    }

    public void connect() {
        this.connectionState.connect();
    }

    public void disconnect() {
        this.connectionState.disconnect();
    }

    public void write(String data) {
        this.connectionState.write(data);
    }

}
// END
