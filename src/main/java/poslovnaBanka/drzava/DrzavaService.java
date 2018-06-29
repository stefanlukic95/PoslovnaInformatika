package poslovnaBanka.drzava;

import java.util.List;

public interface DrzavaService {
    List<Drzava> findAll();
    Drzava findOne(long id);
    Drzava create(Drzava drzava);
    Drzava update(Drzava drzava) throws Exception;
    void delete(long id);

}
