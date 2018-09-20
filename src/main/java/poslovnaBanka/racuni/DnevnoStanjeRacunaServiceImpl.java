package poslovnaBanka.racuni;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

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
    public DnevnoStanjeRacuna getLast(RacuniLica racuniLica) {
        List<DnevnoStanjeRacuna> stanja = dnevnoStanjeRacunaRepository.findAll();
        List<DnevnoStanjeRacuna> stanjaRacun = new ArrayList<DnevnoStanjeRacuna>();
        for(DnevnoStanjeRacuna s : stanja) {
            if(s.getRacuniLica().getId() == racuniLica.getId()) {
                stanjaRacun.add(s);
            }
        }
        DnevnoStanjeRacuna ret = stanjaRacun.get(stanjaRacun.size()-1);
        return ret;
    }

    @Override
    public List<DnevnoStanjeRacuna> getByRacun(RacuniLica racuniLica) {
        List<DnevnoStanjeRacuna> stanja = dnevnoStanjeRacunaRepository.findAll();
        List<DnevnoStanjeRacuna> ret = new ArrayList<DnevnoStanjeRacuna>();
        for(DnevnoStanjeRacuna d : stanja) {
            if(d.getRacuniLica().getId() == racuniLica.getId()) {
                ret.add(d);
            }
        }

        return ret;
    }

    @Override
    public List<DnevnoStanjeRacuna> export(long id, Date pocetak, Date kraj) throws IOException {
        List<DnevnoStanjeRacuna> stanja = findAll();
        List<DnevnoStanjeRacuna> ret = new ArrayList<DnevnoStanjeRacuna>();
        for(DnevnoStanjeRacuna s: stanja) {
            if(s.getRacuniLica().getId() == id && s.getDatum_prometa().after(pocetak) && s.getDatum_prometa().before(kraj)) {
                ret.add(s);
            }
        }
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File("export//izvod-stanja//izvod-stanja" + id + ".xml"), ret);
        File file = new File("export//izvod-stanja//izvod-stanja" + id + ".xml");
        assertNotNull(file);
        return ret;
    }

    @Override
    public void delete(long id) {
        this.dnevnoStanjeRacunaRepository.delete(id);
    }

}
