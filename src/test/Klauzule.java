package test;

import java.util.ArrayList;

public class Klauzule{
	String wynik; // lewa strona 
	ArrayList<String> war_list = new ArrayList(); // lista warunkow prawa strona
	int tag = 0; //oznaczenie

	public String getWynik() {
		return wynik;
	}
	public void setWynik(String wynik) {
		this.wynik = wynik;
	}
	public ArrayList<String> getWar_list() {
		return war_list;
	}
	public void setWar_list(ArrayList<String> war_list) {
		this.war_list = war_list;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	 
	
}
