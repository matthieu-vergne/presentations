package fr.vergne.generics.genericMethod.notBounded.partialType;

public class C4_ReturnOnly {
	<T> X<T> xxx() {
		return new X<T>();
		// Incapable d'instancier T
		// Si instanciation de X nécessite instance de T, incapable d'instancier X
		// Si pas besoin d'instance de T, OK
		// Sinon remplacer T par le type attendu
		// Faire une méthode pour chaque type attendu (polymorphisme ad hoc)

		// PAR possible : récupération instance quelconque + cast (conteneur hétérogène)
		// On préfèrera un conteneur hétérogène type-safe (e.g. clé générique)
	}
}
