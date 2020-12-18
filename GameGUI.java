import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GameGUI extends JFrame {
    int min = 0;
    int max = 20;
    int diff = max - min;
    int c = 0;
    Random random = new Random();
    int i = random.nextInt(diff + 1);
    private final JButton button1 = new JButton("OK");
    private final JTextField text = new JTextField(10);
    private final JLabel label = new JLabel("");
//---------------------------------------------------------------------------
    public GameGUI() {
        super("Example");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(text);
        container.add(button1);
        container.add(label);
        button1.addActionListener(new ButtonEventListen());
    }
//---------------------------------------------------------------------------
    class ButtonEventListen implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String value = (text.getText());
            int t = Integer.parseInt(value);
            String str = Integer.toString(i += min);
            if (button1.isEnabled()) {
                c+=1;
                if (c == 4) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Вы исчерпали попытки" );
                    setVisible(false);
                    dispose();
                }
                if (value.equals(str)) {
                    label.setText("Число угадано верно ");
                }
                if (t > i) {
                    label.setText("Допущена ошибка, число больше ");
                }
                if (t < i) {
                    label.setText("Допущена ошибка, число меньше ");
                }
            }
        }
    }
}