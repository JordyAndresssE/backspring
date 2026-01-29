package ec.ups.edu.backspring.main;

import java.util.List;
// IMPORTANTE: Imports actualizados a Repository
import ec.ups.edu.backspring.repository.ProyectoRepository;
import ec.ups.edu.backspring.repository.UsuarioRepository;
import ec.ups.edu.backspring.modelo.Proyecto;
import ec.ups.edu.backspring.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GestionProyectos {
    
    @Autowired
    private ProyectoRepository proyectoRepository; // Antes proyectoDAO
    
    @Autowired
    private UsuarioRepository usuarioRepository; // Antes usuarioDAO
    
    public List<Proyecto> getProyectos() {
        return proyectoRepository.findAll();
    }
    
    public Proyecto getProyecto(String id) {
        return proyectoRepository.findById(id).orElse(null);
    }
    
    public List<Proyecto> getProyectosPorProgramador(String idProgramador) {
        // Asegúrate de tener findByIdProgramador(String id) en tu repo
        return proyectoRepository.findByIdProgramador(idProgramador);
    }
    
    public List<Proyecto> getProyectosPorTipo(String tipo) {
        // Asegúrate de tener findByTipo(String tipo) en tu repo
        return proyectoRepository.findByTipo(tipo);
    }
    
    @Transactional
    public void crearProyecto(Proyecto proyecto) throws Exception {
        if (proyecto.getNombre() == null || proyecto.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del proyecto es obligatorio");
        }
        
        if (proyecto.getIdProgramador() == null || proyecto.getIdProgramador().trim().isEmpty()) {
            throw new Exception("El ID del programador es obligatorio");
        }
        
        if (proyecto.getTipo() == null || proyecto.getTipo().trim().isEmpty()) {
            throw new Exception("El tipo de proyecto es obligatorio");
        }
        
        Usuario programador = usuarioRepository.findById(proyecto.getIdProgramador()).orElse(null);
        
        if (programador == null) {
            throw new Exception("Programador no encontrado");
        }
        
        if (!programador.getRol().equals("programador")) {
            throw new Exception("El usuario no es un programador");
        }
        
        proyectoRepository.save(proyecto);
    }
    
    @Transactional
    public Proyecto actualizarProyecto(String id, Proyecto proyecto) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new Exception("Parametro Incorrecto");
        }
        
        if (proyecto == null) {
            throw new Exception("Proyecto requerido");
        }
        
        if (!proyectoRepository.existsById(id)) {
            return null;
        }
        
        proyecto.setId(id);
        return proyectoRepository.save(proyecto);
    }
    
    @Transactional
    public void eliminarProyecto(String id) throws Exception {
        if (!proyectoRepository.existsById(id)) {
            throw new Exception("Proyecto no encontrado");
        }
        proyectoRepository.deleteById(id);
    }
}