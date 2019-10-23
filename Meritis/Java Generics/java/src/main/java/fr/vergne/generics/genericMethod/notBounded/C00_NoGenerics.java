package fr.vergne.generics.genericMethod.notBounded;

import fr.vergne.generics.X;

/**
 * Cette classe n'expose aucun generics. Elle donne les cas de base auxquels on
 * peut être réduit quand les generics n'apportent pas ce dont on a besoin.
 */
public class C00_NoGenerics {
	void doSomething() {
		// ...
	}

	void fromT(Object t) {
		t.toString();
	}

	void fromX(X<?> x) {
		helper(x);
	}

	private <T> void helper(X<T> x) {
		T t = x.get();
		x.set(t);
	}

	String toT() {
		return "foo";
	}

	X<String> toX() {
		return new X<String>();
	}

	void fromTT(Object t1, Object t2) {
		t1.equals(t2);
	}
	
	String fromTtoT(String t) {
		return t.replaceAll("foo", "bar");
	}
	
	String fromTTtoT(String t1, String t2) {
		return t1.replaceAll(t2, "bar");
	}
}
