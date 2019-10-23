package fr.vergne.generics.genericMethod.bounded.partialType;

import fr.vergne.generics.B;

public class C5_ReturnAndArgument {
	<T extends B> X<T> generate(T t) {
		X<T> x2 = new X<>();
		x2.set(t);
		return x2;
	}
	
	<T extends B> T extract(X<T> x) {
		return x.get();
	}
	
	<T extends B> X<T> duplicate(X<T> x) {
		X<T> x2 = new X<>();
		x2.set(x.get());
		return x2;
		// Incapable d'instancier T à part depuis x
		// Le retour direct de x est inutile, l'appelant ayant déjà la référence à x
		// Retour (et donc Generics) utile uniquement si création d'une autre instance de X
		// Instanciée directement ou par méthodes de transformation
	}
}
