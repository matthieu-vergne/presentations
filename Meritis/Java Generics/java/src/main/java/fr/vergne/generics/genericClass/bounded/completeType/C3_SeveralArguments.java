package fr.vergne.generics.genericMethod.bounded.completeType;

import fr.vergne.generics.B;

public class C3_SeveralArguments {
	<T extends B> void xxx(T t1, T t2) {
		// t1 et t2 traités en tant que B
		// Aucun alignement automatique entre les deux
		// Permet uniquement le découplage type/arguments
		// Si type explicité T0, toujours aucun alignement (n'importe quel T0)
		// Remplacer par B si non explicité
	}
}
