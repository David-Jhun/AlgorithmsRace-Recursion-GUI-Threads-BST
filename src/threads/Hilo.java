package threads;

public class Hilo extends Thread{

	public Hilo( String nombre ) {
		super(nombre);
	}
	
	@Override
	public void run() {
		System.out.println("Hola mundo.");
	}
	
}
