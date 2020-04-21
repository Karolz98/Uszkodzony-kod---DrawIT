import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class MenuGUI extends JDialog{
    private JButton HOSTGAMEButton;
    private JPanel menuGry;
    private JFormattedTextField imie1;
    private JButton JOINButton;
    private JPanel P;

    public MenuGUI(GraGUI graGUI){
        setTitle("MENU");
        setContentPane(menuGry);
        setModal(true);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(HOSTGAMEButton);
        getRootPane().setDefaultButton(JOINButton);
        setLocation(430,200);
        pack();



        HOSTGAMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                    if(graGUI.getCzyKoniecGry()){
                        KoniecGry koniecGry = new KoniecGry(graGUI);
                        koniecGry.setVisible(true);
                    }
                    else {
                        if(graGUI.getKlient().getPlayerID() == -5) {//brak wczesniejszych udanych polaczen z serwerem
                            new Thread(() -> graGUI.stworzGre()).start();
                            graGUI.start();

                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try{
                        graGUI.getGra().getGracze()[graGUI.getKlient().getPlayerID()].setNazwaGracza(imie1.getText());
                        }catch (IllegalArgumentException ee){
                            JOptionPane.showMessageDialog(null, "Podaj imię!");
                        }
                        graGUI.getKlient().setImie(imie1.getText(),graGUI.getKlient().getPlayerID());
                        graGUI.getKlient().wyslijImie();
                    }
                    dispose();
                    WaitingGUI waitingGUI = new WaitingGUI(graGUI);
                    waitingGUI.setVisible(true);

            }
        });

        JOINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    OknoHasła oknoHasła = new OknoHasła(graGUI);
                    oknoHasła.setVisible(true);
                    if(graGUI.getKlient().getPlayerID() == -5){//brak wczesniejszych udanych polaczen z serwerem
                        graGUI.start();
                    }
                    Thread.sleep(1000);
                    graGUI.getGra().getGracze()[graGUI.getKlient().getPlayerID()].setNazwaGracza(imie1.getText());
                    graGUI.getKlient().setImie(imie1.getText(),graGUI.getKlient().getPlayerID());
                    graGUI.getKlient().wyslijImie();
                    dispose();

                }catch (IllegalArgumentException | InterruptedException ee){
                    JOptionPane.showMessageDialog(null, "Podaj imię!");
                }
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowAdapter e){System.exit(0);}
        });
    }


}
