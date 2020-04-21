import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaitingGUI extends JDialog{
    private JPanel P;
    private JTextField hasloTF;
    private JButton zamknijButton;

    public WaitingGUI(GraGUI graGUI){
        setContentPane(P);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(zamknijButton);
        pack();
        hasloTF.setText(Byte.toString(graGUI.getKlient().getOstatniOktet()));
        zamknijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }


}
