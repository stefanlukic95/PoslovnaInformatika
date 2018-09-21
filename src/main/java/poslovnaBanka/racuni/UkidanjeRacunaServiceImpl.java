package poslovnaBanka.racuni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UkidanjeRacunaServiceImpl implements UkidanjeRacunaService{

    @Autowired
    private UkidanjeRacunaRepository ukidanjeRacunaRepository;


    @Override
    public UkidanjeRacuna create(UkidanjeRacuna racun) {
        UkidanjeRacuna savedRacun = this.ukidanjeRacunaRepository.save(racun);
        return savedRacun;
    }
}
