package com.minecake147.cakesmod.weedmeals.items;

import java.util.List;
import java.util.Random;

import com.minecake147.cakesmod.weedmeals.WeedMeals;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemWeedMeal extends Item {
	@SideOnly(Side.CLIENT)
    private IIcon[] IIconarray;
	private static final int num = 1;
	public ItemWeedMeal() {
		super();
	}

	public boolean canHarvestBlock(Block par1Block, ItemStack itemStack)
    {
        return false;
    }
	/**
     * This is called when the item is used, before the block is activated.
     * @param stack The Item Stack
     * @param player The Player that used the item
     * @param world The Current World
     * @param x Target X Position
     * @param y Target Y Position
     * @param z Target Z Position
     * @param side The side of the target hit
     * @return Return true to prevent any further processing.
     */
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
    	if(!world.isRemote && world.getBlock(x, y, z) instanceof BlockGrass){
    		int l = 0;
    		Random p_149853_2_ = new Random();
            while (l < 128)
            {
                int i1 = x;
                int j1 = y + 1;
                int k1 = z;
                int l1 = 0;

                while (true)
                {
                    if (l1 < l / 16)
                    {
                        i1 += p_149853_2_.nextInt(3) - 1;
                        j1 += (p_149853_2_.nextInt(3) - 1) * p_149853_2_.nextInt(3) / 2;
                        k1 += p_149853_2_.nextInt(3) - 1;

                        if (world.getBlock(i1, j1 - 1, k1) == Blocks.grass && !world.getBlock(i1, j1, k1).isNormalCube())
                        {
                            ++l1;
                            continue;
                        }
                    }
                    else if (world.getBlock(i1, j1, k1).getMaterial() == Material.air)
                    {
                    	if (Blocks.tallgrass.canBlockStay(world, i1, j1, k1))
                        {
                        	world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
                        }
                    }

                    ++l;
                    break;
                }
            }
            return true;
    	}
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public static void func_150918_a(World p_150918_0_, int p_150918_1_, int p_150918_2_, int p_150918_3_, int p_150918_4_)
    {
        Block block = p_150918_0_.getBlock(p_150918_1_, p_150918_2_, p_150918_3_);

        if (block.getMaterial() != Material.air)
        {
            block.setBlockBoundsBasedOnState(p_150918_0_, p_150918_1_, p_150918_2_, p_150918_3_);

            for (int i1 = 0; i1 < p_150918_4_; ++i1)
            {
                double d0 = itemRand.nextGaussian() * 0.02D;
                double d1 = itemRand.nextGaussian() * 0.02D;
                double d2 = itemRand.nextGaussian() * 0.02D;
                p_150918_0_.spawnParticle("happyVillager", (double)((float)p_150918_1_ + itemRand.nextFloat()), (double)p_150918_2_ + (double)itemRand.nextFloat() * block.getBlockBoundsMaxY(), (double)((float)p_150918_3_ + itemRand.nextFloat()), d0, d1, d2);
            }
        }
        else
        {
            for (int i1 = 0; i1 < p_150918_4_; ++i1)
            {
                double d0 = itemRand.nextGaussian() * 0.02D;
                double d1 = itemRand.nextGaussian() * 0.02D;
                double d2 = itemRand.nextGaussian() * 0.02D;
                p_150918_0_.spawnParticle("happyVillager", (double)((float)p_150918_1_ + itemRand.nextFloat()), (double)p_150918_2_ + (double)itemRand.nextFloat() * 1.0f, (double)((float)p_150918_3_ + itemRand.nextFloat()), d0, d1, d2);
            }
        }
    }
    /**
     * Called when a entity tries to play the 'swing' animation.
     *
     * @param entityLiving The entity swinging the item.
     * @param stack The Item stack
     * @return True to cancel any further processing by EntityLiving
     */
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
    {
    	stack.setItemDamage(stack.getItemDamage()^2);
        return false;
    }
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, num - 1);
        return this.IIconarray[j];
    }

	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
    	this.IIconarray = new IIcon[num];
    	this.IIconarray[0] = register.registerIcon(WeedMeals.RESDOMAIN + ":weedmeal");
    }
}
