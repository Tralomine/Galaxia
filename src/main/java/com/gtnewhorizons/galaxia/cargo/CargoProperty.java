package com.gtnewhorizons.galaxia.cargo;


import net.minecraft.nbt.NBTTagCompound;

public abstract class CargoProperty<T> {


    public CargoProperty() {

    }

    public abstract String getType();

    public abstract T getRawValue();
    public abstract void setRawValue(T t);

    public abstract T getValue();
    public abstract void setValue(T t);

    public abstract CargoProperty readFromNBT(NBTTagCompound tag);

    public NBTTagCompound writeToNBT() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("Type", this.getType());
        return tag;
    }

    public static CargoProperty readUnknownFromNBT(NBTTagCompound tag) {
        String type = tag.getString("Type");
        CargoProperty property = CargoPropertyDefinition.cargoProperties.get(type).createProperty();
        property.readFromNBT(tag);
        return property;
    }
}
