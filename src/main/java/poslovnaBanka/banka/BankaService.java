package poslovnaBanka.banka;

import java.util.List;

public interface BankaService {

    Banka getBanka();
    List<Banka> findAll();
    Banka findOne(long id);
    Banka save(Banka banka);
}
