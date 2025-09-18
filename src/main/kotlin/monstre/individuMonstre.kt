package org.example.monstre

import org.example.dresseur.Entraineur
import kotlin.random.Random

class individuMonstre(val id: Int, val nom: String, val espece: EspeceMonstre, val entraineur : Entraineur?= null, var expInit: Double) {
    var niveau: Int = 1
    var attaque : Int = this.espece.baseAttaque + (-2..2).random()
    var defense : Int = this.espece.baseDefense + (-2..2).random()
    var vitesse : Int = this.espece.baseVitesse + (-2..2).random()
    var attaqueSpe : Int = this.espece.baseAttaqueSpe + (-2..2).random()
    var defenseSpe : Int = this.espece.baseDefenseSpe + (-2..2).random()
    var pvMax : Int = this.espece.basePv + (-5..5).random()
    var potentiel : Double = Random.nextDouble(0.5,2.1)
    var exp : Double = 0.0
    /**
     *  @property pv  Points de vie actuels.
     * Ne peut pas être inférieur à 0 ni supérieur à [pvMax].
     */
    var pv: Int = pvMax
        get() = field
        set(nouveauPv) {
            field=nouveauPv
            // page 20, modifié les nouv pv

        }
}