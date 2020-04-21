public class Gracz {

    private int liczbaPunktow;
    private int coRysuje; //wskazuje na indeks w tablicy HASEŁ hasła, które gracz rysujący wybrał

    private String nazwaGracza;

    public Gracz(){
        this.nazwaGracza = "";
    }

    public void dodajPunkt(int numerGracza, int liczbaDodanychPunktow){
        liczbaPunktow =+ liczbaDodanychPunktow;
    }

    public int getLiczbaPunktow(){ return liczbaPunktow; }

    public String getNazwaGracza() { return nazwaGracza; }

    public void setNazwaGracza(String nazwaGracza) {
        if(nazwaGracza.equals(""))
            throw new IllegalArgumentException();
        else
            this.nazwaGracza = nazwaGracza; }

}
