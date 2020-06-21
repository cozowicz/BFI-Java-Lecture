package rmi;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.rmi.registry.Registry;
import java.io.BufferedReader;
import java.rmi.RemoteException;
import java.awt.event.*;

public class ClientGUI extends JFrame {

    public class ClientRemote extends UnicastRemoteObject implements  ClientInterface {

        public ClientRemote() throws RemoteException {}

        public void receiveMsg(final String name, final String msg) throws RemoteException {
            // this method is called from the RMI thread
            // according to Swing, UI Components must not be altered from another thread
            // than the EventQueue Thread
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    msgListModel.addElement(name + ": " + msg);
                    scrollPane.validate(); // otherwise the scrollPane has still the old value
                    scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
                }
            });
        }
    }


    public ClientGUI() throws Exception {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        textField.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent e) {
                        try {
                            server.sendMsg(name, textField.getText());
                            textField.setText("");
                        } catch (RemoteException ex) {
                            ex.printStackTrace();
                        }
                      }
                  });

        Registry reg = LocateRegistry.getRegistry("localhost", 1099);

        server = (ServerInterface) reg.lookup("ChatServer");

        client = new ClientRemote();
        ClientInterface stub = (ClientInterface) UnicastRemoteObject.toStub(client);

        name = JOptionPane.showInputDialog(this, "Enter Name:","Markus");

        label.setText(name+":");
        server.login(name, stub);
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(gridBagLayout1);
        label.setText("Username:");
        scrollPane.getViewport().add(msgList);
        this.getContentPane().add(scrollPane,
                                  new GridBagConstraints(0, 0, 2, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5, 5, 5, 5), 0, 0));
        this.getContentPane().add(label,
                                  new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 5, 5, 5), 0, 0));
        this.getContentPane().add(textField,
                                  new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 5, 5), 0, 0));
    }

    ServerInterface server;
    ClientInterface client;
    String name;

    DefaultListModel msgListModel = new DefaultListModel();

    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JList msgList = new JList(msgListModel);
    JScrollPane scrollPane = new JScrollPane();

    public static void main(String[] args) throws Exception {
        ClientGUI gui = new ClientGUI();
        gui.setBounds(0,0,1024,786);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);

    }
}
