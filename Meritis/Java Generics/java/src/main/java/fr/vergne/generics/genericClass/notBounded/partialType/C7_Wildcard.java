package fr.vergne.generics.genericMethod.notBounded.partialType;

public class C7_Wildcard {
	<T> T extract1(X<? extends T> x) {
		return x.get();
	}

	<T> T extract2(X<? super T> x) {
		return null;
		// Impossible car x peut renvoyer n'importe quel type parent de T
	}

	<T> void feed1(T value, X<? extends T> dest) {
		// Impossible car dest n'accepte qu'un sous-type spécifique de T
		// value peut être n'importe quel T
	}

	<T> void feed2(T value, X<? super T> dest) {
		dest.set(value);
	}

	<T> X<T> generate1(X<? extends T> x) {
		X<T> x2 = new X<>();
		x2.set(x.get());
		return x2;
	}

	<T> X<? extends T> generate2(X<T> x) {
		X<? extends T> x2 = new X<>();
		x.set(x2.get());
		return x2;
		// Peu intuitif :
		// - x2 généré sans utiliser x
		// - x2 utilisé pour adapter x
		// Double responsabilité, pertinent à séparer

		// wildcard inutile car type ? inconnu
		// non synchronisé avec quoi que ce soit d'utile.
		// enlever wildcard
	}

	<T> X<? extends T> generate3(X<? extends T> x) {
		return null;
		// Impossible car "?" retour potentiellement incompatible avec "?" argument
		// enlever wildcard retour
	}

	<T> X<T> generate4(X<? super T> x) {
		X<T> x2 = new X<>();
		x.set(x2.get());
		return x2;
		// Peu intuitif :
		// - élement généré sans utiliser x
		// - élément généré utilisé pour adapter x
		// Double responsabilité, pertinent à séparer
	}

	<T> X<? super T> generate5(X<T> x) {
		X<? super T> x2 = new X<>();
		x2.set(x.get());
		return x2;
		// wildcard inutile car type ? inconnu
		// non synchronisé avec quoi que ce soit d'utile.
		// enlever wildcard
	}

	<T> X<? super T> generate6(X<? super T> x) {
		return null;
		// Impossible car "?" retour potentiellement incompatible avec "?" argument
		// enlever wildcard retour
	}

	<T> X<? extends T> generate7(X<? super T> x) {
		X<? extends T> x2 = new X<>();
		x.set(x2.get());
		return x2;
		// Peu intuitif :
		// - élement généré sans utiliser x
		// - élément généré utilisé pour adapter x
		// Double responsabilité, pertinent à séparer

		// wildcard retour inutile car type ? inconnu
		// non synchronisé avec quoi que ce soit d'utile.
		// enlever wildcard retour
	}

	<T> X<? super T> generate8(X<? extends T> x) {
		X<? super T> x2 = new X<>();
		x2.set(x.get());
		return x2;
		// wildcard retour inutile car type ? inconnu
		// non synchronisé avec quoi que ce soit d'utile.
		// enlever wildcard retour
	}

	<T> void transfer1(X<? extends T> src, X<T> dest) {
		dest.set(src.get());
	}

	<T> void transfer2(X<T> src, X<? extends T> dest) {
		// Impossible car dest n'accepte qu'un sous-type spécifique de T
		// src peut renvoyer n'importe quel T
	}

	<T> void transfer3(X<? extends T> src, X<? extends T> dest) {
		// Impossible car peuvent être sur des sous-types de T différents
	}

	<T> void transfer4(X<? super T> src, X<T> dest) {
		// Impossible car src ne renvoie pas forcément un T
	}

	<T> void transfer5(X<T> src, X<? super T> dest) {
		dest.set(src.get());
	}

	<T> void transfer6(X<? super T> src, X<? super T> dest) {
		// Impossible car peuvent être sur des types parents de T différents
	}

	<T> void transfer7(X<? extends T> src, X<? super T> dest) {
		dest.set(src.get());
	}

	<T> void transfer8(X<? super T> src, X<? extends T> dest) {
		// Impossible car dest n'accepte qu'un sous-type spécifique de T
		// src peut renvoyer n'importe quel type parent de T
	}

	/*
	 * En général, les wildcard ne devraient jamais appraître dans les types de
	 * retour. Dans les arguments, "extends" devrait être utilisé pour les données
	 * en lecture seule, et "super" pour celles en écriture seule. Si les deux
	 * opérations sont nécessaires, cela impose les deux contraintes et donc d'avoir
	 * le type exacte, sans wildcard.
	 * 
	 * Source :
	 * https://docs.oracle.com/javase/tutorial/java/generics/wildcardGuidelines.html
	 */
}
