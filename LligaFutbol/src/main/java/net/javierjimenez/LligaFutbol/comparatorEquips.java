package net.javierjimenez.LligaFutbol;

import java.util.Comparator;

public class comparatorEquips implements Comparator<Equip> {

	public int compare(Equip a, Equip b) {

		int total1 = a.getPunts();
		int total2 = b.getPunts();

		if (total1 > total2) {
			return 1;
		} else if (total1 < total2) {
			return -1;
		}
		return 0;
	}
}
