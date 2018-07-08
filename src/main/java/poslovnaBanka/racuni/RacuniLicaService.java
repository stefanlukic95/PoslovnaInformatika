package poslovnaBanka.racuni;

import java.util.List;

public interface RacuniLicaService {
    List<RacuniLica> findAll();
    RacuniLica findOne(long id);
    RacuniLica create(RacuniLica racuniLica);
    RacuniLica update(RacuniLica racuniLica) throws Exception;
    void delete(long id);
}
