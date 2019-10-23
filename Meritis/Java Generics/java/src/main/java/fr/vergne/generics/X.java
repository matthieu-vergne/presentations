package fr.vergne.generics;

/**
 * Classe utilisant le generics T.
 */
public class X<T> {
	
	T t;
	
	public X() {
	}
	
	public X(T t) {
		this.t  = t;
	}
	
	public X(T t1, T t2) {
		consume(t1);
		consume(t2);
	}

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public void consume(T t) {
		// Utilise t
	}

	public X<T> withT(T t) {
		X<T> x = new X<>();
		x.set(t);
		return x;
	}
}
