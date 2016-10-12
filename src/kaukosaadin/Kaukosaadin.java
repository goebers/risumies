//Määritetään kaukosäätimen toiminnot

package kaukosaadin;

import lejos.hardware.Button;
import lejos.hardware.sensor.EV3IRSensor;
import moottorit.Koura;
import moottorit.Nosturi;
import moottorit.Kaanto;
import varisensori.VariSensori;
	

public class Kaukosaadin extends Thread {
	//kaukosäätimen näppäimiä painettaessa suorittaa joko koko ohjelman tai moottorit kerrallaan
	private EV3IRSensor infraredSensor;

	public Kaukosaadin(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
	}

	public void run() {
		int kouraPainallus = 0;
		int nostoPainallus = 0;
		while (!Button.ENTER.isDown()) {
			int remoteCommand = infraredSensor.getRemoteCommand(0);
			if (remoteCommand == 1) {
				//vasen ylänappi käynnistää koko ohjelman, jossa kone poimii risut, vie jäteasemalle ja tarkistaa onko se 
				//auki ja toimii värisensoriluokan mukaisesti.

				Nosturi.nosturiLaske();
				Koura.kouraKiinni();
				Nosturi.nosturiNosta();
				Kaanto.puoliVasemmalle();
				VariSensori.onkoAuki();
			}

			if (remoteCommand == 2) {
				//vasenta alanappia painatteassa koura menee ensin kiinni ja toisen kerran painettaessa aukaisee kouran
				if (kouraPainallus % 2 == 0) {
					Koura.kouraKiinni();
				} else {
					Koura.kouraAuki();
				}
				kouraPainallus++;
			}

			if (remoteCommand == 3) {
				//oikeaa ylänappia painettaessa nosturi joko laskee tai nostaa kouran.
				if (nostoPainallus % 2 == 0) {
					Nosturi.nosturiLaske();
				} else {
					Nosturi.nosturiNosta();
				}
				nostoPainallus++;
			}
			
			if (remoteCommand == 4) {
				//oikeaa alanappia painettaessa robotti kiertää 360 astetta ympäri
				Kaanto.kolmeKuuskyt();
				
			}
		}
	}
}
