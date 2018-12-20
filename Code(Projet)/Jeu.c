#include "Jeu.h"
#include "Niveau.h"
#include "Retour.h"
#include <graph.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define NOMBRE_CASES_COTE_FACILE 4
#define NOMBRE_CASES_FACILE 16

#define NOMBRE_CASES_COTE_CONFIRME 6
#define NOMBRE_CASES_CONFIRME 36

#define NOMBRE_CASES_COTE_EXPERT 8
#define NOMBRE_CASES_EXPERT 64

#define TEMPS_REVELATION 1000000

int Jeu(int niveau) {

  int nombre_Case_Cote;
  int nombre_Cases;

  int tab[64] = {1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,
                 7,  8,  8,  9,  9,  10, 10, 11, 11, 12, 12, 13, 13,
                 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20,
                 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26,
                 27, 27, 28, 28, 29, 29, 30, 30, 31, 31, 32, 32};
  int drapeau;
  int nbr_hasard;
  char nom_Image[10];
  char Temps[10];
  int x, y;
  int x_Tentative1, y_Tentative1;
  int position_Image, position_Image_Tentative1;
  int tentative;
  long int suivant, t1;
  int t3 = 0;
  int nbr_victoire = 0;
  int tab2[64];
  int tab3[64];
  int etat[64];
  int i, j;

  if (niveau == 1) { /*On donne une valeur aux deux variables en fonction du niveau*/
    nombre_Case_Cote = NOMBRE_CASES_COTE_FACILE;
    nombre_Cases = NOMBRE_CASES_FACILE;
  } else if (niveau == 2) {
    nombre_Case_Cote = NOMBRE_CASES_COTE_CONFIRME;
    nombre_Cases = NOMBRE_CASES_CONFIRME;
  } else if (niveau == 3) {
    nombre_Case_Cote = NOMBRE_CASES_COTE_EXPERT;
    nombre_Cases = NOMBRE_CASES_EXPERT;
  }

  InitialiserGraphique();
  if (niveau == 1) {
    CreerFenetre(700, 285, nombre_Case_Cote * 78, (nombre_Case_Cote + 1) * 78);
  } else if (niveau == 2) {
    CreerFenetre(600, 195, nombre_Case_Cote * 78, (nombre_Case_Cote + 1) * 78);
  } else if (niveau == 3) {
    CreerFenetre(550, 175, nombre_Case_Cote * 78, (nombre_Case_Cote + 1) * 78);
  }

  ChoisirCurseur(2);
  ChoisirTitreFenetre("Projet memory");
  srand(time(NULL));

  for (i = 0; i < nombre_Cases; i++) {
    tab3[i] = -1; /*On remplit tab3 de valeurs impossible à trouver pour le
                     tirage des valeurs aléatoires*/
    etat[i] = 0;  /*On met l'état de toute les images à 0*/
  }

  for (i = 0; i < nombre_Cases;
       i++) { /*Dans cette boucle on mélange les images*/
    drapeau = 1;
    nbr_hasard = (rand() % nombre_Cases);
    for (y = 0; y < nombre_Cases; y++) {
      if (nbr_hasard == tab3[y]) {
        drapeau = 0;
      }
    }
    if (drapeau == 1) {
      tab2[i] = nbr_hasard;
      tab3[i] = tab2[i];
    } else if (drapeau == 0) {
      i--;
    }
  }
  for (i = 0; i < nombre_Cases; ++i) {
    tab3[tab2[i]] = tab[i];
  } /*Fin du mélange*/

  for (i = 0; i < nombre_Case_Cote; i++) { /*Impression du cadre de jeu*/
    for (j = 0; j < nombre_Case_Cote; j++) {
      ChargerImage("img/cache.png", i * 78, j * 78, 0, 0, 78, 78);
    }
  }
  for (i = 0; i < nombre_Case_Cote; i++) {
    for (j = 0; j < nombre_Case_Cote; j++) {
      ChargerImage("img/memory.png", i * 78, j * 78, 0, 0, 78, 78);
    }
  } /*Impression terminé*/

  suivant = Microsecondes() + 1000000; /*Lancement du compteur*/

  while (nbr_victoire < nombre_Cases) { /*Lancement du jeu*/

    for (tentative = 0; tentative < 2;) { /*On compte les tentatives*/

      if (ToucheEnAttente() && Touche() == 116) { /*On vérifie si le mode Triche est lancé*/
        for (i = 0; i < nombre_Cases; i++) { /*Si oui on affiche les images*/
          x = i / nombre_Case_Cote;
          y = i % nombre_Case_Cote;
          sprintf(nom_Image, "img/M%d.png", tab3[i]);
          ChargerImage(nom_Image, x * 78, y * 78, 0, 0, 78, 78);
          ChargerImage("img/memory.png", x * 78, y * 78, 0, 0, 78, 78);
        }
        for (i = 0; i < nombre_Case_Cote; i++) {
          for (j = 0; j < nombre_Case_Cote; j++) {
            ChargerImage("img/memory.png", i * 78, j * 78, 0, 0, 78, 78);
          }
        } /*Fin affichage des images*/

        drapeau = 1;
        while (drapeau) {
          while (SourisCliquee()) {
          }
          if (ToucheEnAttente() && Touche() == 116) {
            for (i = 0; i < nombre_Case_Cote; i++) {
              for (j = 0; j < nombre_Case_Cote; j++) {
                ChargerImage("img/cache.png", i * 78, j * 78, 0, 0, 78, 78);
              }
            }
            for (i = 0; i < nombre_Cases; i++) {
              if (etat[i] == 1) {
                x = i / nombre_Case_Cote;
                y = i % nombre_Case_Cote;
                sprintf(nom_Image, "img/M%d.png", tab3[i]);
                ChargerImage(nom_Image, x * 78, y * 78, 0, 0, 78, 78);
              }
            }
            for (i = 0; i < nombre_Case_Cote; i++) {
              for (j = 0; j < nombre_Case_Cote; j++) {
                ChargerImage("img/memory.png", i * 78, j * 78, 0, 0, 78, 78);
              }
            }
            drapeau = 0;
          }
        }
      } /*Fin Mode Triche*/

      if (SourisCliquee() && _Y < nombre_Case_Cote * 78 &&
          _X < nombre_Case_Cote * 78) { /*On vérifie s'il n'y a pas clic*/

        x = _X / 78;
        y = _Y / 78;
        position_Image = x * nombre_Case_Cote + y;
        /*On sauvegarde les positions*/

        if (etat[position_Image]) {
          /*On vérifie si l'image selectionnée n'est pas déjà retourné*/

          printf("Image déjà retourné !\n");

        } else if (!etat[position_Image]) {

          sprintf(nom_Image, "img/M%d.png",
                  tab3[position_Image]); /*On affiche l'image clické*/
          ChargerImage(nom_Image, x * 78, y * 78, 0, 0, 78, 78);
          ChargerImage("img/memory.png", x * 78, y * 78, 0, 0, 78, 78);

          if (tentative == 0) { /*Au premier essai, aucune vérification n'est nécessaire, on
                      fait que savegarder les différentes position*/

            printf("Premier Essai\n");
            position_Image_Tentative1 = position_Image;
            x_Tentative1 = x;
            y_Tentative1 = y;
            etat[position_Image_Tentative1] = 1;

          } else if (tentative == 1) { /*Au 2e, il faut effectuer des vérifications*/

            printf("Deuxième essais\n");

            if (tab3[position_Image] != tab3[position_Image_Tentative1]) { /*Si les images ne sont pas
                                                      les memes alors :*/

              printf("Tu t'es trompé !\n");
              t1 = Microsecondes() + TEMPS_REVELATION;
              etat[position_Image_Tentative1] = 0;
              while (Microsecondes() < t1) {
              }
              /*Attente de 1 seconde ou plus (au choix au début)*/
              ChargerImage("img/cache.png", x * 78, y * 78, 0, 0, 78, 78);
              ChargerImage("img/memory.png", x * 78, y * 78, 0, 0, 78, 78);
              ChargerImage("img/cache.png", x_Tentative1 * 78,
                           y_Tentative1 * 78, 0, 0, 78, 78);
              ChargerImage("img/memory.png", x_Tentative1 * 78,
                           y_Tentative1 * 78, 0, 0, 78, 78);

            } else if (tab3[position_Image] == tab3[position_Image_Tentative1]) { /*Si les images sont
                                                             les mêmes alors :*/

              printf("Bravo !\n");
              nbr_victoire = nbr_victoire + 2;
              etat[position_Image] = 1;
              etat[position_Image_Tentative1] = 1;
            }
          }
          tentative = tentative + 1;
        }
      }
      if (Microsecondes() > suivant) { /*Ici on gère le temps*/
        ChoisirCouleurDessin(CouleurParNom("white"));
        RemplirRectangle(0, nombre_Case_Cote * 78, nombre_Case_Cote * 78, 78);
        t3 = t3 + 1;
        sprintf(Temps, "Temps : %d", t3);
        ChoisirCouleurDessin(CouleurParNom("black"));
        EcrireTexte(0, (nombre_Case_Cote)*78 + 60, Temps, 2);
        suivant = Microsecondes() + 1000000;
      }
    }
  }

  FermerGraphique();
  Retour();
  return EXIT_SUCCESS;
}
