package fr.vergne.generics.genericMethod.notBounded;

import fr.vergne.generics.X;

public class C07_Wildcard {
	<T> T extractExtends(X<? extends T> x) {
		return x.get();
	}

	<T> T extractSuper(X<? super T> x) {
		return null;
		// Impossible car x peut renvoyer n'importe quel type parent de T
	}

	<T> void feedExtends(T value, X<? extends T> dest) {
		// Impossible car dest n'accepte qu'un sous-type spécifique de T
		// value peut être n'importe quel T
	}

	<T> void feedSuper(T value, X<? super T> dest) {
		dest.set(value);
	}

	<T> X<? extends T> generateExtends(X<T> x) {
		X<? extends T> x2 = new X<>();
		x.set(x2.get());
		return x2;
		// Peu intuitif :
		// - x2 généré sans utiliser x
		// - x2 utilisé pour adapter x
		// Double responsabilité, pertinent à séparer

		// wildcard inutile car type ? inconnu
		// non synchronisé avec quoi que ce soit d'utile.
		// enlever ou nommer le wildcard
	}

	<T> X<T> generateFromExtends(X<? extends T> x) {
		X<T> x2 = new X<>();
		x2.set(x.get());
		return x2;
	}

	<T> X<? extends T> generateExtendsFromExtends(X<? extends T> x) {
		return null;
		// Impossible car retour "?" potentiellement incompatible avec argument "?"
		// enlever wildcard retour
	}

	<T> X<? super T> generateSuper(X<T> x) {
		X<? super T> x2 = new X<>();
		x2.set(x.get());
		return x2;
		// wildcard inutile car type ? inconnu
		// non synchronisé avec quoi que ce soit d'utile.
		// enlever ou nommer le wildcard
	}

	<T> X<T> generateFromSuper(X<? super T> x) {
		X<T> x2 = new X<>();
		x.set(x2.get());
		return x2;
		// Peu intuitif :
		// - élement généré sans utiliser x
		// - élément généré utilisé pour adapter x
		// Double responsabilité, pertinent à séparer
	}

	<T> X<? super T> generateSuperFromSuper(X<? super T> x) {
		return null;
		// Impossible car "?" retour potentiellement incompatible avec "?" argument
		// enlever wildcard retour
	}

	<T> X<? extends T> generateExtendsFromSuper(X<? super T> x) {
		X<? extends T> x2 = new X<>();
		x.set(x2.get());
		return x2;
		// Peu intuitif :
		// - élement généré sans utiliser x
		// - élément généré utilisé pour adapter x
		// Double responsabilité, pertinent à séparer

		// wildcard retour inutile car type ? inconnu
		// non synchronisé avec quoi que ce soit d'utile.
		// enlever ou nommer le wildcard retour
	}

	<T> X<? super T> generateSuperFromExtends(X<? extends T> x) {
		X<? super T> x2 = new X<>();
		x2.set(x.get());
		return x2;
		// wildcard retour inutile car type ? inconnu
		// non synchronisé avec quoi que ce soit d'utile.
		// enlever ou nommer le wildcard retour
	}

	<T> void transferFromExtends(X<? extends T> src, X<T> dest) {
		dest.set(src.get());
	}

	<T> void transferToExtends(X<T> src, X<? extends T> dest) {
		// Impossible car dest n'accepte qu'un sous-type spécifique de T
		// src peut renvoyer n'importe quel T
	}

	<T> void transferFromExtendsToExtends(X<? extends T> src, X<? extends T> dest) {
		// Impossible car peuvent être sur des sous-types de T différents
	}

	<T> void transferFromSuper(X<? super T> src, X<T> dest) {
		// Impossible car src ne renvoie pas forcément un T
	}

	<T> void transferToSuper(X<T> src, X<? super T> dest) {
		dest.set(src.get());
	}

	<T> void transferFromSuperToSuper(X<? super T> src, X<? super T> dest) {
		// Impossible car peuvent être sur des types parents de T différents
	}

	<T> void transferFromExtendsToSuper(X<? extends T> src, X<? super T> dest) {
		dest.set(src.get());
	}

	<T> void transferFromSuperToExtends(X<? super T> src, X<? extends T> dest) {
		// Impossible car dest n'accepte qu'un sous-type spécifique de T
		// src peut renvoyer n'importe quel type parent de T
	}

	/*
	 * En général, les wildcard ne devraient jamais appraître dans les types de
	 * retour car le type généré est caché. On préfèrera retirer la contrainte ou
	 * nommer le wildcard pour pouvoir l'exploiter.
	 * 
	 * Dans les arguments, "extends" devrait être utilisé pour les fournisseurs de
	 * données, et "super" pour les consommateurs de données. Si un élément agit
	 * comme fournisseur et consommateur, cela impose les deux contraintes et donc
	 * d'avoir le type exacte.
	 * 
	 * Source :
	 * https://docs.oracle.com/javase/tutorial/java/generics/wildcardGuidelines.html
	 */
}
