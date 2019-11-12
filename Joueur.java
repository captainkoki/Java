import java.util.*
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Joueur
{
	public int num_pion;
	
	private int init_x;
	private int init_y;
	
	public Joueur(int n_p, int x, int y)
	{
		num_pion = n_p;
		init_x = x;
		init_y = y;
		plat[x][y] = num_pion;
	}
	
	public const int getx()
	{ 
		return init_x;
	}
	
	public const int gety()
	{ 
		return init_y;
	}
	
	public void choisir_new_place(int x, int y)
	{
		plat[init_x][init_y] = 0;
		
		init_x = x/getl();
		init_y = y/geth();
		
		plat[init_x][init_y] = num_pion;
		
	}
	
	public void choisir_destruct_place(int x, int y)
	{
		plat[x][y] = 4;
	}
}