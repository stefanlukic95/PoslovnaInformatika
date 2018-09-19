package poslovnaBanka.racuni;

import poslovnaBanka.analitikaIzvoda.AnalitikaIzvoda;

import java.io.IOException;

public interface RTGSService {

    RTGS createRTGS(AnalitikaIzvoda analitika);
    RTGS exportRTGS(RTGS rtgs) throws IOException;

}
