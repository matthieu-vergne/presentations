package fr.vergne.generics.genericMethod.notBounded.partialType;

import java.util.Random;

import fr.vergne.generics.X;

public class C6_ReturnAndSeveralArguments {
	<T> X<T> fromTTtoX(T t1, T t2) {
		X<T> x = new X<>();
		x.consume(t1);
		x.consume(t2);
		return x;
	}

	<T> T fromXTtoT(X<T> x, T t) {
		T old = x.get();
		x.set(t);
		return old;
	}

	<T> X<T> fromXTtoX(X<T> x, T t) {
		return x.withT(t);
	}

	<T> T fromXXtoT(X<T> x1, X<T> x2) {
		if (new Random().nextBoolean()) {
			return x1.get();
		} else {
			return x2.get();
		}
	}

	<T> X<T> fromXXtoX(X<T> x1, X<T> x2) {
		if (new Random().nextBoolean()) {
			return x1;
		} else {
			return x2;
		}
	}
}
