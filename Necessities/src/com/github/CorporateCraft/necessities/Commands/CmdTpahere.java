package com.github.CorporateCraft.necessities.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.CorporateCraft.necessities.*;

public class CmdTpahere
{
	ArrayLists arl = new ArrayLists();
	public CmdTpahere()
	{
		
	}
	public boolean CommandUse(CommandSender sender, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (args.length != 1)
	        {
	      	   return false;
	        }
			String pname = player.getName();
			Player target = sender.getServer().getPlayer(args[0]);
			if(target == null)
			{
				return false;
			}
			String rname = target.getName();
			Teleports telp = new Teleports();
			telp.CreateTp(rname + " " + pname, "tome");
			player.sendMessage(arl.messages + "You sent a teleport request to " + rname);
			target.sendMessage(arl.messages + pname + " is requesting that you teleport to them");
			target.sendMessage(arl.messages + "Type /tpaccept or /tpdeny to accept or deny their teleport request");
			return true;
		}
		else
		{
			sender.sendMessage(arl.messages + "You are not a player you can't teleport.");
			return true;
		}
	}
}