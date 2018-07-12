package poslovnaBanka.valute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValuteRepository extends JpaRepository<Valute, Long> {
}
