package fr.vergne.generics.genericMethod.notBounded.partialType;

public class C1_NoElement {
	<T> void xxx() {
		// T ne contraint rien, donc inutile.
		// Retirer T
	}
}
