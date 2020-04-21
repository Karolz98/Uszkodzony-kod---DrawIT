import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gra{

    private int numerTury;
    private int maksymalnaLiczbaTur;
    private int liczbaGraczy;
    private int wygrywaGracz;
    private List <String> haslaTab;
    private int seed;
    private Random random;



    private Gracz[] gracze;

    public Gra(int liczbaGraczy){
        this.numerTury = 0;
        this.maksymalnaLiczbaTur = 10;
        this.liczbaGraczy = liczbaGraczy;
        this.gracze = new Gracz[liczbaGraczy];

        for(int i = 0; i<liczbaGraczy;i++){
            gracze[i] = new Gracz();
        }
        odczytHasel();
        random = new Random();
    }

    public void dodajPunkt(){
        int liczbaP = gracze[getNrGracza()].getLiczbaPunktow();
        liczbaP++;
    }

    public int getNrGracza() {
        return numerTury%liczbaGraczy;
    }

    public int losujNrGracza(){
            return new Random().nextInt(liczbaGraczy);
    }

    public Gracz[] getGracze() {
        return gracze;
    }

    public String getHaslo() { ;
        return haslaTab.remove(random.nextInt(haslaTab.size()));
    }

    public void setSeed(int seed) {
        this.seed = seed;
        random.setSeed(seed);

    }

    private void odczytHasel()  {
        try {
            Scanner odczyt = new Scanner((new File("src\\Slowa_kluczowe.txt")));
            haslaTab = new ArrayList<>();
            while(odczyt.hasNextLine()) {
            haslaTab.add(odczyt.nextLine());
        }
        }catch(FileNotFoundException e){
            System.out.println("zle sie dzieje");
        }
    }

}
