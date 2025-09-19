package org.example
import org.example.dresseur.Entraineur
import org.example.monstre.EspeceMonstre
import org.example.monde.Zone
import org.example.monstre.individuMonstre

/**
 * Change la couleur du message donné selon le nom de la couleur spécifié.
 * Cette fonction utilise les codes d'échappement ANSI pour appliquer une couleur à la sortie console. Si un nom de couleur
 * non reconnu ou une chaîne vide est fourni, aucune couleur n'est appliquée.
 *
 * @param message Le message auquel la couleur sera appliquée.
 * @param couleur Le nom de la couleur à appliquer (ex: "rouge", "vert", "bleu"). Par défaut c'est une chaîne vide, ce qui n'applique aucune couleur.
 * @return Le message coloré sous forme de chaîne, ou le même message si aucune couleur n'est appliquée.
 */

fun changeCouleur(message: String, couleur:String=""): String {
    val reset = "\u001B[0m"
    val codeCouleur = when (couleur.lowercase()) {
        "rouge" -> "\u001B[31m"
        "vert" -> "\u001B[32m"
        "jaune" -> "\u001B[33m"
        "bleu" -> "\u001B[34m"
        "magenta" -> "\u001B[35m"
        "cyan" -> "\u001B[36m"
        "blanc" -> "\u001B[37m"
        "marron" -> "\u001B[38;5;94m"
        else -> "" // pas de couleur si non reconnu
    }
    return "$codeCouleur$message$reset"
}


var especeX = EspeceMonstre(1,
    "Springleaf",
    "Graine",
    9,
    11,
    10,
    12,
    14,
    60,
    6.5,
    9.0,
    8.0,
    7.0,
    10.0,
    34.0,
    "Petit monstre espiègle rond comme une graine, adore le soleil.",
    "Sa feuille sur la tête indique son humeur.",
    "Curieux, amical, timide")
val flamkip = EspeceMonstre(
    4,
    "Flamkip",
    "Animal",
    50,
    12,
    8,
    13,
    16,
    7,
    22.0,
    10.0,
    5.5,
    9.5,
    9.5,
    6.5,
    "Petit animal entouré de flammes, déteste le froid.",
    "Sa flamme change d’intensité selon son énergie.",
    "Impulsif, joueur, loyal"
)
var aquamy = EspeceMonstre(
    7,
    "Aquamy",
    "Meteo",
    55,
    10,
    11,
    9,
    14,
    14,
    27.0,
    9.0,
    10.0,
    7.5,
    12.0,
    12.0,
    "Créature vaporeuse semblable à un nuage, produit des gouttes pures.",
    "Fait baisser la température en s’endormant.",
    "Calme, rêveur, mystérieux"
)


var testIndividu = individuMonstre(1, "Flamkip",flamkip, entraineur = Entraineur(1,"SACHA", 1500), 0.0)
var monstre2 = individuMonstre(2,"aquamy",aquamy, entraineur = Entraineur(1,"SACHA", 1500), 0.0)
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

}