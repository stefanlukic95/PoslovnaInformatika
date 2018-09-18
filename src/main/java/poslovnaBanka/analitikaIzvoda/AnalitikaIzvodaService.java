package poslovnaBanka.analitikaIzvoda;

import java.io.IOException;
import java.util.List;

public interface AnalitikaIzvodaService {
    List<AnalitikaIzvoda> findAll();
    AnalitikaIzvoda create(AnalitikaIzvoda analitikaIzvoda);
    AnalitikaIzvoda export(AnalitikaIzvoda analitikaIzvoda) throws IOException;
}
