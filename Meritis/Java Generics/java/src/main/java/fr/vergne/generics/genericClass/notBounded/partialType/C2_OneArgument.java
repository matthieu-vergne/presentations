package fr.vergne.generics.genericMethod.notBounded.partialType;

public class C2_OneArgument {
	<T> void xxx(X<T> x) {
		T t = x.get();
		x.set(t);
		// Permet de multiples interactions avec x sans perdre le type.
		// Helper privé suffit pour faire la même chose.
		
		// Permet sinon uniquement le découplage type/argument
		// Remplacer T par ? si non explicité
	}
}
