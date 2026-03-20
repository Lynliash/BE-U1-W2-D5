package FrancescoAlves.exceptions;

public class ElementoNonTrovato extends RuntimeException {
    public ElementoNonTrovato(String id) {
        super("Nessun gioco trovato con id: " + id);
    }
}
