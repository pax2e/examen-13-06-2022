package Objecten_Velden;

import logicalcollections.*;


/**
 * @invar | getWaarde() != null
 * @invar | getNaam() != null
 * @invar | getObject() != null
 */
public class Veld {
	/**
	 * @invar | waarde != null
	 * @invar | naam != null
	 * @invar | object != null
	 */
	Waarde waarde;	//ofwel een int ofwel een obj
	
	String naam;
	
	/**
	 * @peerObject
	 */
	JavaObject object;
	 
	/**
	 * @peerObject
	 * @throws IllegalArgumentException | initial_waarde == null
	 * @throws IllegalArgumentException | initial_naam == null
	 * @throws IllegalArgumentException | initial_obj == null
	 */
	public Veld(Waarde initial_waarde, String initial_naam, JavaObject initial_obj) {
		this.waarde = initial_waarde;
		this.naam = initial_naam;
		this.object = initial_obj;
		
		initial_obj.velden.put(naam,this);
		
	}
	
	/**
	 * @pre | new_waarde != null
	 * @post | getWaarde() == new_waarde
	 */
	public void setWaarde(Waarde new_waarde) {
		this.waarde = new_waarde;
	}
	
	/**
	 * @post | result != null
	 */	
	public Waarde getWaarde() {
		return waarde;
	}
	
	/**
	 * @post | result != null
	 */	
	public String getNaam() {
		return naam;
	}
	
	/**
	 * @post | result != null
	 */
	public JavaObject getObject() {
		return object;
	}

}
