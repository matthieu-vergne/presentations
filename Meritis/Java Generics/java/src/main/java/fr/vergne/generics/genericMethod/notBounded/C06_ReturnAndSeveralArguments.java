package fr.vergne.generics.genericMethod.notBounded;

import java.util.Random;

import fr.vergne.generics.X;

public class C06_ReturnAndSeveralArguments {
	/**
	 * t1 et t2 sont traités en tant qu'{@link Object} ce qui ne permet aucun
	 * traitement spécifique. On pourra
	 * {@link C00_NoGenerics#fromTTtoT(String, String) remplacer T par un type
	 * spécifique} si on a ce besoin, et la surcharger pour gérer plusieurs types.
	 * Sinon, on reste incapable d'instancier T, on ne peut qu'utiliser t1 et t2. Le
	 * retour direct peut être utile (e.g. sélection). Les types de t1 et t2 sont
	 * indépendamment contraints. Si on explicite le type, on pose un parent commun,
	 * mais n'importe quel type enfant est accepté indépendamment pour chaque
	 * argument. Impossible donc d'aligner les types de t1 et t2.
	 */
	<T> T fromTTtoT(T t1, T t2) {
		if (new Random().nextBoolean()) {
			return t1;
		} else {
			return t2;
		}
	}

	/**
	 * Permet de générer des {@link X} sur la base d'instances de T.
	 */
	<T> X<T> fromTTtoX(T t1, T t2) {
		return new X<>(t1, t2);
	}

	/**
	 * Permet de générer des T sur la base d'instances de {@link X} ou T.
	 */
	<T> T fromXTtoT(X<T> x, T t) {
		T old = x.get();
		x.set(t);
		return old;
	}

	/**
	 * Permet de générer des {@link X} sur la base d'instances de {@link X} ou T.
	 */
	<T> X<T> fromXTtoX(X<T> x, T t) {
		return x.withT(t);
	}

	/**
	 * Permet de récupérer des T encapsulés dans des {@link X} en préservant leur
	 * type.
	 */
	<T> T fromXXtoT(X<T> x1, X<T> x2) {
		if (new Random().nextBoolean()) {
			return x1.get();
		} else {
			return x2.get();
		}
	}

	/**
	 * Permet de générer des {@link X} sur la base des données d'autres {@link X}.
	 * On pourra aussi retourner une instance reçue (e.g. sélection).
	 */
	<T> X<T> fromXXtoX(X<T> x1, X<T> x2) {
		if (new Random().nextBoolean()) {
			return x1;
		} else {
			return x2;
		}
	}
}
