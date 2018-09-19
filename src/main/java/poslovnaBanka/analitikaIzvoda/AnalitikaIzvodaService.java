package poslovnaBanka.analitikaIzvoda;

import java.io.IOException;
import java.util.List;

public interface AnalitikaIzvodaService {
    List<AnalitikaIzvoda> findAll();
    AnalitikaIzvoda create(AnalitikaIzvoda analitikaIzvoda);
    AnalitikaIzvoda exportUplata(AnalitikaIzvoda analitikaIzvoda) throws IOException;
    AnalitikaIzvoda exportIsplata(AnalitikaIzvoda analitikaIzvoda) throws IOException;
}
