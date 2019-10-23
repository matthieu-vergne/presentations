package fr.vergne.generics.genericMethod.notBounded.completeType;

public class C4_ReturnOnly {
	<T> T xxx() {
		return null;
		// Incapable d'instancier T
		// Remplacer T par le type attendu
		// Faire une méthode pour chaque type attendu (polymorphisme ad hoc)

		// PAR possible : récupération instance quelconque + cast (conteneur hétérogène)
		// On préfèrera un conteneur hétérogène type-safe (e.g. clé générique)
	}
}
