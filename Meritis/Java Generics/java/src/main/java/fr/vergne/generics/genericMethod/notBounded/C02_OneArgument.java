package fr.vergne.generics.genericMethod.notBounded;

import fr.vergne.generics.X;

public class C02_OneArgument {
	/**
	 * t traité en tant qu'{@link Object}. Le generics permet uniquement le
	 * découplage type/argument. Si le découplage est inexploité, il vaut mieux
	 * {@link C00_NoGenerics#fromT(Object) remplacer T par Object}.
	 */
	<T> void fromT(T t) {
		t.toString();
	}

	/**
	 * Permet de multiples interactions avec x sans perdre son type. Un helper privé
	 * suffit cependant pour faire la même chose. Le generics ne permet alors que le
	 * découplage type/argument. Si le découplage est inexploité, il vaut mieux
	 * {@link C00_NoGenerics#fromX(X) remplacer T par ? et utiliser un helper}.
	 */
	<T> void fromX(X<T> x) {
		T t = x.get();
		x.set(t);
	}
}
