package com.gtnewhorizons.galaxia.cargo;


import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import net.minecraft.nbt.NBTTagCompound;

import java.util.HashMap;
import java.util.Map;

public class CargoDefinition {
    public static Map<String, CargoDefinition> cargoDefinitions = new HashMap<>();
    IStructureDefinition<Cargo> structureDef;
    NBTTagCompound defaultProperties;
    String name;
    String[] description;

    private CargoDefinition() {
        defaultProperties = new NBTTagCompound();
    }

    public static class Builder {
        private CargoDefinition definition;

        public Builder() {
            definition = new CargoDefinition();
        }

        public Builder setName(String name) {
            definition.name = name;
            return this;
        }

        public Builder setDescription(String[] description) {
            definition.description = description;
            return this;
        }

        public Builder addProperty(String id, CargoProperty property) {
            definition.defaultProperties.setTag(id, property.writeToNBT());
            return this;
        }

        public Builder setStructure(IStructureDefinition<Cargo> structure) {
            definition.structureDef = structure;
            return this;
        }

        public CargoDefinition build() {
            cargoDefinitions.put(definition.name, definition);
            return definition;
        }
    }
}
