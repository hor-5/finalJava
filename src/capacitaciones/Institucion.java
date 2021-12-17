package capacitaciones;

import java.util.ArrayList;

public class Institucion {
	
	private String nombre;
	private String email;
	private String telefono;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	
	public Institucion(){
		
	}
	public Institucion(String nombre, String email, String telefono){
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario usuario) {
		usuarios.add(usuario);		
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Curso curso) {		
		cursos.add(curso);
	}
	

	public void imprimirCursos(){
		int i = 1;
		for(Curso curso:cursos){	        			
			System.out.println(i +"- "+ curso.getTitulo());
			System.out.println("nivel : "+curso.getDificultad()+".");
			System.out.println("tematica: " + curso.getTematica()+".");
			System.out.println("descripcion: "+ curso.getDescripcion()+".");
			i++;
		}
	}
	
	public void imprimirAlumnos(){
		int i = 1;
		boolean encontrado= false;
		for(Usuario usuario:usuarios){	        			
			if(usuario instanceof Alumno) {
				encontrado= true;
				System.out.println(i +"- "+ usuario.getNombre() + " " + usuario.getApellido());
				System.out.println("cursos :");
				((Alumno) usuario).imprimirCursos();
				System.out.println("certificados: ");
				((Alumno) usuario).imprimirCertificados();
				System.out.println("contacto: " + usuario.getTelefono() + " " + usuario.getEmail());
				i++;
			}
		}
		if(!encontrado){
			System.out.println("\nTodavia no hay alumnos cargados en el sistema.");
		}
	}
	
	public void imprimirDocentes(){
		int i = 1;
		boolean encontrado= false;
		for(Usuario usuario:usuarios){	        			
			if(usuario instanceof Docente) {
				encontrado = true;
				System.out.println(i +"- "+ usuario.getNombre() + " " + usuario.getApellido());
				System.out.println("cursos :" );
				((Docente) usuario).imprimirCursos();
				System.out.println("especializacion: " + ((Docente) usuario).getEspecializacion());
				System.out.println("contacto: " + usuario.getTelefono() + " " +usuario.getEmail());
				i++;
			}
		}
		if(!encontrado){
			System.out.println("\nTodavia no hay docentes cargados en el sistema.");
		}
	}
	
	public Alumno encontrarAlumno(int id){		
		for(Usuario usuario:usuarios){	   
			if(usuario instanceof Alumno){
				if(id == usuario.getId()) {				
					return (Alumno) usuario;				
				}	
			}
	
		}		
		return null;		
	}
	
	public Docente encontrarDocente(int id){		
		for(Usuario usuario:usuarios){	   
			if(usuario instanceof Docente) {
				if(id == usuario.getId()) {				
					return (Docente) usuario;				
				}		
		
			}
		}		
		return null;
	}
	
	public Administrativo encontrarAdministrativo(int id){		
		for(Usuario usuario:usuarios){	   
			if(usuario instanceof Administrativo) {
				if(id == usuario.getId()) {				
					return (Administrativo) usuario;				
				}	
			}
	
		}		
		return null;
	}
	@Override
	public String toString() {
		return "Institucion [nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", usuarios="
				+ usuarios + ", cursos=" + cursos + "]";
	}




	
	

}
