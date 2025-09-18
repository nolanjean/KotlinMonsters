package org.example.monstre

import org.example.dresseur.Entraineur
import kotlin.random.Random
import kotlin.math.pow



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
            if (field - nouveauPv < 0){
                field=0
            }else{
                field-=nouveauPv
                //je ne fais pas la gestion du pvmax car pas d'intérêt, demander au prof
            }

        }



    /**
     * Calcule l'expérience totale nécessaire pour atteindre un niveau donné.
     *
     * @param niveau Niveau cible.
     * @return Expérience cumulée nécessaire pour atteindre ce niveau.
     */

    fun palierExp(niveau: Int): Double {
        return 100* (niveau-1).toDouble().pow(2.0)
        //obligé de passer en double ici
    }

    fun levelUp(){

    }
}