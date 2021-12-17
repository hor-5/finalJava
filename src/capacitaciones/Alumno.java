package capacitaciones;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Alumno extends Usuario implements UsuarioGeneral{
	
	private ArrayList<Certificado> certificados;
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public Alumno() {
		
	}
	
	
	public Alumno(int id, String nombre_usuario, String email, int telefono, String clave, String nombre,
			String apellido) {
		super(id, nombre_usuario, email, telefono, clave,nombre,apellido);

				
	}

	public Alumno(int id, String nombre_usuario, String email, int telefono, String clave, String nombre,
			String apellido, ArrayList<Curso> cursos,ArrayList<Certificado> certificados) {
		super(id, nombre_usuario, email, telefono, clave,nombre,apellido);
	
		this.cursos = cursos;
		this.certificados = certificados;
	}
	
	@Override
	public void accion(int index) {
		Curso curso = getCursos().get(index-1);
		System.out.println("Cursando " + curso.getTitulo()+".");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nClase finalizada.");
		
	}

	public void agregarCertificado(Certificado c){		
		certificados.add(c);
	}	
	
	public ArrayList<Certificado> getCertificados() {
		return certificados;
	}
	
	public void setCertificados(ArrayList<Certificado> certificados) {
		this.certificados = certificados;
	}
	


	public void agregarCurso(Curso c){		
		cursos.add(c);
	}	


	public ArrayList<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
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
	
	public void imprimirCertificados(){
		int i = 1;
		for(Certificado certificado:certificados){	        			
			System.out.println("Id del certificado: "+certificado.getId() +"- Curso: "+ certificado.getCurso().getTitulo());
			System.out.println( "*"+certificado.getAlumno().getNombre()+ " " + certificado.getAlumno().getApellido()+"*."+ "Finalizó con exito el curso de *" + certificado.getCurso().getTitulo()+"*");
			
			System.out.println("de nivel "+certificado.getCurso().getDificultad()+ " el dia *"+ certificado.getFechaEmision() +"*.");			
			
			
		}
	}
	
	public Curso encontrarCurso(int index){
		Curso c = cursos.get(index);
		return c;
	}	


	@Override
	public boolean login() {
		
			System.out.println("Ingrese su usuario");
			String user = pedirString();
			if(user.toLowerCase().equals(nombre_usuario.toLowerCase())){
				System.out.println("Ingrese su contraseña");
				String pass = pedirString();
				if(pass.equals(clave)){
					System.out.println("LOGUEO EXITOSO!");
					return true;
				}else {
					System.out.println("clave Incorrecta!");
					return false;
				}
			}else {
				System.out.println("Usuario Incorrecto!");
				return false;
			}
	
	}


	@Override
	public void editarInfo() {
		System.out.println("\nTu perfil");
		System.out.println(nombre + " " + apellido);
		System.out.println("DNI del alumno: "+ id);
		System.out.println("Seleccione una opción");
		System.out.println("A- Actualizar nombre de usuario");
		System.out.println("B- cambiar contraseña");
		String opt= pedirString().toLowerCase();
		while (!opt.equals("a") && !opt.equals("b")) {
			System.out.println("Opción incorrecta");
			System.out.println("Seleccione una opción");
			System.out.println("A- cambiar contraseña");
			System.out.println("B- Actualizar nombre de usuario");
			opt= pedirString().toLowerCase();
		}
		if(opt.equals("a")) {
			System.out.println("Su nombre de usuario actual es "+ nombre_usuario);
			System.out.println("Ingrese su usuario nuevo");
			String user = pedirString();
			this.setNombre_usuario(user);
			System.out.println("Usuario actualizado a " + nombre_usuario + " correctamente!");
		}else {
			System.out.println("Por seguridad debe ingrese su contraseña actual");
			String passActual = pedirString();
			if(passActual.equals(clave)) {
				System.out.println("Genial. Ahora ingrese la nueva contraseña");
				String passNueva = pedirString();
				System.out.println("Repita la contraseña nueva (Teniendo en cuenta mayusculas y minusculas)");
				String repNueva = pedirString();
				if(passNueva.equals(repNueva)){
					this.setClave(passNueva);
					System.out.println("Contraseña cambiada satisfactoriamente!");					
				}else {
					System.out.println("Las contraseñas no coinciden");
				}
			}else {
				System.out.println("La contraseña ingresada no coincide con la actual!!");							
				System.out.println("\nSe le enviará un email a " + email + " para reestablecer la contraseña.");
			
			}
			
	
		}
		
	}
	
	@Override
	public String pedirString() {
		Scanner teclado = new Scanner (System.in);
		String texto;
		texto = teclado.nextLine();
		
		return texto;
	}
	
	
	
	@Override
	public String toString() {
		return "Alumno [certificados=" + certificados + ", cursos=" + cursos + ", id=" + id + ", nombre_usuario="
				+ nombre_usuario + ", email=" + email + ", telefono=" + telefono + ", clave=" + clave + ", nombre="
				+ nombre + ", apellido=" + apellido + "]";
	}






		

	

	
	
	
}
