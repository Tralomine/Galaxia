package com.gtnewhorizons.galaxia.cargo;

import com.gtnewhorizons.galaxia.block.IGalaxiaBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CargoBlock extends Block implements ITileEntityProvider, IGalaxiaBlock {

    public CargoBlock() {
        super(Material.iron);
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param worldIn
     * @param meta
     */
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new CargoTE();
    }

    @Override
    public String getBlockName() {
        return "cargoblock";
    }
}
