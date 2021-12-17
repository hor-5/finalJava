package capacitaciones;

import java.util.Scanner;

public class Administrativo extends Usuario implements UsuarioGeneral{	

	
	public Administrativo(){
		
	}
	
	public Administrativo(int id, String nombre_usuario,String clave){
		super(id, nombre_usuario, clave);
	}	
	
	public Administrativo(int id, String nombre_usuario, String email, int telefono, String clave, String nombre,
			String apellido) {
		super(id, nombre_usuario, email, telefono, clave,nombre,apellido);
	}
	
	@Override
	public void accion(int index) {		
		System.out.println("Revisando tramites y papeles...");
		try {
			Thread.sleep(1000);
			System.out.println("\n...");
			Thread.sleep(1700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nTodo en orden.");
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
		System.out.println("DNI del administrador: "+ id);
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
		return "Administrativo [nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", nombre_usuario="
				+ nombre_usuario + ", email=" + email + ", telefono=" + telefono + ", clave=" + clave + "]";
	}


	
	
	
}
