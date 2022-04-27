package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	//declare array list of nematode objects
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();
	//declare variable for selecting nematode
	int selectedNematode = 0;

	//sift through the nematodes
	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}//end keyPressed

	public void settings()
	{
		size(800, 800);
		loadNematodes();//load csv file and populate ArrayList
	}//end settings

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();				
	}//end setup
	
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

		//graphic setup
		colorMode(HSB);
		background(0);

		//name
		textSize(20);
		textAlign(CENTER);
		fill(0,0,255);
		text(nematodes.get(selectedNematode).getNemName(), width/2, height/10);

		//length
		ellipseMode(CENTER);
		fill(0,0,0);
		strokeWeight(3);
		stroke(255,255,200);
		int length = nematodes.get(selectedNematode).getNemLength();
		for(int i = 1;i <= length;i++)
		{
			ellipse(width/2,(height/8) + (50*i),50,50);
		}//end for loop

	}//end draw method

}//end class
