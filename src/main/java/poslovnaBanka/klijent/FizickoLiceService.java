package poslovnaBanka.klijent;

import java.util.List;

public interface FizickoLiceService {
    FizickoLice add(FizickoLice fizickoLice);
    List<FizickoLice> findAll();
    FizickoLice update(FizickoLice fizickoLice);
    FizickoLice findOne(Long id);
    void delete(Long id);
}
