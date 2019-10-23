package fr.vergne.generics.genericMethod.bounded;

import fr.vergne.generics.B;
import fr.vergne.generics.X;

public class C4_ReturnOnly {
	<T extends B> T toT() {
		return null;
		// Incapable d'instancier T
		// Surcharge impossible avec retour seul, nécessite argument, cf. C5 -> fromXtoT
	}
	
	<T extends B> X<T> toX() {
		return new X<T>();
		// Incapable d'instancier X si nécessite instance de T
		// Surcharge impossible avec retour seul, nécessite argument, cf. C5 -> fromXtoT
	}
}
