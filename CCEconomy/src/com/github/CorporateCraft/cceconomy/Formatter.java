package com.github.CorporateCraft.cceconomy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Formatter
{
	public static boolean isLegal(String input)  
	{  
	   try  
	   {  
	      Double.parseDouble(input);  
	      return true;  
	   }  
	   catch(Exception e)  
	   {  
	      return false;  
	   }  
	}
	
	public static String roundTwoDecimals(double d)
	{
		DecimalFormat df = new DecimalFormat("0.00");
		String newdf = df.format(d);
        return newdf;
	}
	
	public static String CapFirst(String ToCap)
	{
		ArrayList<Character> CurrentWord = new ArrayList<Character>();
		ArrayList<Character> NewWord = new ArrayList<Character>();
		for(int i =0; i < ToCap.length(); i++)
		{
			CurrentWord.add(ToCap.charAt(i));
		}
		for(int i = 0; i < CurrentWord.size(); i++)
		{
			if(i == 0)
			{
				NewWord.add(Character.toUpperCase(CurrentWord.get(i)));
			}
			else
			{
				NewWord.add(Character.toLowerCase(CurrentWord.get(i)));
			}
		}
		String New = "";
		for(int i = 0; i < NewWord.size(); i++)
		{
			New = New + NewWord.get(i);
		}
		return New;
	}
	
	public static void WriteFile(String file, ArrayList<String> Info)
	{
		try
		{
			FileWriter writer = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(writer);
			for (int i = 0; i < Info.size(); i++)
			{
				bw.write(Info.get(i));
				bw.newLine();
			}
			bw.close();
		}
		catch (Exception e){}
	}
	
	public static Boolean FileEmpty(String file)
	{
		try
		{
		    FileReader reader = new FileReader(file);
		    BufferedReader buff = new BufferedReader(reader);
		    String inputText = buff.readLine();
		    if(inputText == null)
		    {
		    	return true;
		    }
		}
		catch (IOException ex)
		{
			return false;
		}
		return false;
	}
}