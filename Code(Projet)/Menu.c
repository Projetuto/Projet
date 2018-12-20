#include "Aide.h"
#include "Menu.h"
#include "Niveau.h"
#include <graph.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
  InitialiserGraphique();
  CreerFenetre(450, 200, 960, 540);
  ChoisirCurseur(2);
  ChoisirTitreFenetre("Projet memory");

  while (True) {
    ChargerImageFond("img/BCK.png");

    if (SourisCliquee()) {

      /* Bouton Aide*/
      if (0 <= _X && _X <= 75 && 0 <= _Y && _Y <= 67) {
        Aide();
      }
      /* Bouton Quitter*/
      if (544 <= _X && _X <= 806 && 342 <= _Y && _Y <= 434) {
        exit(1);
      }
      /* Bouton Niveau*/
      if (556 <= _X && _X <= 759 && 148 <= _Y && _Y <= 229) {
        Niveau();
      }
    }
  }

  FermerGraphique();
  return EXIT_SUCCESS;
}
