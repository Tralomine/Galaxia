package com.gtnewhorizons.galaxia.items;

import com.gtnewhorizon.gtnhlib.blockpos.BlockPos;
import com.gtnewhorizon.structurelib.alignment.enumerable.ExtendedFacing;
import com.gtnewhorizons.galaxia.cargo.Cargo;
import com.gtnewhorizons.galaxia.cargo.CargoDefinition;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

public class ItemCargoDebug extends Item {
    public CargoDefinition selected;
    public List<CargoDefinition> moduleList;

    public ItemCargoDebug() {

    }


    /**
     * This is called when the item is used, before the block is activated.
     *
     * @param stack  The Item Stack
     * @param player The Player that used the item
     * @param world  The Current World
     * @param x      Target X Position
     * @param y      Target Y Position
     * @param z      Target Z Position
     * @param side   The side of the target hit
     * @param hitX
     * @param hitY
     * @param hitZ
     * @return Return true to prevent any further processing.
     */
    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        BlockPos controllerPos = new BlockPos(x,y,z);
        controllerPos = controllerPos.offset(ForgeDirection.getOrientation(side));
        Cargo cargo = new Cargo(CargoDefinition.cargoDefinitions.get("cannister"));
        cargo.placeAt(world, controllerPos.x, controllerPos.y, controllerPos.z, ExtendedFacing.of(ForgeDirection.NORTH));
        return true;
    }
}
