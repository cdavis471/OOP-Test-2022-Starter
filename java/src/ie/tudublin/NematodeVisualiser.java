package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	//declare array list of nematode objects
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
		loadNematodes();//load csv file and populate ArrayList
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();				
	}
	
	//loadNematodes method
	public void loadNematodes()
	{
		//load the csv file as table
		Table nematodeTable = loadTable("../data/nematodes.csv","header");
		//for loop to iterate through the table rows
		for(TableRow row:nematodeTable.rows())
		{
			//create new nematode object passing the table row as a parameter
			Nematode nematode = new Nematode(row);
			//add it to array list
			nematodes.add(nematode);
		}//end for loop
	}//end loadNematodes method

	public void draw()
	{

	}

}//end class
