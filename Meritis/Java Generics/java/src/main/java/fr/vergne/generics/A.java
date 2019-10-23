package fr.vergne.generics;

/**
 * Classe racine de la hiérarchie {@link A} -> {@link B} -> {@link C} :
 * <ul>
 * <li>si T = B, il couvre {@link B}.</li>
 * <li>si T = ? extends B, il couvre {@link B} et {@link C}.</li>
 * <li>si T = ? super B, il couvre {@link A} et {@link B}.</li>
 * </ul>
 */
public interface A {
	void doA();
}
