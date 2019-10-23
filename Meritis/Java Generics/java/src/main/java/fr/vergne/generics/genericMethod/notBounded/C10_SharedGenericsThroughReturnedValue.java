package fr.vergne.generics.genericMethod.notBounded;

import java.util.HashMap;
import java.util.Map;

public class C10_SharedGenericsThroughReturnedValue {
	static class Key<T> {
	}

	/*
	 * Utilisation d'un élément généré Key<T> lors du add() pour permettre la
	 * récupération typée lors du get(). Comme le champs est privé, on sait qu'on
	 * est le seul à l'utiliser. Comme on sait qu'on n'insère que des valeurs du
	 * même type que la clé dans put(), on peut caster sereinement dans get().
	 */
	static class HeterogeneousContainer {
		private Map<Object, Object> container = new HashMap<>();

		/**
		 * Cas isolé équivalent :
		 * {@link C05_ReturnAndArgument#fromTtoX(Object)}
		 */
		<T> Key<T> add(T value) {
			Key<T> key = new Key<>();
			container.put(key, value);
			return key;
		}

		/**
		 * Cas isolé équivalent :
		 * {@link C05_ReturnAndArgument#fromXtoT(fr.vergne.generics.X)}
		 */
		@SuppressWarnings("unchecked")
		<T> T get(Key<T> key) {
			return (T) container.get(key);
		}
	}

	public static void main(String[] args) {
		HeterogeneousContainer map = new HeterogeneousContainer();

		// add/get d'un entier
		Key<Integer> k1 = map.add(123);
		Integer integer = map.get(k1);
		System.out.println(integer);

		// add/get d'une String
		Key<String> k2 = map.add("foo");
		String string = map.get(k2);
		System.out.println(string);

		// Ne compile pas :
		// integer = map.get(k2);
		// string = map.get(k1);
	}
}
