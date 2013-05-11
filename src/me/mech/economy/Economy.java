package me.mech.economy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Economy extends JavaPlugin implements Listener{
	
	
	public final HashMap<Player, ArrayList<Player>> hashmap = new HashMap<Player, ArrayList<Player>>();
	public boolean playerExists(String name) {return false;}
	public boolean hasEnough(String name, double amount) {return false;} 
	private final List<String> PLAYERS = new ArrayList<String>(); // create ArrayList// create ArrayList
	private final Random RANDOM = new Random(); // create Random
	boolean addPlayer(Player player){ return !(PLAYERS.add(player.getName())); }
	void subtract(double money) {} 
	void add(String name, double money){}
	public final Player pickRandomRaffle(int five){
		    int index = RANDOM.nextInt(PLAYERS.size()); // get Random Index
		    String name = PLAYERS.get(index); // get Name
		    if(name == null) return null; // if Name not found return null
		    return Bukkit.getPlayer(name); // else return player
		    
	}

    

	
	
	
	
		public void onEnable() {
				getServer().getPluginManager().registerEvents(this, this);
				getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

					@Override
					public void run() {
				pickRandomRaffle(500);
							
				
					}
					
					
				}, 100000);
		}
	
	
		@EventHandler
		public void cardGame(PlayerInteractEvent e) {
			Player p = e.getPlayer();
				if(e.getClickedBlock().equals(Material.SIGN));
				Block block = e.getClickedBlock();
				BlockState state = block.getState();
				Sign sign = (Sign)state;
					if(sign.getLine(1).equalsIgnoreCase("Raffle")){
						String raffle = null;
								if(hasEnough(raffle, 100)){
									addPlayer(p);
									subtract(100);
									p.sendMessage("[Raffle] Good luck!!");
						
								
								
								}
					}
			
			}
		@EventHandler
		public void scoreboard(PlayerJoinEvent e1) {
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			Scoreboard board = manager.getNewScoreboard();
			Team team = board.registerNewTeam(ChatColor.RED + "aMechanics");
			Objective objective = board.registerNewObjective("test", "dummy");
			Score score = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Kills:")); 
			score.setScore(0);
			Player p = e1.getPlayer();
			team.addPlayer(p);
			
		}
		
	@EventHandler
	public void checkPlayed(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(p.hasPlayedBefore()){
			p.sendMessage(ChatColor.GOLD + "===$---$===" + ChatColor.YELLOW + "Welcome back to " + ChatColor.GOLD + "$===$---$===");
			p.sendMessage(ChatColor.GOLD + "===$---$===" + ChatColor.RED + "       Hell! " + ChatColor.GOLD + "$===$---$===");
		} else {
			p.sendMessage(ChatColor.GOLD + "===$---$===" + ChatColor.YELLOW + "Welcome to " + ChatColor.GOLD + "$===$---$===");
			p.sendMessage(ChatColor.GOLD + "===$---$===" + ChatColor.RED + "  Hell! " + ChatColor.GOLD + "$===$---$===");
		}
	}
	


}
