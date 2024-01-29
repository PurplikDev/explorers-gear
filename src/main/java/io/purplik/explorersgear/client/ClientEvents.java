package io.purplik.explorersgear.client;

import io.purplik.explorersgear.ExplorersGear;
import io.purplik.explorersgear.client.entity.armor.BackpackModel;
import io.purplik.explorersgear.utils.ModelLayers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Mod.EventBusSubscriber(modid = ExplorersGear.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelLayers.BACKPACK, BackpackModel::createBodyLayer);
    }
}
