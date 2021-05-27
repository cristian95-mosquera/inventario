package inventario.repository;

import inventario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {

    boolean existsById(int id);

    Optional<Usuario> findById(int id);

}
