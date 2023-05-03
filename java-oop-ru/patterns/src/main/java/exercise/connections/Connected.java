package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {

    private final TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error! Connection already established!");
    }

    @Override
    public void disconnect() {
        this.tcpConnection.setCurrentState(new Disconnected(this.tcpConnection));
    }

    @Override
    public void write(String data) {
    }
}
// END
