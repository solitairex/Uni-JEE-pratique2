on a créer un project Spring Initializer avec les dépendances JPA, H2, Spring Web et Lombock

on a commencé par creer un package entités qui contiennent toutes les classes qu'on va utiliser Consultation,Medecin,Patient,RendezVous et StatusRDV avec leur attributs privés et collections dans le package "entités"

![1](https://github.com/solitairex/Uni-JEE-pratique2/assets/149163002/9719df9f-ea98-420c-89a2-c3a386588422)


puis on a creé un autre package qui contient les interface repository de ces classes , ces interfaces sont extend par JpaRepository fonctionne comme un crud (Create Read Update Delete) ils vont permettre de stocker et manipuler les données de l'hopital , voici a quoi ressemble application propreties 


![2](https://github.com/solitairex/Uni-JEE-pratique2/assets/149163002/c060fc13-c517-447a-84ca-70d77aa9fea2)




et voici les methodes qui vont permettre de stocker les patients , medecins , consultations et rendezvous;



![3](https://github.com/solitairex/Uni-JEE-pratique2/assets/149163002/2bab201f-4dd8-4fb7-ae0c-cf7f98255a40)




on a aussi un controller qui va permettre de nous lister les patients quand on met localhost/patients



![4](https://github.com/solitairex/Uni-JEE-pratique2/assets/149163002/03da6d9a-9a6c-4786-8721-e1bdff6f638d)



Qui va nous donner ce resultat:



![5](https://github.com/solitairex/Uni-JEE-pratique2/assets/149163002/0dd4215c-cccc-4737-a910-5c84846e14b5)


et l'application qui va executer notre projet:




![6](https://github.com/solitairex/Uni-JEE-pratique2/assets/149163002/94a6036a-4e15-4640-a56b-00651e8fac28)




enfin voici les parametres utilisé:




![7](https://github.com/solitairex/Uni-JEE-pratique2/assets/149163002/433e7c19-cf10-4cda-8cce-b78678c76898)









![8](https://github.com/solitairex/Uni-JEE-pratique2/assets/149163002/a37a3ff6-4286-4a23-98d7-d2051c8ab160)

