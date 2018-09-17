package poslovnaBanka.analitikaIzvoda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalitikaIzvodaRepository extends JpaRepository<AnalitikaIzvoda, Long> {
}
