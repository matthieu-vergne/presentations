package fr.vergne.generics.genericClass.notBounded.completeType;

public class C2_SingleMethodOnly<T> {
	Object field;

	public C2_SingleMethodOnly() {
	}

	T xxx(T t) { // Only use
		return t;
	}

	public void set(Object field) {
		this.field = field;
	}

	Object get() {
		return field;
	}

	// Classe pas besoin de T
	// Réduction possible à generics de méthode
	// Réduire si pas besoin d'instance spécialisée
	// i.e. "instance.xxx(t)" avec toujours le même type
}
