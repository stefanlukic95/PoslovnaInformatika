package poslovnaBanka.banka;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankaRepository extends JpaRepository<Banka, Long> {
}
