package poslovnaBanka.racuni;



import java.util.List;

public interface DnevnoStanjeRacunaService {

    List<DnevnoStanjeRacuna> findAll();
    DnevnoStanjeRacuna findOne(long id);
    DnevnoStanjeRacuna create(DnevnoStanjeRacuna dsr);
    DnevnoStanjeRacuna update(DnevnoStanjeRacuna dsr) throws Exception;
    void delete(long id);

}
