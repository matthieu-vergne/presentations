package fr.vergne.generics.genericMethod.notBounded;

import java.util.HashMap;
import java.util.Map;

public class C09_SharedGenericsThroughArgument {
	static class Key<T> {
	}

	/*
	 * Utilisation d'un élément commun Key<T> pour aligner les types de put() et
	 * get(). Comme le champs est privé, on sait qu'on est le seul à l'utiliser.
	 * Comme on sait qu'on n'insère que des valeurs du même type que la clé dans
	 * put(), on peut caster sereinement dans get().
	 */
	static class HeterogeneousMap {
		private Map<Object, Object> container = new HashMap<>();

		/**
		 * Cas isolé équivalent :
		 * {@link C03_SeveralArguments#fromXT(fr.vergne.generics.X, Object)}
		 */
		<T> void put(Key<T> key, T value) {
			container.put(key, value);
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
		HeterogeneousMap map = new HeterogeneousMap();

		// put/get d'un entier
		Key<Integer> k1 = new Key<>();
		map.put(k1, 123);
		Integer integer = map.get(k1);
		System.out.println(integer);

		// put/get d'une String
		Key<String> k2 = new Key<>();
		map.put(k2, "foo");
		String string = map.get(k2);
		System.out.println(string);

		// Ne compile pas :
		// map.put(k2, 123);
		// integer = map.get(k2);
		// map.put(k1, "foo");
		// string = map.get(k1);
	}
}
