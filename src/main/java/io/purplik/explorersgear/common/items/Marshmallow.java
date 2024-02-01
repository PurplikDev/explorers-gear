package io.purplik.explorersgear.common.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class Marshmallow extends Item {
    public Marshmallow(int nutrition, float saturation) {
        super(new Item.Properties().food(new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation).build()));
    }
}
