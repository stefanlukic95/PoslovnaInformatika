package poslovnaBanka.valute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ValuteServiceImpl implements ValuteService {

    @Autowired
    private ValuteRepository valuteRepository;

    @Override
    public List<Valute> findAll() {
        return valuteRepository.findAll();
    }

    @Override
    public Valute findOne(long id) {
        return valuteRepository.findOne(id);
    }

    @Override
    public Valute create(Valute nasm) {

        Valute savedNasm = this.valuteRepository.save(nasm);
        return savedNasm;
    }


    @Override
    public Valute update(Valute val)throws Exception{
        Valute valUpdt = this.valuteRepository.findOne(val.getId());

        if(valUpdt == null){
            throw new Exception("NEMA");
        }

        valUpdt.setId_valute(val.getId_valute());
        valUpdt.setNaziv(val.getNaziv());
        valUpdt.setSifra(val.getSifra());
        valUpdt.setDomicilna(val.isDomicilna());
        valUpdt.setDrzava(val.getDrzava());

        Valute updateVal = this.valuteRepository.save(valUpdt);
        return updateVal;

    }

    @Override
    public void delete(long id) {
        this.valuteRepository.delete(id);
    }

}
