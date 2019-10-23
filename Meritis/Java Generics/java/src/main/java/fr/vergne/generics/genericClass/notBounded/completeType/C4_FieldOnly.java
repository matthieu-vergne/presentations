package fr.vergne.generics.genericClass.notBounded.completeType;

public class C4_FieldOnly<T> {
	T field1;// Only use
	T field2;// Only use
	
	public C4_FieldOnly() {
	}
	
	public Object getField1() {
		return field1;
	}

	public Object getField2() {
		return field2;
	}

	// Class n'exploite pas T
	// Remplacer T par Object
}
