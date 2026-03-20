package FrancescoAlves;

import FrancescoAlves.entities.Genere;
import FrancescoAlves.entities.Gioco;
import FrancescoAlves.entities.GiocoDaTavolo;
import FrancescoAlves.entities.Videogioco;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Gioco> catalogo = new ArrayList<>();

        Videogioco warcraft = new Videogioco("a1", "Warcraft 3", 2002, 50.50, "PC", 100.0, Genere.STRATEGIA);
        catalogo.add(warcraft);

        Videogioco fifa = new Videogioco("a2", "Fifa 26", 2025, 70.99, "PS5", 20.5, Genere.SPORT);
        catalogo.add(fifa);

        GiocoDaTavolo monopoly = new GiocoDaTavolo("b1", "Monopoly", 1935, 40.0, 6, 60.0);
        catalogo.add(monopoly);

        GiocoDaTavolo risiko = new GiocoDaTavolo("b2", "Risiko", 1970, 35.0, 6, 120.0);
        catalogo.add(risiko);

        System.out.println("Catalogo:");
        for (Gioco g : catalogo) {
            System.out.println("Titolo: " + g.getTitolo() + " | Prezzo: " + g.getPrezzo() + "€");
        }
    }
}