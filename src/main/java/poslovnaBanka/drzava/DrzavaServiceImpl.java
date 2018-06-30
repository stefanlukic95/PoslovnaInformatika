package poslovnaBanka.drzava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DrzavaServiceImpl implements DrzavaService {
    @Autowired
    private DrzavaRepository drzavaRepository;

    @Override
    public List<Drzava> findAll() {
        return drzavaRepository.findAll();
    }

    @Override
    public Drzava findOne(long id) {
        return drzavaRepository.findOne(id);
    }

    @Override
    public Drzava create(Drzava drzava) {
      Drzava savedDrzava = this.drzavaRepository.save(drzava);
      return savedDrzava;
    }


    @Override
    public Drzava update(Drzava drzava)throws Exception{
        Drzava drzavaUpdt = this.drzavaRepository.findOne(drzava.getId());

        if(drzavaUpdt == null){
            throw new Exception("NEMA");
        }
        drzavaUpdt.setSifra_drzave(drzava.getSifra_drzave());
        drzavaUpdt.setNaziv(drzava.getNaziv());
        drzavaUpdt.setNaseljenoMesto(drzava.getNaseljenoMesto());

        Drzava updateDrzava = this.drzavaRepository.save(drzavaUpdt);
        return updateDrzava;
    }

    @Override
    public void delete(long id) {
        this.drzavaRepository.delete(id);
    }

}
