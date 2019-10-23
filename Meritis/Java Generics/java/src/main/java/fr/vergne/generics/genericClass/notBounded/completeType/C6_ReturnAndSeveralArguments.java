package fr.vergne.generics.genericMethod.notBounded.completeType;

public class C6_ReturnAndSeveralArguments {
	<T> T xxx(T t1, T t2) {
		return null;
		// Retour impossible à obtenir sans l'obtenir de t1 ou t2
		// Sélection d'un des arguments pour retour (comparateur)
		// Sinon, obtention d'une autre instance depuis t1 ou t2 (générateur)
		// Transformation additionelle possible

		// t1 et t2 traités en tant qu'Object
		// Aucun alignement automatique entre les deux
		// Permet uniquement le découplage type/arguments
		// Si type explicité T0, n'importe quel type sous T0 OK
		// Remplacer par Object si non explicité
	}
}
