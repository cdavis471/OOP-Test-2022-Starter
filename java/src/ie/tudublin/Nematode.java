package ie.tudublin;

import processing.data.TableRow;

public class Nematode 
{

    //declare private variables
    private String name;
    private int length;
    private int limbs;
    private String gender;
    private int eyes;

    //name getter
    public String getNemName()
    {
        return name;
    }//end name getter

    //name setter
    public void setNemName(String name)
    {
        this.name = name;
    }//end name setter

    //length getter
    public int getNemLength()
    {
        return length;
    }//end length getter

    //length setter
    public void setNemLength(int length)
    {
        this.length = length;
    }//end length setter

    //limbs getter
    public int getNemLimbs()
    {
        return limbs;
    }//end limbs getter

    //limbs setter
    public void setNemLimbs(int limbs)
    {
        this.limbs = limbs;
    }//end length setter

    //gender getter
    public String getNemGender()
    {
        return gender;
    }//end gender getter

    //gender setter
    public void getNemGender(String gender)
    {
        this.gender = gender;
    }//end gender setter

    //eyes getter
    public int getNemEyes()
    {
        return eyes;
    }//end eyes getter

    //eyes setter
    public void setNemEyes(int eyes)
    {
        this.eyes = eyes;
    }//end eyes setter

    //nematode constructor
    public Nematode(String name, int length, int limbs, String gender, int eyes)
    {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }//end nematode constructor

    //table row constructor
    public Nematode(TableRow tRow)
    {
        this(tRow.getString("name"),tRow.getInt("length"),tRow.getInt("limbs"),tRow.getString("gender"),tRow.getInt("eyes"));
    }//end table row constructor

    //toString
    @Override
    public String toString()
    {
        return "Nematode - Name: " + name + " | Length: " + length + " | Limbs: " + limbs + " | Gender: " + gender + " | Eyes: " + eyes;
    }//end toString
    
}//end class
