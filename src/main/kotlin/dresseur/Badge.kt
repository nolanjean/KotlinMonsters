package org.example.dresseur

/**
 * Représente un badge dans le contexte du jeu, héritant des propriétés d'un [Item].
 *
 * Un badge est un objet unique que le joueur peut obtenir en atteignant des jalons spécifiques,
 * tels que la victoire contre un entraîneur dans une arène. Chaque badge est lié à un [Entraineur],
 * qui est généralement le champion de l'arène où le badge est gagné.
 *
 * @constructor Crée une instance de [Badge].
 * @param id L'identifiant unique du badge.
 * @param nom Le nom du badge.
 * @param description Une description détaillée du badge, indiquant où ou comment il a été obtenu.
 * @param champion L'entraîneur associé au badge, qui est généralement le membre d'une arène correspondant.
 */
class Badge(id: Int, nom: String, description: String, var champion: Entraineur): Item(id, nom, description) {
}