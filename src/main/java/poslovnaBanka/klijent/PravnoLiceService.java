package poslovnaBanka.klijent;

import java.util.List;

public interface PravnoLiceService {
    PravnoLice add(PravnoLice pravnoLice);
    List<PravnoLice> findAll();
    PravnoLice update(PravnoLice pravnoLice);
    PravnoLice findOne(Long id);
    void delete(Long id);
}
