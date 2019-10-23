/**
 * Ensemble des usages possibles de generics de méthodes
 * (<code>&lt;T> xxx()</code>).<br>
 * <br>
 * <h1>Focus principal : exploitation des arguments</h1><br>
 * <br>
 * L'usage de base d'un generics de méthode est de permettre à la méthode d'être
 * appliquée sur n'importe quel type d'objet respectant son contrat. Une
 * méthode, prise isolèment, ne peut donc lier sa valeur de retour qu'à ses
 * arguments ou à des instances de classes qu'elle est capable d'instancier.<br>
 * <br>
 * Un generics T, même contraint, ne permet pas de connaître avec certitude la
 * classe à instancier. Sauf cas exceptionnel, le retour ne peut alors dépendre
 * que des arguments reçus. Ce point est couvert plus end étail dans la section
 * suivante.<br>
 * <br>
 * Les méthodes génériques ne peuvent pas non plus compter sur l'état de leur
 * classe (i.e. les champs) pour générer une instance de T, car cela nécessite
 * d'élargir le scope du generics à cet état, et donc d'en faire un generics de
 * classe. On se focalise ici sur les generics de méthode, ce qui nous
 * l'interdit.<br>
 * <br>
 * Selon les contraintes appliquées aux generics, certaines combinaisons peuvent
 * alors être inexploitables.<br>
 * <br>
 * Sauf mention contraire, les cas étudiés ici se focalisent donc sur la
 * possibilité pour la méthode d'exploiter ses arguments.<br>
 * <br>
 * <h1>Polymorphisme ad hoc : instancier des classes connues</h1><br>
 * <br>
 * Techniquement, il est souvent possible d'instancier manuellement en vérifiant
 * que l'argument soit une instance d'une classe donnée (e.g. instanceof). Mais
 * non seulement cette méthode a des limites techniques (e.g. type erasure,
 * types enfants inconnus), en plus elle consiste en une perversion des
 * generics, qui se contentent ici de cacher le type plutôt que de le
 * contraindre, imposant un contrôle au runtime (i.e. instanceof) plutôt qu'à la
 * compilation.<br>
 * <br>
 * Il s'agit donc d'un polymorphisme ad hoc travesti en polymorphisme
 * paramétrique, mais sans les avantages de ce dernier. Seule reste du
 * paramétrique le méthode unique, mais avec un code qui contrevient à des
 * bonnes pratiques reconnues, par exemple au principe O de SOLID : le code
 * n'est pas fermé à la modification car le moindre ajout d'un type impose
 * d'ajouter du code à cette méthode.<br>
 * <br>
 * La bonne pratique reste d'utiliser une méthode pour chaque type
 * (polymorphisme ad hoc par surcharge) pour laisser le travail de sélection au
 * compilateur. Le <a href=
 * "https://fr.wikipedia.org/wiki/Visiteur_(patron_de_conception)">pattern
 * Visiteur</a> en est un exemple.<br>
 * <br>
 * <h1>Usage d'éléments externes</h1><br>
 * <br>
 * Il reste possible d'utiliser un élément externe à la méthode, comme un
 * champs. Celui-ci n'étant pas lié par un generics de classe, il reste
 * cependant incapable de fournir directement une instance de T, qui doit alors
 * être fournie autrement. Cependant, cela permet d'ajouter des intermédiaires
 * exploitables pour lier les arguments et la valeur de retour. Les cas
 * inexploitables du fait des seuls arguments peuvent donc devenir exploitables
 * selon les intermédiaires présents. Les cas avec intermédiaires sont illustrés
 * dans des classes dédiées.<br>
 * <br>
 * Ressources : Bloch, Joshua. Effective Java. Third edition. Boston:
 * Addison-Wesley, 2018.<br>
 */
package fr.vergne.generics.genericMethod;
