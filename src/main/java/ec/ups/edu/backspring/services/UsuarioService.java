package ec.ups.edu.backspring.services;

import ec.ups.edu.backspring.main.GestionUsuarios; // Importamos la Gestión, NO el repo directo
import ec.ups.edu.backspring.modelo.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
@Tag(name = "Usuarios", description = "API para gestión de usuarios y programadores")
public class UsuarioService {

    @Autowired
    private GestionUsuarios gestionUsuarios; // Inyectamos la clase de negocio

    @GetMapping("/test")
    public String test() {
        return "Conexión Exitosa: API Spring Boot Usuarios";
    }

    @Operation(summary = "Listar todos los usuarios", description = "Obtiene la lista completa de usuarios registrados")
    @GetMapping
    public List<Usuario> getListaUsuarios() {
        return gestionUsuarios.getUsuarios();
    }

    // Listar solo programadores
    @GetMapping("/programadores")
    public List<Usuario> getProgramadores() {
        return gestionUsuarios.getProgramadores();
    }

    // Buscar por ID (UID)
    @GetMapping("/{uid}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable String uid) {
        Usuario usuario = gestionUsuarios.getUsuario(uid);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear Usuario (Con manejo de errores de validación)
    @PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {
        try {
            gestionUsuarios.crearUsuario(usuario);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Actualizar Usuario
    @PutMapping("/{uid}")
    public ResponseEntity<?> updateUsuario(@PathVariable String uid, @RequestBody Usuario usuario) {
        try {
            Usuario actualizado = gestionUsuarios.actualizarUsuario(uid, usuario);
            if (actualizado != null) {
                return ResponseEntity.ok(actualizado);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}