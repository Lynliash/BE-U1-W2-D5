package FrancescoAlves.entities;

import FrancescoAlves.exceptions.ValidazioneDati;

public class Videogioco extends Gioco {

    private String piattaforma;
    private Double durata;
    private Genere genere;


    public Videogioco(String id, String titolo, int annoPubblicazione, double prezzo, String piattaforma, Double durata, Genere genere) throws ValidazioneDati {
        super(id, titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durata = durata;
        this.genere = genere;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public Double getDurata() {
        return durata;
    }

    public void setDurata(Double durata) {
        this.durata = durata;
    }
}
