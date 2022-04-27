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
		//left key press
		if (keyCode == LEFT)
		{
			//if at first nematode
			if(selectedNematode == 0)
			{
				//set to last nematode
				selectedNematode = nematodes.size() - 1;
			}//end if statement
			//if not at first nematode
			else
			{
				//decrement by 1
				selectedNematode = selectedNematode - 1;
			}//end else statement
		}//end if statement
		//right key press
		if (keyCode == RIGHT)
		{
			//if at last nematode
			if(selectedNematode == (nematodes.size() - 1))
			{
				//set to first nematode
				selectedNematode = 0;
			}//end if statement
			//if not at last nematode
			else
			{
				//increment by 1
				selectedNematode = selectedNematode + 1;
			}//end else statement
		}//end if statement	
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

		//nematode setup
		int length = nematodes.get(selectedNematode).getNemLength();
		int limbs = nematodes.get(selectedNematode).getNemLimbs();
		String gender = nematodes.get(selectedNematode).getNemGender();
		int eyes = nematodes.get(selectedNematode).getNemEyes();

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
		for(int i = 1;i <= length;i++)
		{
			//limbs
			if(limbs == 1)
			{
				line(width/2 + 50, (height/8) + (50*i), width/2 - 50, (height/8) + (50*i));
			}//end if statement
			//gender part 1
			if(((gender.contains("m") == true) || (gender.contains("h") == true))&& i == length)
			{
				line(width/2,(height/8) + (50*i),width/2,(height/8) + (50*i) + 40);
				ellipse(width/2,(height/8) + (50*i) + 40,10,10);
			}//end if statement
			//eyes
			if(eyes == 1 && i == 1)
			{
				line(width/2,(height/8) + (50*i),width/2+30,(height/8) + (50*i) - 40);
				line(width/2,(height/8) + (50*i),width/2-30,(height/8) + (50*i) - 40);
				ellipse(width/2+30,(height/8) + (50*i) - 40,10,10);
				ellipse(width/2-30,(height/8) + (50*i) - 40,10,10);
			}//end if statement
			//main body
			ellipse(width/2,(height/8) + (50*i),50,50);
			//gender part 2
			if(((gender.contains("f") == true) || (gender.contains("h") == true))&& i == length)
			{
				ellipse(width/2,(height/8) + (50*i),25,25);
			}//end if statement

		}//end for loop

	}//end draw method

}//end class
