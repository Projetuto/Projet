#include "Aide.h"
#include "Menu.h"
#include <graph.h>
#include <stdio.h>
#include <stdlib.h>

int Aide() {
  while (True) {
    ChargerImageFond("img/Aide.png");
    if (SourisCliquee()) {
      if (0 <= _X && _X <= 90 && 0 <= _Y && _Y <= 67) {
        return EXIT_SUCCESS;
      }
    }
  }
}
