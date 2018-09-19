package poslovnaBanka.racuni;



import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface DnevnoStanjeRacunaService {

    List<DnevnoStanjeRacuna> findAll();
    DnevnoStanjeRacuna findOne(long id);
    DnevnoStanjeRacuna create(DnevnoStanjeRacuna dsr);
    DnevnoStanjeRacuna update(DnevnoStanjeRacuna dsr) throws Exception;
    DnevnoStanjeRacuna getLast(RacuniLica racuniLica);
    List<DnevnoStanjeRacuna> getByRacun(RacuniLica racuniLica);
    List<DnevnoStanjeRacuna> export(long id, Date pocetak, Date kraj) throws IOException;
    void delete(long id);

}
