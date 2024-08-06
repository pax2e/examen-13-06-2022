package Objecten_Velden;

import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class JavaObject extends Waarde {
	
	/**
	 * @invar | velden != null
	 * @invar | velden.keySet().stream().allMatch(n -> n != null && getVelden().get(n) != null && getVelden().get(n).getWaarde() != null && getVelden().get(n).getObject() == this)
	 * @representationObject
	 * @peerObjects
	 */
	HashMap<String,Veld> velden; 	//'gewoon de velden'


	/**
	 * @representationObject
	 * @peerObjects
	 */
	HashSet<Veld> verwijzendeVelden; 	//'gewoon de velden'
	
	/**
	 * @post | getVelden().isEmpty()
	 * @post | getVerwijzendeVelden().isEmpty()
	 */
	public JavaObject() {
		this.velden = new HashMap<String, Veld>();
		this.verwijzendeVelden = new HashSet<Veld>();
	};

	
	/**
	 * @peerObjects | result.values()
	 * @creates | result
	 * @post | result != null
	 */
	public Map<String, Veld> getVelden() {
		return Map.copyOf(velden);
	} //string = veldnamen, veld veldzelf
	
	/**
	 * @peerObjects
	 * @creates | result
	 * @post | result != null
	 */
	public Set<Veld> getVerwijzendeVelden() {
		return Set.copyOf(verwijzendeVelden);
	} //string = veldnamen, veld veldzelf

	@Override
	public boolean equals(Object obj) {
		return this == obj;
	}
	
	public Iterator<JavaObject> uitw_iterator() {
		return new Iterator<JavaObject>() {
			JavaObject object = JavaObject.this;
			
			@Override
			public boolean hasNext() {
				return object != null;
			}
			
	        @Override
	        public JavaObject next() {
	            JavaObject result = object;
	            if (object.velden.containsKey("next") && object.velden.get("next").waarde instanceof JavaObject o)
	                object = o;
	            else
	                object = null;
	            return result;
	        }
	    
		};
	}
	
	public void forEachBereikbaarObject(Consumer<? super JavaObject> consumer) {
		consumer.accept(this);
		for (Veld veld : velden.values()) {
			if (veld.waarde instanceof JavaObject o)
				o.forEachBereikbaarObject(consumer);
			}
		}
		
	public Stream<String> getNamenStream() {
		return verwijzendeVelden.stream().flatMap(v -> v.object.velden.keySet().stream());
	}

}
