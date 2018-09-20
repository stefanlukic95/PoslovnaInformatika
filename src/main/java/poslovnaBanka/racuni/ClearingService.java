package poslovnaBanka.racuni;


import poslovnaBanka.analitikaIzvoda.AnalitikaIzvoda;

import java.io.IOException;
import java.util.List;

public interface ClearingService {

    void increaseSum(Clearing clearing, double iznos);
    Clearing exportClearing(Clearing clearing) throws IOException;
    Clearing save(Clearing clearing);
    List<Clearing> getObradjeni();
}
