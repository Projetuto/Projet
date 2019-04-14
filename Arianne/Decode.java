    import java.io.*;
    import java.util.*;
    import java.lang.*;
    import javax.swing.JComponent;
    import java.awt.*;


public class Decode  extends JComponent{
	private GrilleCrea grille;
	private int e;
	private	int reste = 0;
	private	int reste2 = 0;
	private char inv = ' ';
	private String rep = "";
	private String rep2 = "";
	private	int largeur,hauteur;
	public Decode(GrilleCrea g,int longu){

			this.e=longu;
			this.grille = g;
//---------------------------------------------------------
			while(e > 1){
			reste = e % 2;
			e = e / 2;

			if (reste == 1){
				rep = rep + '1';

			}else{
				rep = rep + '0';
			}
				
		}
			if (e == 1){
			rep = rep + '1';
		}

		if (e == 0){
			rep = rep + '0';
		}
		int longueur = rep.length();
		int j,i;
		StringBuffer tailleCadre = (new StringBuffer(rep)).reverse(); 		     
		}


//---------------------------------------------------------



	public Decode(int xR,int yR){

	this.largeur=xR-1;
//---------------------------------------------------------

	while(largeur > 1){
			reste = largeur % 2;
			largeur = largeur / 2;

			if (reste == 1){
				rep = rep + '1';

			}else{
				rep = rep + '0';
			}
				
		}
			if (largeur == 1){
			rep = rep + '1';
		}

		if (largeur == 0){
			rep = rep + '0';
		}
		int longueur = rep.length();
		int j,i;
		StringBuffer largeurbinairefaux = (new StringBuffer(rep)).reverse();
		String largeurbinairevrai = largeurbinairefaux.toString();

//--------------------------------------------------------- 		     
	this.hauteur=yR-1;

	while(hauteur > 1){
			reste2 = hauteur % 2;
			hauteur = hauteur / 2;

			if (reste2 == 1){
				rep2 = rep2 + '1';

			}else{
				rep2 = rep2 + '0';
			}
				
		}
			if (hauteur == 1){
			rep2 = rep2 + '1';
		}

		if (hauteur == 0){
			rep2 = rep2 + '0';
		}
		StringBuffer hauteurbinairefaux = (new StringBuffer(rep2)).reverse();
		String hauteurbinairevrai = hauteurbinairefaux.toString();
		System.out.println(hauteurbinairevrai);


		Sauvegarde sauv = new Sauvegarde(largeurbinairevrai,hauteurbinairevrai);



}
}
	

//---------------------------------------------------

               
    

    

		



