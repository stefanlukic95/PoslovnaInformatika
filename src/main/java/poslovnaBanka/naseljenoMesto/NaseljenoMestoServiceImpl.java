package poslovnaBanka.naseljenoMesto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class NaseljenoMestoServiceImpl implements NaseljenoMestoService{

    @Autowired
    private NaseljenoMestoRepository naseljenoMestoRepository;

    @Override
    public List<NaseljenoMesto> findAll() {
        return naseljenoMestoRepository.findAll();
    }

    @Override
    public NaseljenoMesto findOne(long id) {
        return naseljenoMestoRepository.findOne(id);
    }

    @Override
    public NaseljenoMesto create(NaseljenoMesto nasm) {
        NaseljenoMesto savedNasm = this.naseljenoMestoRepository.save(nasm);
        return savedNasm;
    }


    @Override
    public NaseljenoMesto update(NaseljenoMesto nasm)throws Exception{
        NaseljenoMesto nasmUpdt = this.naseljenoMestoRepository.findOne(nasm.getId());

        if(nasmUpdt == null){
            throw new Exception("NEMA");
        }
        nasmUpdt.setSifra_mesta(nasm.getSifra_mesta());
        nasmUpdt.setNaziv(nasm.getNaziv());
        nasmUpdt.setPtt_oznaka(nasm.getPtt_oznaka());
        nasmUpdt.setDrzava(nasm.getDrzava());

        NaseljenoMesto updateNasm = this.naseljenoMestoRepository.save(nasmUpdt);
        return updateNasm;
    }

    @Override
    public void delete(long id) {
        this.naseljenoMestoRepository.delete(id);
    }

}
