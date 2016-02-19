package net.hycrafthd.umod.tileentity;

import net.hycrafthd.umod.utils.NBTUtils;
import net.hycrafthd.umod.utils.TileNBTUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

public class TileEntityPainter extends TileEntityBase{

	private ItemStack[] stack = new ItemStack[5];
	
	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		switch(side){
		case DOWN:
			return new int[]{2,4};
		case EAST:
			break;
		case NORTH:
			break;
		case SOUTH:
			break;
		case UP:
			return new int[]{0,1,3};
		case WEST:
			break;
		default:
			break;
		}
		return new int[]{};
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		if(index == 0 || index == 1 || index == 3){
			return true;
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		if(index == 2 || index == 4){
			return true;
		}
		return false;
	}

	@Override
	public int getSizeInventory() {
		return stack.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return stack[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (this.stack[index] != null)
        {
            ItemStack itemstack;

            if (this.stack[index].stackSize <= count)
            {
                itemstack = this.stack[index];
                this.stack[index] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.stack[index].splitStack(count);

                if (this.stack[index].stackSize == 0)
                {
                    this.stack[index] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		  if (this.stack[index] != null)
	        {
	            ItemStack itemstack = this.stack[index];
	            this.stack[index] = null;
	            return itemstack;
	        }
	        else
	        {
	            return null;
	        }
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.stack[index] = stack;
		this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
        if(index != 2 && index != 4){
        	return true;
        }
		return false;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
         stack = new ItemStack[getSizeInventory()];
	}

	@Override
	public String getName() {
		return "tilepainter";
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return null;
	}

	@Override
	public String getGuiID() {
		return "6";
	}

	@Override
	public void writeOtherToNBT(NBTTagCompound tagSonstiges) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeIOModeToNBT(NBTTagCompound tagIO) {
		// TODO Auto-generated method stub
	}

	@Override
	public void writeEnergyToNBT(NBTTagCompound tagEnergy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeItemsToNBT(NBTTagCompound tagItems) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readOtherFromNBT(NBTTagCompound tagSonstiges) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readIOModeFromNBT(NBTTagCompound tagIO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readEnergyFromNBT(NBTTagCompound tagEnergy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readItemsFromNBT(NBTTagCompound tagItems) {
		// TODO Auto-generated method stub
		
	}

}
