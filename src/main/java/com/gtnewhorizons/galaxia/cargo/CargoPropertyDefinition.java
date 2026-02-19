package com.gtnewhorizons.galaxia.cargo;

import java.util.HashMap;
import java.util.Map;

public interface CargoPropertyDefinition<T> {
    //To Be replaced with a proper registry at some point
    static Map<String, CargoPropertyDefinition> cargoProperties = new HashMap<>();

    CargoProperty<T> createProperty();
}
