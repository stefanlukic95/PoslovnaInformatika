package poslovnaBanka.racuni;

import java.util.List;

public interface RacuniLicaService {
    List<RacuniLica> findAll();
    RacuniLica findOne(long id);
    RacuniLica createRacunPravno(RacuniLica racuniLica, long id);
    RacuniLica createRacunFizicko(RacuniLica racuniLica, long id);
    RacuniLica update(RacuniLica racuniLica) throws Exception;
    void delete(long id);
}
