package poslovnaBanka.racuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RacuniLicaServiceImpl implements RacuniLicaService {

    @Autowired
    private RacuniLicaRepository racuniLicaRepository;

    @Override
    public List<RacuniLica> findAll() {
        return racuniLicaRepository.findAll();
    }

    @Override
    public RacuniLica findOne(long id) {
        return racuniLicaRepository.findOne(id);
    }

    @Override
    public RacuniLica create(RacuniLica racuniLica) {
        RacuniLica rac = this.racuniLicaRepository.save(racuniLica);
        return rac;
    }

    @Override
    public RacuniLica update(RacuniLica racuniLica) throws Exception {
        RacuniLica rac = racuniLicaRepository.findOne(racuniLica.getId());

        if(rac == null){
            throw new Exception("NIJE NADJENO");
        }

        rac.setBr_racuna(rac.getBr_racuna());
        rac.setDatum_otvaranja(rac.getDatum_otvaranja());
        rac.setVazeci(rac.isVazeci());

        RacuniLica racUpdt = this.racuniLicaRepository.save(rac);

        return racUpdt;
    }

    @Override
    public void delete(long id) {
        this.racuniLicaRepository.delete(id);

    }
}
