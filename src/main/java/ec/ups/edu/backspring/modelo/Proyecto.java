package ec.ups.edu.backspring.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_PROYECTO")
public class Proyecto {
	
	@Id
	@Column(name = "pro_id", length = 50)
	private String id;
	
	@Column(name = "pro_id_programador", length = 50)
	private String idProgramador;
	
	@Column(name = "pro_nombre", length = 100)
	private String nombre;
	
	@Column(name = "pro_descripcion", length = 1000)
	private String descripcion;
	
	@Column(name = "pro_tipo", length = 20)
	private String tipo;
	
	@Column(name = "pro_participacion", length = 50)
	private String participacion;
	
	@Column(name = "pro_tecnologias", length = 500)
	private String tecnologias;
	
	@Column(name = "pro_repo_url", length = 200)
	private String repoUrl;
	
	@Column(name = "pro_demo_url", length = 200)
	private String demoUrl;
	
	@Column(name = "pro_imagen_url", length = 200)
	private String imagenUrl;
	
	// Constructores, getters y setters
	
	public Proyecto() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdProgramador() {
		return idProgramador;
	}

	public void setIdProgramador(String idProgramador) {
		this.idProgramador = idProgramador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getParticipacion() {
		return participacion;
	}

	public void setParticipacion(String participacion) {
		this.participacion = participacion;
	}

	public String getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(String tecnologias) {
		this.tecnologias = tecnologias;
	}

	public String getRepoUrl() {
		return repoUrl;
	}

	public void setRepoUrl(String repoUrl) {
		this.repoUrl = repoUrl;
	}

	public String getDemoUrl() {
		return demoUrl;
	}

	public void setDemoUrl(String demoUrl) {
		this.demoUrl = demoUrl;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
	
	@Override
    public String toString() {
        return "Proyecto [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", idProgramador=" + idProgramador + "]";
    }
}