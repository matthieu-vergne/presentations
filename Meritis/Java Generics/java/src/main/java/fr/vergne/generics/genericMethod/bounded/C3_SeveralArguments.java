package fr.vergne.generics.genericMethod.bounded;

import fr.vergne.generics.B;
import fr.vergne.generics.X;

public class C3_SeveralArguments {
	<T extends B> void fromTT(T t1, T t2) {
		t1.doB();
		t2.doB();
		// t1 et t2 traités en tant que B
		// Aucun alignement automatique entre les deux
		// Permet uniquement le découplage type/arguments
		// Si type explicité T0, toujours aucun alignement (n'importe quel T0)
		// Remplacer par Object si découplage inutile
	}
	
	<T extends B> void fromXT(X<T> x, T t) {
		t.doB();
		x.get().doB();
		x.set(t);
		// t contraint d'avoir un type compatible avec X
		// Permet de les faire interagir
	}
	
	<T extends B> void fromXX(X<T> x1, X<T> x2) {
		x1.set(x2.get());
		// x1 et x2 sont contraints d'avoir le même type T
		// Permet de les faire interagir
	}
}
