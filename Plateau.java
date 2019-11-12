import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


// 0 : Case dispo = Bleu
// 4 : Case non-dispo = Rouge
// 2 : Joueur 1 = Vert
// 3 : Joueur 2 = Violet



public class Plateau extends JPanel implements MouseListener
{
	public int[][] plat;
	private int l,h;
	
	public Image bloc_bleu, bloc_rouge;
	public int dimx = 31;
	public int dimy = 31;
	
	
		public Plateau(int _l = 8, int _h = 8)
		{
			bloc_bleu = ImageIO.read(new File("bleu.gif"));
			bloc_rouge = ImageIO.read(new File("rouge.gif"));
			
			
			l = _l;
			h = _h;
			
			plat = new int [_l+2][_h+2];
			
			for( int i = 1; i < _l+1 ; ++i)
			{
				for( int j = 1; j < _h+1 ; ++j)
				{
					plat[i][j] = 0;
				}
			}
			 
			for(int i = 0; i < _l+2; ++i)
			{
				plat[i][0] = 4;
				plat[i][_h+2] = 4;
			}
		
			for(int i = 0; i < _h+2; ++i)
			{
				plat[0][i] = 4;
				plat[_l+2][i] = 4;
			}
			
			setPreferredSize(new Dimension(_l*dimx, dimy*_h);
			addMouseListener(this);
			
		}
		
		
		public const int getl()
		{ 
			return l;
		}
		public const int geth()
		{ 
			return h;
		}
		
		public void jouer()
		{

		}
		
		public boolean vérif(int s_x, int s_y, int num_adverse) //On regarde on est le pion du joueur pour ensuite voir si le pion ne peut plus bouger 
		{										//On recup les coordonnées d'un point grâce au getx et gety et le numéro du pion adverse 
			int verif = 0;
			
			for(i = s_x - 1; i <= s_x+1; ++i)
			{
				verif = verif + plat[i][s_y-1];
				verif = verif + palt[i][s_y+1];
			}
			
			verif = verif + plat[i-1][s_y];
			verif = verif + palt[i+1][s_y];
			
			if(verif == 32 || verif == 28 + num_adverse)  // On regarde si il est entouré de cases indisponibles ou de 7 cases indisponibles + le joueur adverse
			{
				return true;
			}
			else
			{
				return false;
			}
						
		}
		
		public void mousePressed(MouseEvent e)
		{
			int bouton = e.getButton();
			
			if (bouton == MouseEvent.BUTTON1)
				modifieTableau(e.getX(), e.getY(), 1);
				repaint();
			else if (bouton == MouseEvent.BUTTON3)
				modifieTableau(e.getX(), e.getY(), 0);
		}
 
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		
}
	