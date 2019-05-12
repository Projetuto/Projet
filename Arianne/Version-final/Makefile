JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java


CLASSES= \
		AlgoDeterministe.java  \
        AlgoRand.java \
        AlgoRandMan.java \
        Analyse.java \
        Choix.java   \
        CopieGrille.java \
        Ecriture.java  \
        FenCrea2.java\
        FenCrea.java  \
        Fenetre2.java \
        FenManAuto.java\
        GrilleCrea.java  \
        GrilleTest.java \
        JFile.java  \
        Lecture.java  \
        Manuel.java  \
        Observateur2.java \
        Observateur.java  \
        VueAide.java  \
        VueDossier.java  \
        Main.java 


classes: $(CLASSES:.java=.class)

run:
	java Main -implicit:none 
clean :
	$(RM) *.class
	$(RM) save.mns
