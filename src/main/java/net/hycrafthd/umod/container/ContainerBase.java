package net.hycrafthd.umod.container;

import net.hycrafthd.umod.inventory.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerBase extends Container {
	
	public TileEntity ent;
	public EntityPlayer pls;
	public BlockPos pos;
	public World worldObj;
	public Mode mode;
	public boolean B;
	public boolean energ;
	
	public ContainerBase(IInventory inv, EntityPlayer pl, BlockPos pos, World wo, boolean b, boolean act) {
		this.ent = (TileEntity) inv;
		this.pls = pl;
		this.pos = pos;
		this.worldObj = wo;
		mode = Mode.NORMAL;
		if (b) {
			BaseBatteryInputSlot sl = new BaseBatteryInputSlot(inv, inv.getSizeInventory() - 1, 80, 28);
			sl.setVisible(false);
			super.addSlotToContainer(sl);
		}
		energ = act;
		B = b;
	}
	
	public ContainerBase(IInventory inv, EntityPlayer pl, BlockPos pos, World wo) {
		this(inv, pl, pos, wo, true);
	}
	
	public ContainerBase(IInventory inv, EntityPlayer pl, BlockPos pos2, World wo, boolean c) {
		this(inv, pl, pos2, wo, c, c);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}
	
	@Override
	protected void retrySlotClick(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_) {}
	
	@Override
	public void onContainerClosed(EntityPlayer entityPlayer) {
		super.onContainerClosed(entityPlayer);
		((IInventory) this.ent).closeInventory(entityPlayer);
	}
	
	@Override
	public boolean canDragIntoSlot(Slot p_94531_1_) {
		return true;
	}
	
	public void setVisisble(int i, boolean b) {
		if (inventorySlots.get(i) instanceof BaseSlot) {
			((BaseSlot) inventorySlots.get(i)).setVisible(b);
		}
	}
	
	@Override
	public ItemStack slotClick(int slotId, int clickedButton, int mode, EntityPlayer playerIn) {
		if (!this.mode.equals(Mode.ENERGY) || !this.mode.equals(Mode.OUTPUT) || !this.mode.equals(Mode.COLOR)) {
			return super.slotClick(slotId, clickedButton, mode, playerIn);
		}
		return null;
	}
	
	public static enum Mode {
		
		NORMAL(0),
		BATTERY(1),
		OUTPUT(2),
		COLOR(3),
		ENERGY(4);
		
		public int getID() {
			return id;
		}
		
		public static Mode byID(int id) {
			if (id < 0 || id >= all.length) {
				id = 0;
			}
			return all[id];
		}
		
		public static Mode getTurndMode(Mode m) {
			switch (m) {
			case BATTERY:
				return OUTPUT;
			case NORMAL:
				return BATTERY;
			case OUTPUT:
				return COLOR;
			case COLOR:
				return NORMAL;
			default:
				return NORMAL;
			}
		}
		
		private int id;
		
		private static final Mode[] all = new Mode[values().length];
		
		private Mode(int id) {
			this.id = id;
		}
		
		static {
			for (Mode type : values()) {
				all[type.getID()] = type;
			}
		}
		
	}
	
	public void setMode(Mode m) {
		mode = m;
	}
	
	public Mode getMode() {
		return mode;
	}
	
}
