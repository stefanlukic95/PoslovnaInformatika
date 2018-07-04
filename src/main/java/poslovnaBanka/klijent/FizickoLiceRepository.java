package poslovnaBanka.klijent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FizickoLiceRepository extends JpaRepository<FizickoLice, Long> {
}
