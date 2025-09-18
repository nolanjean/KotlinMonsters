package org.example.monstre
import java.io.File

/**
 * Représente une espèce de monstre, avec ses caractéristiques de base et ses modifications.
 *
 * @property id Identifiant unique de l'espèce de monstre.
 * @property nom Nom de l'espèce de monstre.
 * @property type Type de l'espèce de monstre (ex : feu, eau, etc.).
 * @property baseAttaque Statistique de base pour l'attaque.
 * @property baseDefense Statistique de base pour la défense.
 * @property baseVitesse Statistique de base pour la vitesse.
 * @property baseAttaqueSpe Statistique de base pour l'attaque spéciale.
 * @property baseDefenseSpe Statistique de base pour la défense spéciale.
 * @property basePv Statistique de base pour les points de vie.
 * @property modAttaque Modificateur appliqué à l'attaque.
 * @property modDefense Modificateur appliqué à la défense.
 * @property modVitesse Modificateur appliqué à la vitesse.
 * @property modAttaqueSpe Modificateur appliqué à l'attaque spéciale.
 * @property modDefenseSpe Modificateur appliqué à la défense spéciale.
 * @property modPv Modificateur appliqué aux points de vie.
 * @property description Description textuelle de l'espèce de monstre.
 * @property particularites Particularités spécifiques à cette espèce de monstre.
 * @property caractères Caractères ou traits spécifiques de l'espèce.
 */

class EspeceMonstre(var id : Int, var nom: String, var type: String, val baseAttaque: Int, val baseDefense: Int, val baseVitesse: Int, val baseAttaqueSpe: Int, val baseDefenseSpe: Int, val basePv: Int, val modAttaque: Double, val modDefense: Double, val modVitesse: Double, val modAttaqueSpe: Double, val modDefenseSpe: Double, val modPv: Double,val description: String = "",
                    val particularites: String = "",
                    val caractères: String = "") {


    /**
     * Affiche la représentation artistique ASCII du monstre.
     *
     * @param deFace Détermine si l'art affiché est de face (true) ou de dos (false).
     *               La valeur par défaut est true.
     * @return Une chaîne de caractères contenant l'art ASCII du monstre avec les codes couleur ANSI.
     *         L'art est lu à partir d'un fichier texte dans le dossier resources/art.
     */
    fun afficheArt(deFace: Boolean=true): String{
        val nomFichier = if(deFace) "front" else "back";
        val art=  File("src/main/resources/art/${this.nom.lowercase()}/$nomFichier.txt").readText()
        val safeArt = art.replace("/", "∕")
        return safeArt.replace("\\u001B", "\u001B")
    }
}