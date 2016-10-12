//Määritetään kouraa aukovan ja sulkevan moottori

package moottorit;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Koura {
	//koura kiinni tai auki
	private static RegulatedMotor m = new EV3LargeRegulatedMotor(MotorPort.A);

	public Koura() {

	}

	public static void kouraKiinni() {
	//sulkee kouran
		m.setSpeed(1000);
		m.rotate(-999);
	}

	public static void kouraAuki() {
	//avaa kouran
		m.setSpeed(1000);
		m.rotate(999);

	}

}