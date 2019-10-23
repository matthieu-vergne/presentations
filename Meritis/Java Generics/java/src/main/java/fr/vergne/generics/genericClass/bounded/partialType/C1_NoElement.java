package fr.vergne.generics.genericMethod.bounded.partialType;

import fr.vergne.generics.B;

public class C1_NoElement {
	<T extends B> void xxx() {
		// T ne contraint rien, donc inutile.
		// Retirer T
	}
}
