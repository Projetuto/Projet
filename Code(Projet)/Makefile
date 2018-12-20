but : Main

OFILES=Menu.o \
       Aide.o \
       Jeu.o \
			 Retour.o \
       Niveau.o
CC = gcc


Aide.o : Aide.h  Menu.h

Niveau.o : Niveau.h  Menu.h

Retour.o : Retour.h Niveau.h

Menu.o : Menu.h  Aide.h Niveau.h


Main : $(OFILES)
	$(CC) -o Main $(OFILES) -lgraph

clean :
	-rm -f $(OFILES) Main
