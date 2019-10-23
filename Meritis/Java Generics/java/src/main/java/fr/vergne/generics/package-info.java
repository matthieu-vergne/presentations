/**
 * Ensemble des usages possibles de generics.<br>
 * <br>
 * <h1>Découplage type-argument</h1><br>
 * <br>
 * Les valeurs de generics sont généralement calculés automatiquement en
 * fonction du contexte. À moins que le calcul soit incertain, le compilateur
 * arrive généralement à identifier une valeur permettant la compilation (si
 * celle-ci existe). Par exemple :
 * 
 * <pre>
 * <code>
 * List&lt;String> l = new ArrayList&lt;>(); // ArrayList&lt;String> pour être compatible avec List
 * l.stream().map(s -> s.length()); // Function&lt;String, Integer> pour être compatible avec s.length()
 * </code>
 * </pre>
 * 
 * Il est cependant possible d'expliciter le type voulu, il faudra alors
 * s'assurer que la valeur associée soit cohérente :
 * 
 * <pre>
 * <code>
 * l.stream().map((Function&lt;String, Double>) s -> (double) s.length());
 * </code>
 * </pre>
 * 
 * Un type explicité permet d'afficher une exigence. Si le code ne compile pas,
 * c'est généralement parce que la valeur ne respecte pas cette exigence, et
 * doit donc être changé. Cela peut être utile si le compilateur détermine un
 * type valide mais incompatible avec la suite des instructions, amenant à une
 * erreur de compilation plus loin et donc plus difficile à corriger. Ce besoin
 * reste cependant exceptionnel.<br>
 * <br>
 * <h1>Generics sur code interne</h1><br>
 * <br>
 * Il est possible d'utiliser les generics pour aligner du code interne :
 * 
 * <pre>
 * <code>
 * xxx(List&lt;?> l) {
 *   l.add(l.get(0)); // KO car capture sur add() mais pas sur get(), qui retourne Object pour couvrir la généricité de l'opération
 * }
 * 
 * &lt;T> yyy(List&lt;T> l) {
 *   l.add(l.get(0)); // OK
 * }
 * </code>
 * </pre>
 * 
 * Le generics n'a aucun intérêt du point de vue utilisateur, il s'agit donc
 * d'un détail d'implémentation de la méthode. Pour ne pas l'exposer, on
 * introduit un niveau caché "helper" qui se charge de cet alignement :
 * 
 * <pre>
 * <code>
 * xxx(List&lt;?> l) {
 *   xxxHelper(l); // OK car pas d'opération incertaine
 * }
 * 
 * private &lt;T> xxxHelper(List&lt;T> l) {
 *   l.add(l.get(0)); // OK car generics
 * }
 * </code>
 * </pre>
 * 
 * Ce genre de comportement peut aussi être observé avec un champs :
 * 
 * <pre>
 * <code>
 * List&lt;?> l
 * 
 * xxx() {
 *   l.add(l.get(0)); // KO
 * }
 * </code>
 * </pre>
 * 
 * Comme le type de liste n'est pas connu, il vient forcément de l'extérieur, on
 * peut donc se dire que c'est à l'extérieur de fournir à nouveau l'information
 * de type :
 * 
 * <pre>
 * <code>
 * List&lt;?> l
 * 
 * &lt;T> xxx() {
 *   List&lt;T> l2 = (List&lt;T>) l;
 *   l2.add(l2.get(0)); // OK
 * }
 * </code>
 * </pre>
 * 
 * Cela n'est cependant pas toujours possible car cela impose la contrainte de
 * faire voyager l'information de type si les méthodes sont appelées depuis
 * différents endroits. C'est d'ailleurs peu intéressant car on n'exploite que
 * tardivement l'information pourtant déjà présente dès le début. On pourrait
 * alors assigner le type à la classe pour s'assurer de le garder :
 * 
 * <pre>
 * <code>
 * class MyClass&lt;T> {
 *   List&lt;T> l
 * 
 *   xxx() {
 *     l.add(l.get(0)); // OK
 *   }
 * }
 * </code>
 * </pre>
 * 
 * Cela impose cependant un type unique sur toute l'instance, ce qui n'est pas
 * forcément acceptable. Ce problème se résoud en fait facilement grâce au
 * helper :
 * 
 * <pre>
 * <code>
 * List&lt;?> l
 * 
 * xxx() {
 *   xxxHelper(l); // OK car pas d'opération incertaine
 * }
 * 
 * private &lt;T> xxxHelper(List&lt;T> l) {
 *   l.add(l.get(0)); // OK car generics
 * }
 * </code>
 * </pre>
 * 
 * En dehors de ce genre de détails d'implémentation, on peut considérer que
 * l'intérêt des generics s'active à partir de 2 éléments exposés à aligner
 * (arguments ou retours).<br>
 * <br>
 * Source : <a href="https://docs.oracle.com/javase/tutorial/java/generics/capture.html">https://docs.oracle.com/javase/tutorial/java/generics/capture.html</a>
 */
package fr.vergne.generics;
