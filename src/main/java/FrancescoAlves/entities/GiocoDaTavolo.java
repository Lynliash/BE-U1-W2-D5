package FrancescoAlves.entities;

import FrancescoAlves.exceptions.ValidazioneDati;

public class GiocoDaTavolo extends Gioco {

    private int numeroDiGiocatori;
    private Double durataMedia;

    public GiocoDaTavolo(String id, String titolo, int annoPubblicazione, double prezzo, int numeroDiGiocatori, Double durataMedia) throws ValidazioneDati {
        super(id, titolo, annoPubblicazione, prezzo);
        setNumeroDiGiocatori(numeroDiGiocatori);
        this.durataMedia = durataMedia;
    }

    public int getNumeroDiGiocatori() {
        return numeroDiGiocatori;
    }

    public void setNumeroDiGiocatori(int numeroDiGiocatori) throws ValidazioneDati {
        if (numeroDiGiocatori >= 2 && numeroDiGiocatori <= 10) {
            this.numeroDiGiocatori = numeroDiGiocatori;
        } else {
            throw new ValidazioneDati("il numero di giocatori dev'essere compreso tra 2 e 10");
        }
    }

    public Double getDurataMedia() {
        return durataMedia;
    }

    public void setDurataMedia(Double durataMedia) {
        this.durataMedia = durataMedia;
    }
}
