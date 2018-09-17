package poslovnaBanka.analitikaIzvoda;

import java.util.List;

public interface AnalitikaIzvodaService {
    List<AnalitikaIzvoda> findAll();
    AnalitikaIzvoda create(AnalitikaIzvoda analitikaIzvoda);
}
