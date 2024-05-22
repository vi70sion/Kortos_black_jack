import java.util.ArrayList;
import java.util.List;

public class Zaidejas {
    private List<Korta> zaidejoKortos = new ArrayList<>();

    public Zaidejas(List<Korta> zaidejoKortos) {
        this.zaidejoKortos = zaidejoKortos;
    }

    public Zaidejas() {
    }

    public List<Korta> getZaidejoKortos() { return zaidejoKortos; }
    public void setZaidejoKortos(List<Korta> zaidejoKortos) { this.zaidejoKortos = zaidejoKortos; }



}
