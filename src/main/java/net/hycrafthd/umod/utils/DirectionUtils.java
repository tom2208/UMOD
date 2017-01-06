package net.hycrafthd.umod.utils;

import net.minecraft.util.*;

public class DirectionUtils {
	
	public static EnumFacing getDirectory(BlockPos pos1, BlockPos pos2) {
		if (pos1.getY() > pos2.getY()) {
			return EnumFacing.DOWN;
		} else if (pos1.getY() < pos2.getY()) {
			return EnumFacing.UP;
		}
		if (pos1.getX() > pos2.getX()) {
			return EnumFacing.EAST;
		} else if (pos1.getX() < pos2.getX()) {
			return EnumFacing.WEST;
		}
		if (pos1.getZ() > pos2.getZ()) {
			return EnumFacing.SOUTH;
		} else if (pos1.getZ() < pos2.getZ()) {
			return EnumFacing.NORTH;
		}
		return EnumFacing.EAST;
	}
	
	public static short getShortFromFacing(EnumFacing face) {
		if (face == null)return 0;
		switch (face) {
		case DOWN:
			return 0;
		case EAST:
			return 1;
		case NORTH:
			return 2;
		case SOUTH:
			return 3;
		case UP:
			return 4;
		case WEST:
			return 5;
		default:
			break;
		}
		return 0;
	}
	
	public static EnumFacing getFacingFromShort(short face) {
		switch (face) {
		case 0:
			return EnumFacing.DOWN;
		case 1:
			return EnumFacing.EAST;
		case 2:
			return EnumFacing.NORTH;
		case 3:
			return EnumFacing.SOUTH;
		case 4:
			return EnumFacing.UP;
		case 5:
			return EnumFacing.WEST;
		default:
			break;
		}
		return null;
	}
	
	public static BlockPos getPosfromFacing(EnumFacing face, BlockPos p) {
		switch (face) {
		case DOWN:
			return p.down();
		case EAST:
			return p.east();
		case NORTH:
			return p.north();
		case SOUTH:
			return p.south();
		case UP:
			return p.up();
		case WEST:
			return p.west();
		default:
			break;
		}
		return null;
	}
	
}
