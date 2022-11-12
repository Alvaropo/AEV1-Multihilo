package clases;


/**
 * 
 * @author alvar
 *
 */
public class Procesadora{
	
	int croquetasDisponibles=100;
	public int croquetasTerminadas=0;
	public static int tope = 0;
	public static int i = 0;
	public static int hechas=0;
/**
 * 
 * @param args
 * @throws InterruptedException
 */
	public static void main(String[] args) throws InterruptedException {
		
		int cantidadJamon = Integer.parseInt(args[0]);
		int cantidadPollo = Integer.parseInt(args[1]);
		int cantidadQueso = Integer.parseInt(args[2]);
		int cantidadBacalao = Integer.parseInt(args[3]);
		int cantidadTotal = Integer.parseInt(args[4]);						//valores pasados por lanzadora args
		int prioridadJamon = Integer.parseInt(args[5]);
		int prioridadPollo = Integer.parseInt(args[6]);
		int prioridadQueso = Integer.parseInt(args[7]);
		int prioridadBacalao = Integer.parseInt(args[8]);
		
		

		System.out.println("Cantidad de croquetas para hacer: "+cantidadTotal);
		System.out.println("PROCESANDO CROQUETAS...");
		
		while (cantidadTotal!=0) {
			
			while (tope<100) {
				
			Thread jamon = new Thread(new CroquetaJamon());
			Thread queso = new Thread(new CroquetaQueso());
			Thread pollo = new Thread(new CroquetaPollo());					//hilos
			Thread bacalao = new Thread(new CroquetaBacalao());
			
			jamon.setName("Croqueta Jamon pos: "+(i+1));
			queso.setName("Croqueta Queso pos: "+(i+1));					//nombrar cada hilo
			pollo.setName("Croqueta Pollo pos: "+(i+1));
			bacalao.setName("Croqueta Bacalao pos: "+(i+1));
			
			if (cantidadJamon!=0) {											//lanzar los hilos
				tope++;
				cantidadJamon--;
				cantidadTotal--;
				jamon.setPriority(prioridadJamon);
				jamon.start();
				hechas++;
			}
			if (cantidadQueso!=0) {
				tope++;
				cantidadQueso--;
				cantidadTotal--;
				queso.setPriority(prioridadQueso);
				queso.start();
				hechas++;
			}
			if (cantidadPollo!=0) {
				tope++;
				cantidadPollo--;
				cantidadTotal--;
				pollo.setPriority(prioridadPollo);
				pollo.start();
				hechas++;
			}
			
			if (cantidadBacalao!=0) {
				tope++;
				cantidadBacalao--;
				cantidadTotal--;
				bacalao.setPriority(prioridadBacalao);
				bacalao.start();
				hechas++;
			}

			i++;
			
			if (cantidadTotal==0) {																	//terminar la ejecucion del bucle cuando llegue a 0
				break;
			}
		
			}
			
			Thread.sleep(3000);
			System.out.println("--- COOL DOWN ---  (3s)"+" Espacios libres: "+(100-tope));			//Actualizacion de 3s
		}
	}
}
/**
 * 
 * @author alvar
 *
 */
class CroquetaJamon implements Runnable {															//Clase para cada croqueta con su tiempo de creacion
	@Override
	synchronized public void run() {
		Procesadora p =new Procesadora();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String pos = Thread.currentThread().getName();
		CrearCroqueta(pos);

		p.tope--;
	}
	 public void CrearCroqueta(String pos) {
		System.out.println(pos);
	}
}
/**
 * 
 * @author alvar
 *
 */
class CroquetaPollo implements Runnable {
	@Override
	synchronized public void run() {
		Procesadora p = new Procesadora();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String pos = Thread.currentThread().getName();
		CrearCroqueta(pos);
		p.tope--;
	}
	public void CrearCroqueta(String pos) {
		System.out.println(pos);
	}
}
/**
 * 
 * @author alvar
 *
 */
class CroquetaQueso implements Runnable {
	@Override
	synchronized public void run() {
		Procesadora p =new Procesadora();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String pos = Thread.currentThread().getName();
		CrearCroqueta(pos);

		p.tope--;
	}
	 public void CrearCroqueta(String pos) {
		System.out.println(pos);
	}
}
/**
 * 
 * @author alvar
 *
 */
class CroquetaBacalao implements Runnable {
	@Override
	synchronized public void run() {
		Procesadora p =new Procesadora();

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String pos = Thread.currentThread().getName();
		CrearCroqueta(pos);

		p.tope--;
	}
	 public void CrearCroqueta(String pos) {
		System.out.println(pos);
	}
}
