package FrancescoAlves.entities;

import FrancescoAlves.exceptions.ValidazioneDati;

public abstract class Gioco {
    private String id;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Gioco(String id, String titolo, int annoPubblicazione, double prezzo) throws ValidazioneDati {

        if (id == null || id.isEmpty()) throw new ValidazioneDati("Il campo ID non può essere vuoto");
        if (titolo == null || titolo.isEmpty()) throw new ValidazioneDati("Il titolo non può essere vuoto");

        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        setPrezzo(prezzo);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) throws ValidazioneDati {
        if (prezzo <= 0) {
            throw new ValidazioneDati("Il prezzo deve essere un valore positivo " + prezzo);
        } else {
            this.prezzo = prezzo;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Titolo: " + titolo + " | Prezzo: " + prezzo + "€";
    }

}
