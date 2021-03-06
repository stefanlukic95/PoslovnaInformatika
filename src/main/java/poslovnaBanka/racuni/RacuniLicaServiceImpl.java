
package poslovnaBanka.racuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poslovnaBanka.banka.Banka;
import poslovnaBanka.banka.BankaService;
import poslovnaBanka.klijent.FizickoLice;
import poslovnaBanka.klijent.FizickoLiceService;
import poslovnaBanka.klijent.PravnoLice;
import poslovnaBanka.klijent.PravnoLiceService;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class RacuniLicaServiceImpl implements RacuniLicaService {

    @Autowired
    private RacuniLicaRepository racuniLicaRepository;

    @Autowired
    private FizickoLiceService fizickoLiceService;

    @Autowired
    private PravnoLiceService pravnoLiceService;

    @Autowired
    private BankaService bankaService;

    @Autowired
    private DnevnoStanjeRacunaService dnevnoStanjeRacunaService;

    @Override
    public List<RacuniLica> findAll() {
        return racuniLicaRepository.findAll();
    }

    @Override
    public RacuniLica findOne(long id) {
        return racuniLicaRepository.findOne(id);
    }

    @Override
    public RacuniLica createRacunPravno(RacuniLica racuniLica, long id) {
        Banka banka = bankaService.getBanka();
        racuniLica.setBanka(banka);
        PravnoLice pravnoLice = pravnoLiceService.findOne(id);
        racuniLica.setPravnoLice(pravnoLice);
        RacuniLica racun = racuniLicaRepository.save(racuniLica);
        DnevnoStanjeRacuna dnevnoStanjeRacuna = new DnevnoStanjeRacuna(new Date(), 0, 0, 0,0,racun);
        dnevnoStanjeRacunaService.create(dnevnoStanjeRacuna);
        return racun;
    }

    @Override
    public RacuniLica createRacunFizicko(RacuniLica racuniLica, long id) {
        Banka banka = bankaService.getBanka();
        racuniLica.setBanka(banka);
        FizickoLice fizickoLice = fizickoLiceService.findOne(id);
        racuniLica.setFizickoLice(fizickoLice);
        RacuniLica racun = racuniLicaRepository.save(racuniLica);
        DnevnoStanjeRacuna dnevnoStanjeRacuna = new DnevnoStanjeRacuna(new Date(), 0, 0, 0,0,racun);
        dnevnoStanjeRacunaService.create(dnevnoStanjeRacuna);
        return racun;
    }


    @Override
    public RacuniLica update(RacuniLica racuniLica) throws Exception {
        RacuniLica rac = this.racuniLicaRepository.findOne(racuniLica.getId());

        if(rac == null){
            throw new Exception("NIJE NADJENO");
        }

        rac.setBr_racuna(racuniLica.getBr_racuna());
        rac.setDatum_otvaranja(racuniLica.getDatum_otvaranja());


        RacuniLica racUpdt = this.racuniLicaRepository.save(rac);

        return racUpdt;
    }



    @Override
    public void delete(long id) {
        this.racuniLicaRepository.delete(id);

    }
}

