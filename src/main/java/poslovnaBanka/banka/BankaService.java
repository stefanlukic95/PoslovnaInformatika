package poslovnaBanka.banka;

import java.util.List;

public interface BankaService {

    List<Banka> findAll();
    Banka findOne(long id);
}
