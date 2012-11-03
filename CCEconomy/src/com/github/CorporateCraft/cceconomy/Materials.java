package com.github.CorporateCraft.cceconomy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Material;

public class Materials
{
	private static final int MaxItems = 2366;
	
	public static void UpdateSell()
	{
		if(Formatter.FileEmpty(CCEconomy.sellfile))
		{
			ArrayList<String> SellList = new ArrayList<String>();
			for(int i = 0; i < MaxItems; i++)
			{
				try
				{
					SellList.add(idToName(Material.getMaterial(i).getId()).replaceAll("_", "") + " null");
				}
				catch(Exception e){}
			}
			Formatter.WriteFile(CCEconomy.sellfile, SellList);
		}
		ArrayList<String> SellList = UpdateForNew(CCEconomy.sellfile);
		Formatter.WriteFile(CCEconomy.sellfile, SellList);
	}
	
	public static void UpdateBuy()
	{
		if(Formatter.FileEmpty(CCEconomy.buyfile))
		{
			ArrayList<String> BuyList = new ArrayList<String>();
			for(int i = 0; i < MaxItems; i++)
			{
				try
				{
					BuyList.add(idToName(Material.getMaterial(i).getId()).replaceAll("_", "") + " null");
				}
				catch(Exception e){}
			}
			Formatter.WriteFile(CCEconomy.buyfile, BuyList);
		}
		ArrayList<String> BuyList = UpdateForNew(CCEconomy.buyfile);
		Formatter.WriteFile(CCEconomy.buyfile, BuyList);
	}
	
	private static ArrayList<String> UpdateForNew(String file)
	{
		ArrayList<String> New = new ArrayList<String>();
		ArrayList<String> Current = new ArrayList<String>();
		ArrayList<String> MatList = new ArrayList<String>();
		for(int i = 0; i < MaxItems; i++)
		{
			try
			{
				MatList.add(idToName(Material.getMaterial(i).getId()));
			}
			catch(Exception e){}
		}
		try
		{
		    FileReader reader = new FileReader(file);
		    BufferedReader buff = new BufferedReader(reader);
		    while(true)
		    {
		    	String inputText = buff.readLine();
		        if(inputText == null)
		        {
		         	break;
		        }
		        Current.add(inputText);
		    }
		}
		catch (IOException ex){}
		Boolean count = false;
		for(int i = 0; i < MatList.size(); i++)
		{
			for(int j = 0; j < Current.size(); j++)
			{
				if(MatList.get(i).equalsIgnoreCase(Current.get(j).split(" ")[0]))
				{
					New.add(Current.get(j).replaceAll("_", ""));
					count = true;
				}
				if(count == false)
				{
					if(j + 1 == Current.size())
					{
						New.add(MatList.get(i).replaceAll("_", "") + " null");
					}
				}
			}
			count = false;
		}
		return New;
	}
	
	public static String idToName(int id)
	{
	    return Material.getMaterial(id).name();
	}
}