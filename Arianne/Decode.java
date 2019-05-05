    import java.io.*;
    import java.util.*;
    import java.lang.*;
    import javax.swing.JComponent;
    import java.awt.*;


public class Decode extends JComponent{
	private	int largeur,hauteur;

		public Decode(int xR,int yR){
		
		this.largeur=xR-1;

		String largeurbinairevrai =  Integer.toBinaryString(largeur);
		this.hauteur=yR-1;
		String hauteurbinairevrai = Integer.toBinaryString(hauteur);

		Ecriture sauv = new Ecriture(largeurbinairevrai,hauteurbinairevrai);

}

}
	

//---------------------------------------------------

               
    

    

		



