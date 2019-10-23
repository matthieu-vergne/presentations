package fr.vergne.generics.genericClass.notBounded.completeType;

public class C3_ConstructorOnly<T> {
	Object field;

	public C3_ConstructorOnly(T t1, T t2) { // Only use
	}

	public void set(Object field) {
		this.field = field;
	}

	Object get() {
		return field;
	}

	// Classe n'exploite pas T
	// Réduire à generics de méthode (sur constructeur)
}
