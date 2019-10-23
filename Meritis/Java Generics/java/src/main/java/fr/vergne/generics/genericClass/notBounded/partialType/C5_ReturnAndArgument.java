package fr.vergne.generics.genericMethod.notBounded.partialType;

public class C5_ReturnAndArgument {
	<T> X<T> generate(T t) {
		X<T> x2 = new X<>();
		x2.set(t);
		return x2;
	}
	
	<T> T extract(X<T> x) {
		return x.get();
	}
	
	<T> X<T> duplicate(X<T> x) {
		X<T> x2 = new X<>();
		x2.set(x.get());
		return x2;
		// Incapable d'instancier T à part depuis x
		// Le retour direct de x est inutile, l'appelant ayant déjà la référence à x
		// Retour (et donc Generics) utile uniquement si création d'une autre instance de X
		// Instanciée directement ou par méthodes de transformation
	}
}
