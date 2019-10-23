package fr.vergne.generics.genericMethod.bounded;

import java.util.Random;

import fr.vergne.generics.B;
import fr.vergne.generics.X;

public class C6_ReturnAndSeveralArguments {
	<T extends B> T fromTTtoT(T t1, T t2) {
		if (new Random().nextBoolean()) {
			return t1;
		} else {
			return t2;
		}
		// t1 et t2 traités en tant que B
		// Ne peut instancier T retour que par t1, t2 ou conteneur
		
		// Aucun alignement de type entre les deux
		// Permet uniquement le découplage type/arguments
		// Si type explicité T0, n'importe quel type sous T0 OK
		// Remplacer par B si découplage inutile
	}
	
	<T extends B> X<T> fromTTtoX(T t1, T t2) {
		return new X<>(t1, t2);
	}

	<T extends B> T fromXTtoT(X<T> x, T t) {
		T old = x.get();
		x.set(t);
		return old;
	}

	<T extends B> X<T> fromXTtoX(X<T> x, T t) {
		return x.withT(t);
	}

	<T extends B> T fromXXtoT(X<T> x1, X<T> x2) {
		if (new Random().nextBoolean()) {
			return x1.get();
		} else {
			return x2.get();
		}
	}

	<T extends B> X<T> fromXXtoX(X<T> x1, X<T> x2) {
		if (new Random().nextBoolean()) {
			return x1;
		} else {
			return x2;
		}
	}
}
