package io.purplik.explorersgear.registry;

import io.purplik.explorersgear.ExplorersGear;
import io.purplik.explorersgear.common.items.Backpack;
import io.purplik.explorersgear.common.items.Canteen;
import io.purplik.explorersgear.common.items.Marshmallow;
import io.purplik.explorersgear.common.items.MarshmallowOnAStick;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExplorersGear.MOD_ID);

    public static final DeferredItem<Backpack> BACKPACK = ITEMS.register("backpack", () -> new Backpack(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Canteen> CANTEEN = ITEMS.register("canteen", () -> new Canteen(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Marshmallow> MARSHMALLOW = ITEMS.register("marshmallow", () -> new Marshmallow(2, 4f));
    public static final DeferredItem<Marshmallow> ROASTED_MARSHMALLOW = ITEMS.register("roasted_marshmallow", () -> new Marshmallow(6, 12f));
    public static final DeferredItem<Marshmallow> BURNT_MARSHMALLOW = ITEMS.register("burnt_marshmallow", () -> new Marshmallow(1, 0f));

    public static final DeferredItem<MarshmallowOnAStick> MARSHMALLOW_ON_A_STICK = ITEMS.register("marshmallow_on_a_stick", () -> new MarshmallowOnAStick());
}
