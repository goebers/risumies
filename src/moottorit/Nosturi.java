//Määritetään nosturia ohjaavan moottorin toiminnot

package moottorit;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Nosturi{
	//Nosturi ylos tai alas
	private static RegulatedMotor m = new EV3LargeRegulatedMotor(MotorPort.B);

	public Nosturi() {

	}

	public static void nosturiLaske() {
	//laskee nosturin maan tasalle
		m.rotate(-1200);
		m.setSpeed(350);
	}

	public static void nosturiNosta() {
	//nostaa nosturin maasta yläasentoon
		m.rotate(1200);
		m.setSpeed(350);
	}

}