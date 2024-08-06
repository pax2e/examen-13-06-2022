package Objecten_Velden;

public class IntWaarde extends Waarde {
	
	int intwaarde;
	
	public int getIntWaarde() {
		return intwaarde;
	}
	
	public IntWaarde(int waarde) {
		this.intwaarde = waarde;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof IntWaarde w && w.getIntWaarde() == intwaarde;
	}
	
	@Override
	public int hashCode() {
		return intwaarde;
	}

}
