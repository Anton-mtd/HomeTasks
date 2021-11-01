package graphicApp_lesson8;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class CounterApp extends JFrame {
    private int value;
    private int step = 1;

    public CounterApp(int initialValue) {
        setBounds(500, 500, 300, 120);
        setTitle("Simple Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        Font font = new Font("Arial", Font.BOLD, 32);

        JLabel counterValueView = new JLabel(String.valueOf(value));
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        counterValueView.setFont(font);
        add(counterValueView, BorderLayout.CENTER);

        value = initialValue;
        refreshCounterLabel(counterValueView);

        JButton decrementButton = new JButton("<");
        add(decrementButton, BorderLayout.LINE_START);
        decrementButton.setFont(font);

        JButton incrementButton = new JButton(">");
        add(incrementButton, BorderLayout.LINE_END);
        incrementButton.setFont(font);

        NumberFormat longFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setAllowsInvalid(false); //this is the key!!

        JPanel twoNorthButtons = new JPanel(new BorderLayout());

        JFormattedTextField stepTextField = new JFormattedTextField(numberFormatter);
        stepTextField.setHorizontalAlignment(SwingConstants.CENTER);
        stepTextField.setValue(step);
        stepTextField.setPreferredSize(new Dimension(50, 25));
        stepTextField.setToolTipText("step");
        stepTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                step = Integer.parseInt(stepTextField.getText());
            }
        });

        twoNorthButtons.add(stepTextField, BorderLayout.LINE_START);

        JFormattedTextField startValueTextField = new JFormattedTextField(numberFormatter);
        startValueTextField.setHorizontalAlignment(SwingConstants.CENTER);
        startValueTextField.setValue(value);
        startValueTextField.setPreferredSize(new Dimension(50, 25));
        startValueTextField.setToolTipText("start value");
        startValueTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                value = Integer.parseInt(startValueTextField.getText());
            }
        });

        startValueTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Integer.parseInt(startValueTextField.getText());
                counterValueView.setText(String.valueOf(value));
            }
        });

        twoNorthButtons.add(startValueTextField, BorderLayout.LINE_END);

        add(twoNorthButtons, BorderLayout.NORTH);

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value -= step;
                refreshCounterLabel(counterValueView);
            }
        });

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value += step;
                refreshCounterLabel(counterValueView);
            }
        });

        JButton clearButton = new JButton("Reset");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                step = 1;
                value = 0;
                stepTextField.setValue(step);
                startValueTextField.setValue(0);
                refreshCounterLabel(counterValueView);
            }
        });
        add(clearButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void refreshCounterLabel(JLabel counterValueView) {
        counterValueView.setText(String.valueOf(value));
    }

    public static void main(String[] args) {
        new CounterApp(0);
    }
}
