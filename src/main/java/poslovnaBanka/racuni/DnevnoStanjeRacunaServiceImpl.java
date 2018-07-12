package poslovnaBanka.racuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnevnoStanjeRacunaServiceImpl implements DnevnoStanjeRacunaService{

    @Autowired
    private DnevnoStanjeRacunaRepository dnevnoStanjeRacunaRepository;

    @Override
    public List<DnevnoStanjeRacuna> findAll() {
        return dnevnoStanjeRacunaRepository.findAll();
    }

    @Override
    public DnevnoStanjeRacuna findOne(long id) {
        return dnevnoStanjeRacunaRepository.findOne(id);
    }

    @Override
    public DnevnoStanjeRacuna create(DnevnoStanjeRacuna nasm) {

        DnevnoStanjeRacuna savedNasm = this.dnevnoStanjeRacunaRepository.save(nasm);
        return savedNasm;
    }


    @Override
    public DnevnoStanjeRacuna update(DnevnoStanjeRacuna nasm)throws Exception{
        DnevnoStanjeRacuna nasmUpdt = this.dnevnoStanjeRacunaRepository.findOne(nasm.getId());

        if(nasmUpdt == null){
            throw new Exception("NEMA");
        }
        nasmUpdt.setDatum_prometa(nasm.getDatum_prometa());
        nasmUpdt.setNovo_stanje(nasm.getNovo_stanje());
        nasmUpdt.setPrethodno_stanje(nasm.getPrethodno_stanje());
        nasmUpdt.setPromet_korist(nasm.getPromet_korist());
        nasmUpdt.setPromet_teren(nasm.getPromet_teren());
        nasmUpdt.setRacuniLica(nasm.getRacuniLica());

        DnevnoStanjeRacuna updateNasm = this.dnevnoStanjeRacunaRepository.save(nasmUpdt);
        return updateNasm;
    }

    @Override
    public void delete(long id) {
        this.dnevnoStanjeRacunaRepository.delete(id);
    }

}
