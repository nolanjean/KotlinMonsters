package org.example.monde

import org.example.monstre.EspeceMonstre
/**
 * Représente une zone contenant des monstres, avec des liens vers des zones adjacentes.
 *
 * @property id Identifiant unique de la zone.
 * @property nom Nom de la zone.
 * @property expZone Expérience associée à la zone.
 * @property especeMonstre Liste des espèces de monstres présentes dans la zone.
 * @property zoneSuivante Zone adjacente qui suit la zone actuelle.
 * @property zonePrecedente Zone adjacente qui précède la zone actuelle.
 */
class Zone(val id: Int, val nom: String, var expZone: Int, val especeMonstre: MutableList<EspeceMonstre> = mutableListOf(),var zoneSuivante: Zone? = null, var zonePrecedente: Zone? = null) {
    //TODO genreMonstre()
    //TODO rencontreMonstre()
}