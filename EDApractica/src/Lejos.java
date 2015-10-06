
import lejos.nxt.BasicMotor;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.Button;

/** Clase que hereda de BasicMotor */
public class Lejos extends BasicMotor {
	
	/** Motor A del Lego */
	public static NXTRegulatedMotor A;
	/** Motor B del Lego */
	public static NXTRegulatedMotor B;
	/** Motor C del Lego */
	public static NXTRegulatedMotor C;
	/** Se crea una instancia del sensor de sonido y se le manda el puerto en donde está localizado */
	public static UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S1);
	/** Variable booleana para terminar o iniciar el ciclo cuando se requiera */
	public static boolean verdad = true;
	
	/**
	 * Método principal del programa.
	 * @param args
	 */
	public static void main (String[] args) {
		//Velocidad en el motor A.
	    Motor.A.setSpeed(300);
	    //Velocidad en el motor B.
	    Motor.B.setSpeed(50);
	    //Velocidad en el motor C.
	    Motor.C.setSpeed(300);
	    //El motor B retrocede.
	    Motor.B.backward();
	    //El motor C avanza.
	    Motor.C.forward();
	    //El motor A avanza.
	    Motor.A.forward();
	    /** Ciclo para estar preguntando constantemente si hay un muro al frente */
	    while (verdad){
	    if (sensor.getRange() < 50){
	    	//El motor A se detiene.
	    	Motor.A.stop();
	    	//El motor C se detiene.
	    	Motor.C.stop();
	    	//El motor B se detiene.
	    	Motor.B.stop();
	    	//Se cambia la velocidad del motor B.
	    	Motor.B.setSpeed(1000);
	    	//El motor B avanza.
	    	Motor.B.forward();
	    	//El motor A retrocede.
	    	Motor.A.backward();
	    	//El motor C retrocede.
	    	Motor.C.backward();
	    	//Se muestra el mensaje
	    	System.out.print("Objeto Depositado");
	    	//Fin del ciclo.
	    	verdad = false;
	    }
	    }
	    //Para finalizar el programa en algún punto.
	    Button.waitForAnyPress();
}
}
	