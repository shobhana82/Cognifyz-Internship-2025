import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverterGUI {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Components
        JLabel fromLabel = new JLabel("From Unit:");
        JComboBox<String> fromBox = new JComboBox<>(new String[] {"C", "F", "K"});

        JLabel toLabel = new JLabel("To Unit:");
        JComboBox<String> toBox = new JComboBox<>(new String[] {"C", "F", "K"});

        JLabel tempLabel = new JLabel("Temperature:");
        JTextField tempField = new JTextField();

        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("");

        // Add components to frame
        frame.add(fromLabel);
        frame.add(fromBox);

        frame.add(toLabel);
        frame.add(toBox);

        frame.add(tempLabel);
        frame.add(tempField);

        frame.add(new JLabel("")); // spacer
        frame.add(convertButton);

        frame.add(new JLabel("Result:"));
        frame.add(resultLabel);

        // Convert button action
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fromUnit = (String) fromBox.getSelectedItem();
                String toUnit = (String) toBox.getSelectedItem();
                String tempText = tempField.getText();

                try {
                    double inputTemp = Double.parseDouble(tempText);
                    double convertedTemp = 0;

                    if (fromUnit.equals(toUnit)) {
                        resultLabel.setText("No conversion needed.");
                        return;
                    }

                    if (fromUnit.equals("C") && toUnit.equals("F")) {
                        convertedTemp = (inputTemp * 9/5) + 32;
                    } else if (fromUnit.equals("F") && toUnit.equals("C")) {
                        convertedTemp = (inputTemp - 32) * 5/9;
                    } else if (fromUnit.equals("C") && toUnit.equals("K")) {
                        convertedTemp = inputTemp + 273.15;
                    } else if (fromUnit.equals("K") && toUnit.equals("C")) {
                        convertedTemp = inputTemp - 273.15;
                    } else if (fromUnit.equals("F") && toUnit.equals("K")) {
                        convertedTemp = (inputTemp - 32) * 5/9 + 273.15;
                    } else if (fromUnit.equals("K") && toUnit.equals("F")) {
                        convertedTemp = (inputTemp - 273.15) * 9/5 + 32;
                    }

                    resultLabel.setText(String.format("%.2f %s = %.2f %s",
                        inputTemp, fromUnit, convertedTemp, toUnit));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid temperature input.");
                }
            }
        });

        frame.setVisible(true);
    }
}