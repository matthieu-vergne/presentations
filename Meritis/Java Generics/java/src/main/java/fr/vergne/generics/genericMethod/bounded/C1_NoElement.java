package fr.vergne.generics.genericMethod.bounded;

import fr.vergne.generics.B;

public class C1_NoElement {
	<T extends B> void withT() {
		// T ne contraint rien, donc inutile.
		// Retirer T
	}
}
