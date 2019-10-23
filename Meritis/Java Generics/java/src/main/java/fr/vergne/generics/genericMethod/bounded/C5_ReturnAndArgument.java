package fr.vergne.generics.genericMethod.bounded;

import fr.vergne.generics.B;
import fr.vergne.generics.X;

public class C5_ReturnAndArgument {
	<T extends B> T fromTtoT(T t) {
		t.doB();
		return t;
		// t traité comme B
		// Ne peut instancier T retour que par t ou conteneur
		// Le retour direct est inutile, l'appelant ayant déjà la référence à t
		// Retour pertinent si B permet de créer d'autres instances
		// Sinon remplacer T par type attendu, surcharger pour plusieurs types
	}
	
	<T extends B> X<T> fromTtoX(T t) {
		X<T> x2 = new X<>();
		x2.set(t);
		return x2;
	}
	
	<T extends B> T fromXtoT(X<T> x) {
		return x.get();
	}
	
	<T extends B> X<T> fromXtoX(X<T> x) {
		X<T> x2 = new X<>();
		x2.set(x.get());
		return x2;
	}
}
