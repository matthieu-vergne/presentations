package fr.vergne.generics.genericMethod.notBounded.partialType;

public class C3_SeveralArguments {
	<T> void xxx(X<T> x, T t) {
		x.set(t);
		// x et t sont contraints d'avoir le même type T
		// Permet de les faire interagir
	}
	
	<T> void yyy(X<T> x1, X<T> x2) {
		x1.set(x2.get());
		// x1 et x2 sont contraints d'avoir le même type T
		// Permet de les faire interagir
	}
}
