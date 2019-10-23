package fr.vergne.generics.genericMethod.bounded;

import fr.vergne.generics.B;
import fr.vergne.generics.X;

public class C2_OneArgument {
	<T extends B> void fromT(T t) {
		t.doA();
		t.doB();
		// t traité en tant que B
		// Permet uniquement le découplage type/argument
		// Remplacer T par B si découplage inutile
	}
	
	<T extends B> void fromX(X<T> x) {
		T t = x.get();
		x.set(t);
		// Permet de multiples interactions avec x sans perdre le type.
		// Helper privé suffit pour faire la même chose (extends sur argument fromX).
		
		// Permet sinon uniquement le découplage type/argument
		// Remplacer T par ? si découplage inutile
	}
}
