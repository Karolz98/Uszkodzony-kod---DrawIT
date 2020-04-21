import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class NowaTura extends JDialog {

    private JPanel P;
    private JButton okButton;
    private JTextArea textArea2;
    private JTextArea textArea1;
    private JTextField IDGracza;

    public NowaTura(GraGUI graGUI){
        String[] hasła = {"kot", "pies", "basen", "buty", "kwiatek"};
        setContentPane(P);
        setModal(true);
        setUndecorated(true);
        getRootPane().setDefaultButton(okButton);
        pack();
        okButton.setPreferredSize(new Dimension(300,20));
        IDGracza.setText(graGUI.getGra().getGracze()[graGUI.getGra().getNrGracza()].getNazwaGracza());

        //Wstawianie haseł do okienek----------------------------------
        String[] dwaSłowa = new String[2];
        dwaSłowa[0] = getRandom(hasła);
        do {
            dwaSłowa[1] = getRandom(hasła);
        }while (dwaSłowa[1].equals(dwaSłowa[0]));

        textArea1.setText(dwaSłowa[0]);
        textArea2.setText(dwaSłowa[1]);

        //Wstawianie haseł do okienek----------------------------------

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                graGUI.refresh();
                dispose();
            }
        });

        okButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    graGUI.refresh();
                    dispose();
                }
            }
        });

    }

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}

