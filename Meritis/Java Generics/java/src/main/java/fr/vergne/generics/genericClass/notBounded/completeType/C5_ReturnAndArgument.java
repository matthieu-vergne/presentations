package fr.vergne.generics.genericMethod.notBounded.completeType;

public class C5_ReturnAndArgument {
	<T> T xxx(T t) {
		return t;
		// Incapable d'instancier T
		// Ne peut instancier que depuis t (e.g. t.clone()) ou le retourner directement
		// Le retour direct est inutile, l'appelant ayant déjà la référence à t
		// Utile uniquement si obtention d'une autre instance depuis t
		// En pratique, obtention de t' depuis t + transformation de t ou t'
	}
}
