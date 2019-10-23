package fr.vergne.generics.genericMethod.notBounded;

public class C01_NoElement {
	/**
	 * T ne contraint rien, donc {@link C00_NoGenerics#doSomething() peut être
	 * retiré}.
	 */
	<T> void withT() {
		// Inexploitable
	}
}
