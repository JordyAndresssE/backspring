package ec.ups.edu.backspring.repository;

import ec.ups.edu.backspring.modelo.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, String> {

    // 1. insert, update, read, delete, getAll -> YA INCLUIDOS

    // 2. Tu método: getByProgramador(String idProgramador)
    // Spring traduce automáticamente "findByIdProgramador" a tu query WHERE p.idProgramador = ...
    List<Proyecto> findByIdProgramador(String idProgramador);

    // 3. Tu método: getByTipo(String tipo)
    List<Proyecto> findByTipo(String tipo);
}