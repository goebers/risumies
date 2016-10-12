//Määritetään 360 astetta kääntyvän moottorin toiminnot

package moottorit;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Kaanto {
	
	//määrittää käännöksen suunnan, nopeuden ja asteen.

	private static RegulatedMotor m = new EV3LargeRegulatedMotor(MotorPort.D);

	public Kaanto() {

	}

	public static void vasemmalle() {
	// kääntää 90 astetta vasemmalle
		m.setSpeed(750);
		m.rotate(900);
	}

	public static void oikealle() {
	//kääntää 90 astetta oikealle
		m.setSpeed(750);
		m.rotate(-900);

	}

	public static void puoliVasemmalle() {
	//kääntää 180 astetta vasemmalle
		m.setSpeed(750);
		m.rotate(1800);
	}

	public static void puoliOikealle() {
	//kääntää 180 astetta oikealle
		m.setSpeed(750);
		m.rotate(-1800);
	}

	public static void kolmeNeljasosa() {
		//kääntää 270 astetta oikealle
		m.setSpeed(750);
		m.rotate(-2700);
	}

	public static void kolmeKuuskyt() {
		//kääntää 360 astetta oikealle
		m.setSpeed(750);
		m.rotate(-3600);
		
	}
}