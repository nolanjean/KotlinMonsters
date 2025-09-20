package org.example.dresseur

import org.example.monstre.individuMonstre

class MonsterKube(id: Int, nom: String, description: String, var chanceCapture: Double): Item(id, nom, description), Utilisable {
    override fun utiliser(cible: individuMonstre): Boolean {
        println("Vous lancez la Monster Kube !")
        if (cible.entraineur!=null){
            println("Le monstre ne peut pas être capturé.")
        }else{
            val ratioVie = cible.pv / cible.pvMax
            var chanceEffective = chanceCapture * (1.5 - ratioVie) // voir prof pour coerceAtLearst car ici pas d'utilité
            if (chanceEffective < 5.0){
                chanceEffective = 5.0
            }
            val nbAleatoire = (0..100).random()
            if (nbAleatoire < chanceEffective){
                println("Le monstre est capturé !")
                cible.renommer()
                if (joueur.equipeMonstre.size >= 6){ // joueur en rouge, en attente de finir la fonction ???
                    // peut être ajouté un constructeur à la classe entraineur
                    joueur.boiteMonstres.add(cible)

                }else{
                    joueur.equipeMonstre.add(cible)
                }

            }else{
                println("Presque ! Le Kube n'a pas pu capturer le monstre !")
            }
        }
    }

}