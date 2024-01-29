package io.purplik.explorersgear.registry;

import io.purplik.explorersgear.ExplorersGear;
import io.purplik.explorersgear.common.items.Backpack;
import io.purplik.explorersgear.common.items.Canteen;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExplorersGear.MOD_ID);

    public static final DeferredItem<Backpack> BACKPACK = ITEMS.register("backpack", () -> new Backpack(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));

    // item doesn't work properly rn
    // will make work later
    public static final DeferredItem<Canteen> CANTEEN = ITEMS.register("canteen", () -> new Canteen(new Item.Properties().stacksTo(1)));
}
