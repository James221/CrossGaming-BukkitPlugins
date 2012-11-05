package com.github.CorporateCraft.cceconomy.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.github.CorporateCraft.cceconomy.*;

public class CmdCost
{
	public static boolean CommandUse(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (args.length > 1)
			{
				return false;
			}
			if(player.hasPermission("CCEconomy.cost"))
			{
				String ItemName = "";
				try
				{
					ItemName = args[0];
				}
				catch (Exception e)
				{
					ItemName = Integer.toString(player.getItemInHand().getTypeId());
				}
				if(Formatter.isLegal(ItemName))
				{
					ItemName = Materials.idToName(Integer.parseInt(ItemName));
				}
				ItemName = Materials.FindItem(ItemName);
				if(!Materials.ItemExists(ItemName))
				{
					player.sendMessage(CCEconomy.messages + "That item does not exist");
					return true;
				}
				String cost = Prices.Cost(CCEconomy.buyfile, ItemName);
				ItemName = Formatter.CapFirst(ItemName);
				if(cost == null)
				{
					player.sendMessage(CCEconomy.messages + ItemName + " cannot be bought from the server");
					return true;
				}
				if(cost.equalsIgnoreCase("null"))
				{
					player.sendMessage(CCEconomy.messages + ItemName + " cannot be bought from the server");
					return true;
				}
				player.sendMessage(CCEconomy.messages + ItemName + " costs " + CCEconomy.money + "$" + cost);
				return true;
			}
		}
		else
		{
			if (args.length != 1)
			{
				return false;
			}
			String ItemName = args[0];
			if(Formatter.isLegal(ItemName))
			{
				ItemName = Materials.idToName(Integer.parseInt(ItemName));
			}
			ItemName = Materials.FindItem(ItemName);
			if(!Materials.ItemExists(ItemName))
			{
				sender.sendMessage(CCEconomy.messages + "That item does not exist");
				return true;
			}
			String cost = Prices.Cost(CCEconomy.buyfile, ItemName);
			ItemName = Formatter.CapFirst(ItemName);
			if(cost == null)
			{
				sender.sendMessage(CCEconomy.messages + ItemName + " cannot be bought from the server");
				return true;
			}
			if(cost.equalsIgnoreCase("null"))
			{
				sender.sendMessage(CCEconomy.messages + ItemName + " cannot be bought from the server");
				return true;
			}
			sender.sendMessage(CCEconomy.messages + ItemName + " costs " + CCEconomy.money + "$" + cost);
			return true;
		}
		return false;
	}
}