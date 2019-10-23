package fr.vergne.generics.genericMethod.notBounded;

import fr.vergne.generics.X;

public class C05_ReturnAndArgument {
	/**
	 * t traité comme {@link Object}, ce qui ne permet aucun traitement spécifique.
	 * On pourra {@link C00_NoGenerics#fromTtoT(String) remplacer T par un type
	 * spécifique} si on a ce besoin, et la surcharger pour gérer plusieurs types.
	 * Sinon, on reste incapable d'instancier T, on ne peut qu'utiliser le t
	 * fournit. Le retour direct est alors inutile, l'appelant ayant déjà la
	 * référence à t. On pourra donc {@link C02_OneArgument#fromT(Object) retirer la
	 * valeur de retour}.
	 */
	<T> T fromTtoT(T t) {
		// Inexploitable
		return null;
	}

	/**
	 * Permet de générer des {@link X} sur la base d'une instance de T.
	 */
	<T> X<T> fromTtoX(T t) {
		X<T> x2 = new X<>();
		x2.set(t);
		return x2;
	}

	/**
	 * Permet de récupérer des T encapsulés dans des {@link X} en préservant leur
	 * type.
	 */
	<T> T fromXtoT(X<T> x) {
		return x.get();
	}

	/**
	 * Permet de générer des {@link X} sur la base des données d'autres {@link X}.
	 * Il est généralement inutile de retourner la même instance, auquel cas on
	 * préfèrera {@link C02_OneArgument#fromX(X) retirer la valeur de retour}.
	 */
	<T> X<T> fromXtoX(X<T> x) {
		X<T> x2 = new X<>();
		x2.set(x.get());
		return x2;
	}
}
