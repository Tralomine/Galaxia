package com.gtnewhorizons.galaxia.cargo;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;

public class CargoTE extends TileEntity {
    public int local_x;
    public int local_y;
    public int local_z;

    public UUID moduleId;


    @Override
    public void readFromNBT(NBTTagCompound compound) {
        compound.setInteger("local_x", local_x);
        compound.setInteger("local_y", local_y);
        compound.setInteger("local_z", local_z);
        super.readFromNBT(compound);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
    }
}
