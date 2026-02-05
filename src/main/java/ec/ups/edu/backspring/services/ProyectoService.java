package ec.ups.edu.backspring.services;

import ec.ups.edu.backspring.main.GestionProyectos; // Importamos la Gestión
import ec.ups.edu.backspring.modelo.Proyecto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin(origins = "*")
@Tag(name = "Proyectos", description = "API para gestión de proyectos de programadores")
public class ProyectoService {

    @Autowired
    private GestionProyectos gestionProyectos; // Inyectamos la clase de negocio

    @Operation(summary = "Listar todos los proyectos", description = "Obtiene la lista completa de proyectos")
    @GetMapping
    public List<Proyecto> getListaProyectos() {
        return gestionProyectos.getProyectos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> getProyecto(@PathVariable String id) {
        Proyecto proyecto = gestionProyectos.getProyecto(id);
        if (proyecto != null) {
            return ResponseEntity.ok(proyecto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar proyectos de un programador específico
    @GetMapping("/programador/{idProgramador}")
    public List<Proyecto> getProyectosPorProgramador(@PathVariable String idProgramador) {
        return gestionProyectos.getProyectosPorProgramador(idProgramador);
    }
    
    // Buscar proyectos por TIPO
    @GetMapping("/tipo/{tipo}")
    public List<Proyecto> getProyectosPorTipo(@PathVariable String tipo) {
        return gestionProyectos.getProyectosPorTipo(tipo);
    }

    // Crear Proyecto
    @PostMapping
    public ResponseEntity<?> createProyecto(@RequestBody Proyecto proyecto) {
        try {
            gestionProyectos.crearProyecto(proyecto);
            return ResponseEntity.ok(proyecto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Actualizar Proyecto
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProyecto(@PathVariable String id, @RequestBody Proyecto proyecto) {
        try {
            Proyecto actualizado = gestionProyectos.actualizarProyecto(id, proyecto);
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