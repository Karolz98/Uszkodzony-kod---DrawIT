import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OknoHasła extends JDialog {
    private JPanel panel1;
    private JButton STARTButton;
    private JPasswordField hasło;

    public OknoHasła(GraGUI graGUI){
        setContentPane(this.panel1);
        setModal(true);
        setUndecorated(true);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(STARTButton);
        pack();

        STARTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    graGUI.getKlient().setOktet4(Integer.parseInt(String.valueOf(hasło.getPassword())));
                    dispose();
                }catch(IllegalArgumentException e){
                    System.out.println("Bledne haslo");
                }
            }
        });



    }
}
