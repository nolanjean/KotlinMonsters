package org.example.monstre

import org.example.dresseur.Entraineur
import javax.sound.sampled.Line
import kotlin.math.max
import kotlin.random.Random
import kotlin.math.pow

/**
 * Représente un individu monstre existant dans le jeu, basé sur une espèce de monstre donnée,
 * avec ses caractéristiques spécifiques, son niveau, ses points d'expérience et son entraineur éventuel.
 * Les statistiques sont basées sur l'espèce et légèrement ajustées aléatoirement pour différencier les individus.
 *
 * @property id Identifiant unique de l'individu monstre.
 * @property nom Nom de l'individu monstre.
 * @property espece Instance d'EspeceMonstre représentant l'espèce de ce monstre.
 * @property entraineur L'entraineur assigné à cet individu, null si non assigné.
 * @property expInit Quantité d'expérience initiale attribuée à cet individu à sa création.
 * @property niveau Le niveau actuel de l'individu. Initialisé par défaut à 1.
 * @property attaque Valeur de l'attaque de l'individu. Basée sur sa base d'espèce et modifiée aléatoirement.
 * @property defense Valeur de la défense de l'individu. Basée sur sa base d'espèce et modifiée aléatoirement.
 * @property vitesse Vitesse actuelle de l'individu. Basée sur sa base d'espèce et modifiée aléatoirement.
 * @property attaqueSpe Valeur de l'attaque spéciale de l'individu. Basée sur sa base d'espèce et modifiée aléatoirement.
 * @property defenseSpe Valeur de la défense spéciale de l'individu. Basée sur sa base d'espèce et modifiée aléatoirement.
 * @property pvMax Points de vie maximum pour cet individu. Basés sur sa base d'espèce et modifiés aléatoirement.
 * @property potentiel Potentiel de croissance de l'individu, défini aléatoirement entre 0.5 et 2.1. Ce paramètre pourrait influencer l'évolution future.
 * @property exp Expérience cumulée par cet individu. Permet de déterminer quand il atteint de nouveaux niveaux.
 * @property pv Points de vie courants de l'individu. Ne peut jamais dépasser [pvMax] ni être inférieur à 0.
 */

class individuMonstre(val id: Int, var nom: String, val espece: EspeceMonstre, val entraineur : Entraineur?= null, expInit: Double) {
    var niveau: Int = 1
    var attaque : Int = this.espece.baseAttaque + (-2..2).random()
    var defense : Int = this.espece.baseDefense + (-2..2).random()
    var vitesse : Int = this.espece.baseVitesse + (-2..2).random()
    var attaqueSpe : Int = this.espece.baseAttaqueSpe + (-2..2).random()
    var defenseSpe : Int = this.espece.baseDefenseSpe + (-2..2).random()
    var pvMax : Int = this.espece.basePv + (-5..5).random()
    var potentiel : Double = Random.nextDouble(0.5,2.1)
    var exp : Double = 0.0
        get() = field
        set(value){
            field=value
            val estNiveau1 = (niveau == 1)

            while (field >= palierExp(niveau)) {
                levelUp()
                if (!estNiveau1) {
                    println("Le monstre $nom est maintenant niveau $niveau !")
                    //Problème niveau 2 direct en initialisant à 0
                }
            }
        }
    init {
        this.exp = expInit // applique le setter et déclenche un éventuel level-up
    }

    /**
     *  @property pv  Points de vie actuels.
     * Ne peut pas être inférieur à 0 ni supérieur à [pvMax].
     */
    var pv: Int = pvMax
        get() = field
        set(nouveauPv) {
            field = nouveauPv
            if (field < 0) field = 0
            if (field > pvMax) field = pvMax
            if (field - nouveauPv in 0..pvMax) field=nouveauPv
        }

    /**
     * Calcule l'expérience totale nécessaire pour atteindre un niveau donné.
     *
     * @param niveau Niveau cible.
     * @return Expérience cumulée nécessaire pour atteindre ce niveau.
     */
    fun palierExp(niveau: Int): Double {
        return 100*(niveau-1).toDouble().pow(2.0)
        //obligé de passer en double ici
    }

    /**
     * Handles the level-up process for an individual monster, increasing its level and updating its stats.
     *
     * The method performs the following operations:
     * 1. Increments the monster's current level.
     * 2. Saves the previous maximum health points (`pvMax`) for calculating the health gain.
     * 3. Updates the monster's stats (attack, defense, speed, special attack, special defense, and max health points)
     *    based on the species' modifiers and the monster's potential. Adds random variations to each stat.
     * 4. Adjusts the current health points (`pv`) to account for the increase in `pvMax`.
     *    Ensures that current health points do not exceed the maximum health points.
     */
    fun levelUp() {
        // 1. Incrémenter le niveau
        niveau++

        // 2. Sauvegarder l'ancien pvMax pour calcul du gain
        val ancienPvMax = pvMax

        // 3. Mise à jour des stats
        attaque += (espece.modAttaque * potentiel).toInt() + (-2..2).random()
        defense += (espece.modDefense * potentiel).toInt() + (-2..2).random()
        vitesse += (espece.modVitesse * potentiel).toInt() + (-2..2).random()
        attaqueSpe += (espece.modAttaqueSpe * potentiel).toInt() + (-2..2).random()
        defenseSpe += (espece.modDefenseSpe * potentiel).toInt() + (-2..2).random()
        pvMax += (espece.modPv * potentiel).toInt() + (-5..5).random()

        // 4. Augmenter les PV actuels du gain de pvMax
        val gainPv = pvMax - ancienPvMax
        pv += gainPv
        if (pv > pvMax) pv = pvMax // sécurité
    }

    /**
     * Attaque un autre [IndividuMonstre] et inflige des dégâts.
     *
     * Les dégâts sont calculés de manière très simple pour le moment :
     * `dégâts = attaque - (défense / 2)` (minimum 1 dégât).
     *
     * @param cible Monstre cible de l'attaque.
     */

    fun attaquer(cible: individuMonstre){
        var degatBrut = this.attaque
        var degatTotal = degatBrut - (this.defense / 2) //Bizarre ici d'utiliser la défense du monstre qui attaque au lieu de celui cibler
        if (degatTotal < 1) degatTotal = 1
        var pvAvant = cible.pv
        cible.pv -= degatTotal
        var pvApres = cible.pv
        println("${nom} inflige ${pvAvant-pvApres} dégâts à ${cible.nom}")

    }

    /**
     * Demande au joueur de renommer le monstre.
     * Si l'utilisateur entre un texte vide, le nom n'est pas modifié.
     */

    fun renommer(){
        println("Renommer ${nom} ?")
        val nouveauNom = readln()
        if (nouveauNom!=""){
            this.nom = nouveauNom // obligation de passer la caractéristique nom de val à var
        }
    }

    /**
     * Displays detailed information about the monster, including its stats and ASCII art representation.
     *
     * The output includes:
     * - ASCII art representation of the monster, loaded via the `afficheArt` method.
     * - Monster details, such as name, level, experience, health points, and various stats (attack, defense, speed, etc.).
     *
     * The details and the ASCII art are aligned side by side, formatted to ensure proper readability.
     */
    fun afficheDetail(){
        val art = espece.afficheArt()
        val artLines = art.lines()
        val details = listOf("     ==========================",
            "Nom : $nom     Lvl  : $niveau",
            "Exp : $exp",
            "PV : $pv","==========================",
            "Atq : $attaque  Def : $defense  Vitesse : $vitesse",
            "AtqSpe : $attaqueSpe",
            "DefSpe : $defenseSpe",
            "=========================="
        )
        val maxArtWidth = artLines.maxOf { it.length }
        val maxLines = max(artLines.size,details.size)
        for (i in 0 until maxLines){
            val artLine = if (i < artLines.size) artLines[i] else ""
            val detailLine = if (i < details.size) details[i] else ""
            val paddeArt = artLine.padEnd(maxArtWidth + 4)
            println(paddeArt + detailLine)
        }
    }
}