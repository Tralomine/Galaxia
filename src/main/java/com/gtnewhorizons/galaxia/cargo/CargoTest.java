package com.gtnewhorizons.galaxia.cargo;

import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.StructureUtility;

public class CargoTest {
    public static void registerCargo() {
        CargoDefinition CANNISTER = new CargoDefinition.Builder()
            .setName("cannister")
            .setDescription(new String[]{"test cargo for testing purposes"})
            .setStructure(
            IStructureDefinition.<Cargo>builder()
                .addShape("cannister", new String[][]{
                    {"xxx", "x~x", "xxx"},
                    {"xxx", "xxx", "xxx"},
                    {"xxx", "xxx", "xxx"},
                    {"xxx", "xxx", "xxx"},
                    {"xxx", "xxx", "xxx"},
                    })
                    .addElement('x', StructureUtility.ofBlockUnlocalizedName("galaxia", "cargoblock", 0, false))
                    .build())
            .build();

    }
}

