package com.gtnewhorizons.galaxia.cargo;


import com.gtnewhorizon.structurelib.alignment.enumerable.ExtendedFacing;
import com.gtnewhorizons.galaxia.block.GalaxiaBlocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.UUID;

public class Cargo {
    public UUID id;
    public CargoDefinition definition;
    public NBTTagCompound properties;

    public boolean isPlaced;
    public int block_x;
    public int block_y;
    public int block_z;
    public ExtendedFacing facing;

    public Cargo(CargoDefinition definition) {
        this.definition = definition;
        this.id = UUID.randomUUID();
        this.properties = (NBTTagCompound) definition.defaultProperties.copy();
        this.isPlaced = false;
    }

    public void placeAt(World world, int x, int y, int z, ExtendedFacing facing) {
        this.isPlaced = true;
        this.block_x = x;
        this.block_y = y;
        this.block_z = z;
        this.facing = facing;
        definition.structureDef.build(this, null, definition.name, world, facing, block_x, block_y, block_z, 1, 5, 1);
    }

    public NBTTagCompound writeToNBT() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setLong("uuidmost", id.getMostSignificantBits());
        tag.setLong("uuidleast", id.getLeastSignificantBits());
        tag.setString("def", definition.name);
        tag.setBoolean("isplaced", isPlaced);
        tag.setInteger("block_x", block_x);
        tag.setInteger("block_y", block_y);
        tag.setInteger("block_z", block_z);
        tag.setTag("properties", properties.copy());
        return tag;
    }

    public void readFromNBT(NBTTagCompound tag) {
        id = new UUID(
            tag.getLong("uuidmost"),
            tag.getLong("uuidleast")
        );
        String defId = tag.getString("def");
        definition = CargoDefinition.cargoDefinitions.get(defId);
        isPlaced = tag.getBoolean("isplaced");
        block_x = tag.getInteger("block_x");
        block_y = tag.getInteger("block_y");
        block_z = tag.getInteger("block_z");
        properties = tag.getCompoundTag("properties");
    }
}
