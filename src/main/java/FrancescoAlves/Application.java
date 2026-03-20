package FrancescoAlves;

import FrancescoAlves.entities.Genere;
import FrancescoAlves.entities.Gioco;
import FrancescoAlves.entities.GiocoDaTavolo;
import FrancescoAlves.entities.Videogioco;
import FrancescoAlves.exceptions.ElementoNonTrovato;
import FrancescoAlves.exceptions.ValidazioneDati;
import FrancescoAlves.exceptions.ValoriDuplicati;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Collezione collect = new Collezione();

        try {

            Videogioco warcraft = new Videogioco("a1", "Warcraft 3", 2002, 50.50, "PC", 100.0, Genere.STRATEGIA);
            Videogioco fifa = new Videogioco("a2", "Fifa 26", 2025, 70.99, "PS5", 20.5, Genere.SPORT);
            GiocoDaTavolo monopoly = new GiocoDaTavolo("b1", "Monopoly", 1935, 40.0, 6, 60.0);
            GiocoDaTavolo risiko = new GiocoDaTavolo("b2", "Risiko", 1970, 35.0, 6, 120.0);

            collect.aggiungiGioco(warcraft);
            collect.aggiungiGioco(fifa);
            collect.aggiungiGioco(monopoly);
            collect.aggiungiGioco(risiko);


            Gioco trovato = collect.ricercaID("b2");
            System.out.println("Risultato della ricerca:" + trovato);

            System.out.println("SPAZIO------------------------------------------------");

            System.out.println("Ricerca prezzo");
            List<Gioco> economici = collect.ricercaPerPrezzo(45.0);
            for (Gioco g : economici) {
                System.out.println("- " + g);
            }

            System.out.println("SPAZIO------------------------------------------------");

            List<GiocoDaTavolo> perSei = collect.ricercaPerNumeroDiGiocatori(6);
            perSei.forEach(System.out::println);

            System.out.println("SPAZIO------------------------------------------------");

            // aggiornamento del gioco

            Videogioco fifaNuovo = new Videogioco("a2", "Fifa 26 Ultimate Edition", 2025, 99.99, "PS5", 50.0, Genere.SPORT);
            collect.aggiornaGioco("a2", fifaNuovo);
            System.out.println(collect.ricercaID("a2"));

            System.out.println("SPAZIO------------------------------------------------");


            collect.rimuoviID("b1"); // rimuovi
            System.out.println("rimosso gioc.");

            System.out.println("SPAZIO------------------------------------------------");


        } catch (ValidazioneDati | ValoriDuplicati | ElementoNonTrovato e) {
            System.err.println("ERRORE: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("ERRORE GENERICO: " + e.getMessage());
        }
    }
}