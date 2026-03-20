package FrancescoAlves;

import FrancescoAlves.entities.Gioco;
import FrancescoAlves.entities.GiocoDaTavolo;
import FrancescoAlves.entities.Videogioco;
import FrancescoAlves.exceptions.ElementoNonTrovato;
import FrancescoAlves.exceptions.ValidazioneDati;
import FrancescoAlves.exceptions.ValoriDuplicati;

import java.util.ArrayList;
import java.util.List;

public class Collezione {
    private List<Gioco> giochi = new ArrayList<>();

//    Aggiungere un gioco

    public void aggiungiGioco(Gioco nuovoGioco) throws ValoriDuplicati {
        boolean giocoDuplicato = giochi.stream().anyMatch(gioco -> gioco.getId().equals(nuovoGioco.getId()));

        if (giocoDuplicato) {
            throw new ValoriDuplicati("Questo id è gia presente nel catalogo");
        } else {
            giochi.add(nuovoGioco);
        }
    }

    //    ricerca per ID
    public Gioco ricercaID(String id) throws ElementoNonTrovato {
        return giochi.stream().filter(gioco -> gioco.getId().equals(id)).findFirst().orElseThrow(() -> new ElementoNonTrovato(id));

    }


//    ricerca per prezzo inferiore

    public List<Gioco> ricercaPerPrezzo(double prezzo) {
        List<Gioco> listaDiGiochi = giochi.stream().filter(gioco -> gioco.getPrezzo() < prezzo).toList();
        if (listaDiGiochi.isEmpty()) {
            throw new ValidazioneDati("Non ci sono giochi con prezzo inferiore a quello dichiarato");
        }
        return listaDiGiochi;
    }


//    ricerca per numero di giocatori

    public List<GiocoDaTavolo> ricercaPerNumeroDiGiocatori(int num) {
        if (num < 2 || num > 10) {
            throw new ValidazioneDati("Numero giocatori non valido");
        }

        List<GiocoDaTavolo> giochiGiusti = giochi.stream().filter(gioco -> gioco instanceof GiocoDaTavolo).map(gioco -> (GiocoDaTavolo) gioco)
                .filter(giocoDaTavolo -> giocoDaTavolo.getNumeroDiGiocatori() == num).toList();

        if (giochiGiusti.isEmpty()) {
            throw new ValidazioneDati("La lista è vuota");
        }
        return giochiGiusti;
    }

//    rimuovi per ID

    public void rimuoviID(String id) {
        Gioco giocoDaEliminare = ricercaID(id);
        giochi.remove(giocoDaEliminare);
    }


//    aggiornamento

    public void aggiornaGioco(String id, Gioco nuovoGioco) {
        if (nuovoGioco == null) {
            throw new IllegalArgumentException("Il nuovo gioco non può essere null!");
        }


        Gioco giocoEsistente = ricercaID(id);

        int indice = giochi.indexOf(giocoEsistente);

        if (!nuovoGioco.getId().equals(id)) {
            throw new ValidazioneDati("L'ID del nuovo gioco deve corrispondere all'ID fornito per l'aggiornamento!");
        }

        giochi.set(indice, nuovoGioco);
        System.out.println("Gioco con ID " + id + " aggiornato con successo!");
    }

//    public Gioco aggiornaGioco(String id, String titolo, int annoDiPubblicazione, double prezzo,) {
//
//        Gioco giocoDaAggiornare = ricercaID(id);
//        giocoDaAggiornare.setTitolo(titolo);
//        giocoDaAggiornare.setPrezzo(prezzo);
//        giocoDaAggiornare.setAnnoPubblicazione(annoDiPubblicazione);
//if (giocoDaAggiornare instanceof Videogioco) {
//    ((Videogioco) giocoDaAggiornare).setPiattaforma();
//    ((Videogioco) giocoDaAggiornare).setDurata();
//    ((Videogioco) giocoDaAggiornare).setGenere();
//}
//
//    }

//    stampa delle statistiche

    public void stampaConteggi() {
        int videog = 0;
        int giochiTav = 0;
        for (int i = 0; i < giochi.size(); i++) {
            if (giochi.get(i) instanceof Videogioco) {
                videog = videog + 1;
            } else if (giochi.get(i) instanceof GiocoDaTavolo) {
                giochiTav = giochiTav + 1;
            }
        }
        System.out.println("videogiochi totali:" + giochiTav);
        System.out.println("giochi da tavolo totali:" + giochiTav);
    }

//
//    public void giocoPiuCaro() {
//        if (giochi.isEmpty()) return;
//
}


