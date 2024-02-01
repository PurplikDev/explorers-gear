package io.purplik.explorersgear.common.items;

import io.purplik.explorersgear.registry.ModItems;
import io.purplik.explorersgear.utils.CampfireUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MarshmallowOnAStick extends Item {

    public MarshmallowOnAStick() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(!pLevel.isClientSide() && pIsSelected && pEntity.isCrouching() && CampfireUtils.isNearCampfire(4, (Player) pEntity, pLevel)) {
            CompoundTag tag = pStack.getOrCreateTag();
            int cookingTicks = 0;
            if(tag.contains("CookingTicks")) { cookingTicks = tag.getInt("CookingTicks"); }
            cookingTicks++;
            tag.putInt("CookingTicks", cookingTicks);
            pStack.setTag(tag);
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if(!pLevel.isClientSide() && pPlayer.isCrouching() && stack.getItem() instanceof MarshmallowOnAStick) {
            CompoundTag tag = stack.getOrCreateTag();
            int cookingTicks = 0;
            if(tag.contains("CookingTicks")) { cookingTicks = tag.getInt("CookingTicks"); }

            if(cookingTicks < 200) {
                pPlayer.getInventory().add(new ItemStack(Items.STICK));
            } else {
                pPlayer.getInventory().add(new ItemStack(ModItems.MARSHMALLOW.get()));
            }
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        CompoundTag tag = pStack.getOrCreateTag();
        int cookingTicks = 0;
        if(tag.contains("CookingTicks")) { cookingTicks = tag.getInt("CookingTicks"); }

        pTooltipComponents.add(Component.literal(cookingTicks + ""));
    }
}
