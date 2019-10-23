package fr.vergne.generics.genericMethod.notBounded;

import fr.vergne.generics.X;

public class C04_ReturnOnly {
	/**
	 * Incapable d'instancier T. On pourra à la place {@link C00_NoGenerics#toT()
	 * remplacer T par le type exact attendu}. La surcharge étant impossible avec le
	 * retour seul, on devra créer des méthodes différentes pour chaque cas. On peut
	 * sinon ajouter un argument permettant de connaître le type souhaité, mais
	 * {@link C05_ReturnAndArgument#fromTtoT(T) ajouter une instance de T} n'étant
	 * pas très intéressant, on pourra à la place
	 * {@link C05_ReturnAndArgument#fromXtoT(X) ajouter une instance l'ayant comme
	 * generics}.
	 */
	<T> T toT() {
		// Inexploitable
		return null;
	}

	/**
	 * Si {@link X} ne nécessite pas d'instance de T pour être instancier, ça
	 * fonctionne.
	 * 
	 * Dans le cas contraire, c'est un cas inexploitable qui nécessitera de
	 * {@link C00_NoGenerics#toX() spécifier un type particulier}. La surcharge
	 * étant impossible avec le retour seul, on devra créer des méthodes différentes
	 * pour chaque cas. On peut sinon ajouter un argument permettant d'instancier T,
	 * soit {@link C05_ReturnAndArgument#fromTtoX(T) une instance de T directement}
	 * soit {@link C05_ReturnAndArgument#fromXtoX(X) une instance permettant de
	 * l'obtenir}.
	 */
	<T> X<T> toX() {
		return new X<T>();
	}
}
