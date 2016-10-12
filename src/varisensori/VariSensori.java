//Määritetään värisensorin toiminnot

package varisensori;

import lejos.robotics.Color;
import moottorit.Koura;
import moottorit.Nosturi;
import moottorit.Kaanto;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

public class VariSensori {
	//tunnistaa onko jäteasema auki
	private static EV3ColorSensor varisensori = new EV3ColorSensor(SensorPort.S4);

	public VariSensori() {

	}

	public static void onkoAuki() {
		boolean jatka = true;
		while (jatka) {

			switch (varisensori.getColorID()) {
	//jos vihreä niin jättää risut ja palaa alkupisteeseen
			case Color.GREEN:
				Nosturi.nosturiLaske();
				Koura.kouraAuki();
				Nosturi.nosturiNosta();
				Kaanto.puoliOikealle();
				jatka = false;
				break;
	//jos punainen niin kääntyy 270astetta, jättää risut sinne ja palaa alkuasentoon
			case Color.RED:
				Kaanto.kolmeNeljasosa();
				Nosturi.nosturiLaske();
				Koura.kouraAuki();
				Nosturi.nosturiNosta();
				Kaanto.vasemmalle();
				jatka = false;
				break;

			}

		}
	}
}
