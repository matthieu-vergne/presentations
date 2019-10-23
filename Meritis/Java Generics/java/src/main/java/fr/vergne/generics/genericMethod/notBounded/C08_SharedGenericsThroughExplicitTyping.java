package fr.vergne.generics.genericMethod.notBounded;

import java.util.HashMap;
import java.util.Map;

public class C08_SharedGenericsThroughExplicitTyping {
	/*
	 * On pose l'hypothèse que l'utilisateur connaît le type de données associé à la
	 * clé. Inutile donc de stocker le type, c'est l'utilisateur qui nous le dira
	 * lors du get(). Aucune réelle exploitation des generics ici pour contrôler le
	 * type à la compilation. Il reste possible d'écrire des bétises qui ne seront
	 * reconnues qu'au runtime.
	 */
	static class HeterogeneousContainer {
		private Map<Object, Object> container = new HashMap<>();

		void put(Object key, Object value) {
			container.put(key, value);
		}

		/**
		 * Cas isolé équivalent : {@link C04_ReturnOnly#toT()}
		 */
		@SuppressWarnings("unchecked")
		<T> T get(Object key) {
			return (T) container.get(key);
		}
	}

	public static void main(String[] args) {
		HeterogeneousContainer map = new HeterogeneousContainer();

		// add/get d'un entier
		String k1 = "k1";
		map.put(k1, 123);
		Integer integer = map.get(k1);
		System.out.println(integer);

		// add/get d'une String
		String k2 = "k2";
		map.put(k2, "foo");
		String string = map.get(k2);
		System.out.println(string);

		// Compile, mais échoueront au runtime :
		integer = map.get(k2);
		string = map.get(k1);
	}
}
