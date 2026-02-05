package ec.ups.edu.backspring.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_USUARIO")
public class Usuario {
	
	@Id
	@Column(name = "usr_uid", length = 100)
	private String uid;
	
	@Column(name = "usr_email", nullable = false, unique = true, length = 100)
	private String email;
	
	@Column(name = "usr_nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "usr_foto_perfil", length = 500)
	private String fotoPerfil;
	
	@Column(name = "usr_rol", nullable = false, length = 20)
    private String rol;
    
    // ✅ NUEVO CAMPO: Teléfono para notificaciones WhatsApp
    @Column(name = "usr_telefono", length = 20)
    private String telefono;
    
    // Campos específicos para programadores
	
    @Column(name = "usr_especialidad", length = 100)
    private String especialidad;
    
    @Column(name = "usr_descripcion", length = 1000)
    private String descripcion;
    
    @Column(name = "usr_tecnologias", length = 500)
    private String tecnologias;
    
    // Redes Sociales
    @Column(name = "usr_linkedin", length = 200)
    private String linkedin;
    
    @Column(name = "usr_github", length = 200)
    private String github;
    
    @Column(name = "usr_twitter", length = 200)
    private String twitter;
    
    @Column(name = "usr_sitio_web", length = 200)
    private String sitioWeb;
    
    // Disponibilidad
    
    @Column(name = "usr_horario_lunes", length = 50)
    private String horarioLunes;
    
    @Column(name = "usr_horario_martes", length = 50)
    private String horarioMartes;
    
    @Column(name = "usr_horario_miercoles", length = 50)
    private String horarioMiercoles;
    
    @Column(name = "usr_horario_jueves", length = 50)
    private String horarioJueves;
    
    @Column(name = "usr_horario_viernes", length = 50)
    private String horarioViernes;
    
    @Column(name = "usr_horario_sabado", length = 50)
    private String horarioSabado;
    
    @Column(name = "usr_horario_domingo", length = 50)
    private String horarioDomingo;
    
    // Constructores
    public Usuario() {
    }

    // Getters y Setters
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // ✅ NUEVO: Getter y Setter para telefono
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getHorarioLunes() {
        return horarioLunes;
    }

    public void setHorarioLunes(String horarioLunes) {
        this.horarioLunes = horarioLunes;
    }

    public String getHorarioMartes() {
        return horarioMartes;
    }

    public void setHorarioMartes(String horarioMartes) {
        this.horarioMartes = horarioMartes;
    }

    public String getHorarioMiercoles() {
        return horarioMiercoles;
    }

    public void setHorarioMiercoles(String horarioMiercoles) {
        this.horarioMiercoles = horarioMiercoles;
    }

    public String getHorarioJueves() {
        return horarioJueves;
    }

    public void setHorarioJueves(String horarioJueves) {
        this.horarioJueves = horarioJueves;
    }

    public String getHorarioViernes() {
        return horarioViernes;
    }

    public void setHorarioViernes(String horarioViernes) {
        this.horarioViernes = horarioViernes;
    }

    public String getHorarioSabado() {
        return horarioSabado;
    }

    public void setHorarioSabado(String horarioSabado) {
        this.horarioSabado = horarioSabado;
    }

    public String getHorarioDomingo() {
        return horarioDomingo;
    }

    public void setHorarioDomingo(String horarioDomingo) {
        this.horarioDomingo = horarioDomingo;
    }

    @Override
    public String toString() {
        return "Usuario [uid=" + uid + ", email=" + email + ", nombre=" + nombre + ", telefono=" + telefono + ", rol=" + rol + "]";
    }
}