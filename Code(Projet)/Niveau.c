#include <graph.h>
#include <stdio.h>
#include <stdlib.h>
#include "Menu.h"
#include "Niveau.h"
#include "Jeu.h"

int Niveau() {
  while (True) {
    ChargerImageFond("img/BCK1.png");
    if (SourisCliquee()) {
      /* Bouton Retour*/
      if (0 <= _X && _X <= 75 && 0 <= _Y && _Y <= 78) {
        return EXIT_SUCCESS;
      }
      /* Bouton Débutant*/
      if (556 <= _X && _X <= 769 && 95 <= _Y && _Y <= 168) {
        FermerGraphique();
        Jeu(1);
      }
      /* Bouton Confirmé*/
      if (558 <= _X && _X <= 800 && 256 <= _Y && _Y <= 321) {
        FermerGraphique();
        Jeu(2);
      }
      /* Bouton Expert*/
      if (556 <= _X && _X <= 815 && 379 <= _Y && _Y <= 448) {
        FermerGraphique();
        Jeu(3);
      }
    }
  }
}
