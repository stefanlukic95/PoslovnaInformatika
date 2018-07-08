package poslovnaBanka.valute;

import java.util.List;

public interface ValuteService {

    List<Valute> findAll();
    Valute findOne(long id);
    Valute create(Valute valuta);
    Valute update(Valute valuta) throws Exception;
    void delete(long id);
}
