package org.example.dresseur

/**
 * Représente un objet de base dans le système de jeu.
 *
 * Cette classe est conçue pour être étendue afin de modéliser différents types d'objets,
 * tels que des badges, des objets consommables ou d'autres éléments essentiels dans le jeu.
 * Chaque instance de cette classe ou de ses sous-classes est identifiée par un identifiant unique
 * et comporte un nom ainsi qu'une description.
 *
 * @property id Identifiant unique de l'objet.
 * @property nom Nom de l'objet.
 * @property description Description détaillée de l'objet.
 */
open class Item(var id: Int, var nom: String, var description: String) {
}