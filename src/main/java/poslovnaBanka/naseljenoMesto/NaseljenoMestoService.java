package poslovnaBanka.naseljenoMesto;


import java.util.List;

public interface NaseljenoMestoService {

    List<NaseljenoMesto> findAll();
    NaseljenoMesto findOne(long id);
    NaseljenoMesto create(NaseljenoMesto drzava);
    NaseljenoMesto update(NaseljenoMesto drzava) throws Exception;
    void delete(long id);

}
