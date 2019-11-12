import java.util.*
import java.lang.Math;

public class IA
{
	public int num_pion_ia;
	
	private int init_x_ia;
	private int init_y_ia;
	
	public IA(int n_p_ia)
	{
		num_pion_ia = n_p_ia;
		
		int x_joueur = getx();
		int y_joueur = gety();
		
		int min = 0;
		int max = getl()-1;
		
		int x_ia = (int)(Math.random()*( max - mini + 1 ) ) + mini;
		
		min = 0;
		max = geth()-1;
		
		int y_ia = (int)(Math.random()*( max - mini + 1 ) ) + mini;
		
		while(x_ia == x_joueur && y_ia == y_joueur)
		{
			int min = 0;
			int max = getl()-1;
		
			int x_ia = (int)(Math.random()*( max - mini + 1 ) ) + mini;
		
			min = 0;
			max = geth()-1;
		
			int y_ia = (int)(Math.random()*( max - mini + 1 ) ) + mini;
		}
		
		init_x_ia = x_ia;
		init_y_ia = y_ia;
			
		plat[x_ia][y_ia] = num_pion_ia;
	}
	
	public const int getx_ia()
	{ 
		return init_x_ia;
	}
	
	public const int gety_ia()
	{ 
		return init_y_ia;
	}
	
//////////////////////////////////////////Changement PLACE ///////////////////////////////////////////////////////////////	
		
	public void choisir_new_place_ia() //cherche la case avec le plus grand nombre de possibilités de déplacements
	{
		int best_x;
		int best_y;
		
		int valeur = 32;
		int valeur_tmp = 0;
		
		for(int i = init_x_ia - 1; i <= init_x_ia + 1; ++i)
		{
			if(plat[i][init_y_ia-1] != 1 && plat[i][init_y_ia-1] != num_pion)
			{
				for(int j = i - 1; j <= i + 1; ++j)
				{
					valeur_tmp = valeur_tmp + plat[j][init_y_ia];
					valeur_tmp = valeur_tmp + plat[j][init_y_ia-2];
				}
				
				valeur_tmp = valeur_tmp + plat[i-1][init_y_ia-1];
				valeur_tmp = valeur_tmp + plat[i+1][init_y_ia-1];
				
				if(valeur_tmp < valeur)
				{
					best_x = i;
					best_y = init_y_ia - 1;
					valeur = valeur_tmp;
				}
				
				valeur_tmp = 0;
			}
			
			if(plat[i][init_y_ia+1] != 1 && plat[i][init_y_ia+1] != num_pion)
			{
				for(int j = i - 1; j <= i + 1; ++j)
				{
					valeur_tmp = valeur_tmp + plat[j][init_y_ia];
					valeur_tmp = valeur_tmp + plat[j][init_y_ia+2];
				}
				
				valeur_tmp = valeur_tmp + plat[i-1][init_y_ia+1];
				valeur_tmp = valeur_tmp + plat[i+1][init_y_ia+1];
				
				if(valeur_tmp < valeur)
				{
					best_x = i;
					best_y = init_y_ia + 1;
					valeur = valeur_tmp;
				}
				
				valeur_tmp = 0;
			}
		}
		
		if(plat[init_x_ia-1][init_y_ia] != 1 && plat[init_x_ia-1][init_y_ia] != num_pion)
		{
			for(int j = init_x_ia - 2; j <= init_x_ia; ++j)
			{
				valeur_tmp = valeur_tmp + plat[j][init_y_ia-1];
				valeur_tmp = valeur_tmp + plat[j][init_y_ia+1];
			}
				
			valeur_tmp = valeur_tmp + plat[init_x_ia-2][init_y_ia];
			valeur_tmp = valeur_tmp + plat[init_x_ia][init_y_ia];
				
			if(valeur_tmp < valeur)
			{
				best_x = init_x_ia-1;
				best_y = init_y_ia;
				valeur = valeur_tmp;
			}
				
			valeur_tmp = 0;
		}
			
		if(plat[init_x_ia+1][init_y_ia] != 1 && plat[init_x_ia-1][init_y_ia] != num_pion)
		{
			for(int j = init_x_ia; j <= init_x_ia + 2; ++j)
			{
				valeur_tmp = valeur_tmp + plat[j][init_y_ia-1];
				valeur_tmp = valeur_tmp + plat[j][init_y_ia+1];
			}
				
			valeur_tmp = valeur_tmp + plat[init_x_ia][init_y_ia];
			valeur_tmp = valeur_tmp + plat[init_x_ia+2][init_y_ia];
				
			if(valeur_tmp < valeur)
			{
				best_x = init_x_ia+1;
				best_y = init_y_ia;
				valeur = valeur_tmp;
			}
			valeur_tmp = 0;
		}
		
		plat[init_x_ia][init_y_ia] = 0;
		
		init_x_ia = best_x;
		init_y_ia = best_y;
		
		plat[best_x][best_y] = num_pion_ia;
		
	}
	
	
//////////////////////////////////////////////////Destruction CASE/////////////////////////////////////////////////////////////////	

	public void detruire_case_ia(int x, int y) //prend en parametre les coordonnées du pion du joueur grâce aux getx et gety;
	{											// on détruit le chemin avec le plus de possibilités
		int best_x;
		int best_y;
		
		int valeur = 32;
		int valeur_tmp = 0;
		
		for(int i = x - 1; i <= x + 1; ++i)
		{
			if(plat[i][y-1] != 1 && plat[i][y-1] != num_pion_ia)
			{
				for(int j = i - 1; j <= i + 1; ++j)
				{
					valeur_tmp = valeur_tmp + plat[j][y];
					valeur_tmp = valeur_tmp + plat[j][y-2];
				}
				
				valeur_tmp = valeur_tmp + plat[i-1][y-1];
				valeur_tmp = valeur_tmp + plat[i+1][y-1];
				
				if(valeur_tmp < valeur)
				{
					best_x = i;
					best_y = y - 1;
					valeur = valeur_tmp;
				}
				
				valeur_tmp = 0;
			}
			
			if(plat[i][y+1] != 1 && plat[i][y+1] != num_pion_ia)
			{
				for(int j = i - 1; j <= i + 1; ++j)
				{
					valeur_tmp = valeur_tmp + plat[j][y];
					valeur_tmp = valeur_tmp + plat[j][y+2];
				}
				
				valeur_tmp = valeur_tmp + plat[i-1][y+1];
				valeur_tmp = valeur_tmp + plat[i+1][y+1];
				
				if(valeur_tmp < valeur)
				{
					best_x = i;
					best_y = y + 1;
					valeur = valeur_tmp;
				}
				
				valeur_tmp = 0;
			}
		}
		
		if(plat[x-1][y] != 1 && plat[x-1][y] != num_pion_ia)
		{
			for(int j = x - 2; j <= x; ++j)
			{
				valeur_tmp = valeur_tmp + plat[j][y-1];
				valeur_tmp = valeur_tmp + plat[j][y+1];
			}
				
			valeur_tmp = valeur_tmp + plat[x-2][y];
			valeur_tmp = valeur_tmp + plat[x][y];
				
			if(valeur_tmp < valeur)
			{
				best_x = x-1;
				best_y = y;
				valeur = valeur_tmp;
			}
				
			valeur_tmp = 0;
		}
			
		if(plat[x+1][y] != 1 && plat[x-1][y] != num_pion_ia)
		{
			for(int j = x; j <= x + 2; ++j)
			{
				valeur_tmp = valeur_tmp + plat[j][y-1];
				valeur_tmp = valeur_tmp + plat[j][y+1];
			}
				
			valeur_tmp = valeur_tmp + plat[x][y];
			valeur_tmp = valeur_tmp + plat[x+2][y];
				
			if(valeur_tmp < valeur)
			{
				best_x = x+1;
				best_y = y;
				valeur = valeur_tmp;
			}
			valeur_tmp = 0;
		}
		
		plat[best_x][best_y] = 4;
	}
}				