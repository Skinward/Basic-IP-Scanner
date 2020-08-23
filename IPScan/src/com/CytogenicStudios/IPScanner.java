package com.CytogenicStudios;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPScanner extends JFrame{

    private final JTextField userInput;
    private JLabel ipAddress;
    private String result;

    public IPScanner(){
////////Initialize The Frame And Panel
        JFrame frame = new JFrame("IP Scanner");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

////////Set Up The Components
        JLabel instructions = new JLabel("Enter the website you want the ip address of.");
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);

        userInput = new JTextField();
        userInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        userInput.setMaximumSize(new Dimension(200,25));

        JButton submit = new JButton("GO");
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit.addActionListener(e -> {
            try {
                ipAddress.setText(getIP());
            } catch (UnknownHostException unknownHostException) {
                unknownHostException.printStackTrace();
                ipAddress.setText("Invalid Input");
            }
        });

        ipAddress = new JLabel();
        ipAddress.setAlignmentX(Component.CENTER_ALIGNMENT);

        result = "";

////////Set Up The Panel
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        panel.add(instructions);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        panel.add(userInput);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        panel.add(submit);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));
        panel.add(ipAddress);
        panel.add(Box.createRigidArea(new Dimension(5, 10)));

////////Set Up The Frame
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(450, 175));
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);

    }

////Runs The Check For IP And Returns It In String Form
    private String getIP() throws UnknownHostException {
        result = InetAddress.getByName(userInput.getText()).getHostAddress();
        return result;
    }

}
