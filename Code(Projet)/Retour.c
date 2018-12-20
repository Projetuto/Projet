#include "Niveau.h"
#include "Retour.h"
#include <graph.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int Retour() {

  InitialiserGraphique();
  CreerFenetre(450, 200, 960, 540);
  ChoisirCurseur(2);
  ChoisirTitreFenetre("Projet memory");

  while (True) {
    ChargerImageFond("img/rejouer.png");

    if (SourisCliquee()) {
      /*Bouton Niveau*/
      if (380 <= _X && _X <= 605 && 237 <= _Y && _Y <= 315) {
        ChargerImageFond("img/BCK.png");
        Niveau();
      }
      /* Bouton Quitter*/
      if (387 <= _X && _X <= 576 && 405 <= _Y && _Y <= 477) {
        exit(1);
      }
    }
  }

  return EXIT_SUCCESS;
}
