package risumies;
import kaukosaadin.Kaukosaadin;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;



public class RisumiesMain {

	public static void main(String[] args) {
	//Käynnistää kaukosäätimen
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);
		Kaukosaadin checkerThread = new Kaukosaadin(irSensor);
		checkerThread.run();
		
		
		
	}
}