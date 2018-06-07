package com.minecake147.cakesmod.weedmeals;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import com.minecake147.cakesmod.weedmeals.items.ItemWeedMeal;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = WeedMeals.MODID, version = WeedMeals.VERSION)
public class WeedMeals
{
    public static final String MODID = "WeedMeals";
    public static final String VERSION = "Alpha 1.0.0";
    public static final String RESDOMAIN = "weedmeals";
    public static Item itemWeedMeal;
    @EventHandler
	public void preInit(FMLPreInitializationEvent event) throws Exception
	{
    	itemWeedMeal = new ItemWeedMeal().setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("WeedMeal");
    	GameRegistry.registerItem(itemWeedMeal, "WeedMeal");
	}
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
}
