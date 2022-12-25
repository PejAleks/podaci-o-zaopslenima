public class Zaposleni {
    private int id, godine;
    private String ime, adresa;
    private double plata;

    public Zaposleni(int id,String ime, int godine, String adresa, double plata) {
        this.id=id;
        this.ime = ime;
        this.godine = godine;
        this.adresa = adresa;
        this.plata = plata;

    }

    public Zaposleni(String ime, int godine, String adresa, double plata) {
        this.ime = ime;
        this.godine = godine;
        this.adresa = adresa;
        this.plata = plata;
    }

    public Zaposleni() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    @Override
    public String toString() {
        return getId()+"\t"+getIme()+"\t"+getGodine()+"\t"+getAdresa()+"\t"+getPlata();
    }


}
