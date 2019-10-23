package fr.vergne.generics.genericMethod.bounded.completeType;

import fr.vergne.generics.B;

public class C4_ReturnOnly {
	<T extends B> T xxx() {
		return null;
		// Incapable d'instancier T
		// Remplacer T par le type attendu
		// Faire une méthode pour chaque type attendu (polymorphisme ad hoc)

		// PAR possible : récupération instance quelconque + cast (conteneur hétérogène)
		// On préfèrera un conteneur hétérogène type-safe (e.g. clé générique)
	}
}
