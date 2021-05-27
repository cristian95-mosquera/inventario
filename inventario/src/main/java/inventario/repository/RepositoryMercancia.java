package inventario.repository;

import inventario.entity.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface RepositoryMercancia extends JpaRepository<Mercancia, Integer> {

    Optional<Mercancia> findByNombreProducto(String nombreProducto);

    boolean existsByNombreProducto(String nombreProducto);

    Optional<Mercancia> findById(int id);

}
