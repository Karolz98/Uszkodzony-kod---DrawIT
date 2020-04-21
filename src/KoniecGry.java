import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KoniecGry extends JDialog{

    private JPanel panel1;
    private JButton zakończButton;
    private JTextField zwyciezca;

    public KoniecGry(GraGUI graGUI){
        setContentPane(panel1);
        setModal(true);
        getRootPane().setDefaultButton(zakończButton);
        setLocationRelativeTo(null);
        pack();
        if(graGUI.getCzyKoniecGry() == true)
            zwyciezca.setText(graGUI.getGra().getGracze()[0].getNazwaGracza() + " wygrywa!");
        else if(graGUI.getCzyKoniecGry() == false)
            zwyciezca.setText("Mamy remis!");

        zakończButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}
