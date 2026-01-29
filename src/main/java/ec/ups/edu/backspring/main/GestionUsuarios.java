package ec.ups.edu.backspring.main;

import java.util.List;
// IMPORTANTE: Ahora importamos desde .repository
import ec.ups.edu.backspring.repository.UsuarioRepository;
import ec.ups.edu.backspring.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GestionUsuarios {
    
    @Autowired
    private UsuarioRepository usuarioRepository; // Antes era usuarioDAO
    
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }
    
    public Usuario getUsuario(String uid) {
        return usuarioRepository.findById(uid).orElse(null);
    }
    
    public List<Usuario> getProgramadores() {
        // Asegúrate que en tu UsuarioRepository tengas este método definido:
        // List<Usuario> findByRol(String rol);
        return usuarioRepository.findByRol("programador"); 
    }
    
    public Usuario getUsuarioPorEmail(String email) {
        // Asegúrate que en tu UsuarioRepository tengas este método:
        // Usuario findByEmail(String email);
        return usuarioRepository.findByEmail(email);
    }
    
    @Transactional
    public void crearUsuario(Usuario usuario) throws Exception {
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new Exception("El email es obligatorio");
        }
        
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre es obligatorio");
        }
        
        if (usuario.getRol() == null || usuario.getRol().trim().isEmpty()) {
            throw new Exception("El rol es obligatorio");
        }
        
        Usuario existente = usuarioRepository.findByEmail(usuario.getEmail());
        if (existente != null) {
            throw new Exception("Ya existe un usuario con ese email");
        }
        
        usuarioRepository.save(usuario);
    }
    
    @Transactional
    public Usuario actualizarUsuario(String uid, Usuario usuario) throws Exception {
        if (uid == null || uid.trim().isEmpty()) {
            throw new Exception("Parametro Incorrecto");
        }
        
        if (usuario == null) {
            throw new Exception("Usuario requerido");
        }
        
        if (!usuarioRepository.existsById(uid)) {
            return null;
        }
        
        usuario.setUid(uid);
        return usuarioRepository.save(usuario);
    }
    
    @Transactional
    public void eliminarUsuario(String uid) throws Exception {
        if (!usuarioRepository.existsById(uid)) {
            throw new Exception("Usuario no encontrado");
        }
        usuarioRepository.deleteById(uid);
    }
}