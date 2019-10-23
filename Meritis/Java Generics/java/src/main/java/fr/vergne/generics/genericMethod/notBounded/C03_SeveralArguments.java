package fr.vergne.generics.genericMethod.notBounded;

import fr.vergne.generics.X;

public class C03_SeveralArguments {
	/**
	 * t1 et t2 traités en tant qu'{@link Object}. Aucun alignement automatique
	 * n'est effectué entre les deux : l'un peut être d'un type, l'autre d'un autre,
	 * le compilateur identifiera le parent commun le plus proche, quitte à ce que
	 * ce soit {@link Object}. Le generics permet uniquement le découplage
	 * type/arguments. Si le type est explicité à T0, il n'y a toujours aucun
	 * alignement : l'un peut être de type T0 ou un type enfant, l'autre de type T0
	 * ou d'un autre type enfant, le compilateur acceptera tout ce qui est un T0. Si
	 * le découplage est inutilisé, il vaut mieux
	 * {@link C00_NoGenerics#fromTT(Object, Object) remplacer T par Object}.
	 */
	<T> void fromTT(T t1, T t2) {
		t1.equals(t2);
	}

	/**
	 * t contraint d'avoir un type compatible avec x, ce qui permet de les faire
	 * interagir.
	 */
	<T> void fromXT(X<T> x, T t) {
		x.set(t);
	}

	/**
	 * x1 et x2 sont contraints d'avoir le même type T, ce qui permet de les faire
	 * interagir.
	 */
	<T> void fromXX(X<T> x1, X<T> x2) {
		x1.set(x2.get());
	}
}
