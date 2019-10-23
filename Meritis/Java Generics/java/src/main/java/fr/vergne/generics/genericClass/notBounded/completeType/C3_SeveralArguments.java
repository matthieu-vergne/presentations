package fr.vergne.generics.genericMethod.notBounded.completeType;

public class C3_SeveralArguments {
	<T> void xxx(T t1, T t2) {
		// t1 et t2 traités en tant qu'Object
		// Aucun alignement automatique entre les deux
		// Permet uniquement le découplage type/arguments
		// Si type explicité T0, toujours aucun alignement (n'importe quel T0)
		// Remplacer par Object si non explicité
	}
}
