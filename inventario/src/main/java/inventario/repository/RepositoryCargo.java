package inventario.repository;

import inventario.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface RepositoryCargo extends JpaRepository<Cargo, Integer> {
    boolean existsById(int id);

    Optional<Cargo> findById(int id);

}
