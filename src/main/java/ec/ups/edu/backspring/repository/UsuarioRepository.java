package ec.ups.edu.backspring.repository;

import ec.ups.edu.backspring.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    // 1. insert(), update(), delete(), read(String uid), getAll() 
    // YA VIENEN INCLUIDOS en JpaRepository. No hace falta escribirlos.
    // save() sirve para insert/update.
    // findById() sirve para read.
    // findAll() sirve para getAll.

    // 2. Tu método: getProgramadores()
    // Opción A: Usando palabras clave "magicas" de Spring (Más fácil)
    List<Usuario> findByRol(String rol); 
    // (Luego llamas a usuarioDAO.findByRol("programador"))

    // Opción B: Si quieres escribir el JPQL a mano como en tu proyecto original
    @Query("SELECT u FROM Usuario u WHERE u.rol = 'programador'")
    List<Usuario> getProgramadores();

    // 3. Tu método: findByEmail(String email)
    Usuario findByEmail(String email);
}