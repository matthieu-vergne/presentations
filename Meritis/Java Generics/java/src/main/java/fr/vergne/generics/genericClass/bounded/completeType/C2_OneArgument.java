package fr.vergne.generics.genericMethod.bounded.completeType;

import fr.vergne.generics.B;

public class C2_OneArgument {
	<T extends B> void xxx(T t) {
		// t traité en tant que B
		// Permet uniquement le découplage type/argument
		// Remplacer T par B si non explicité
	}
}
