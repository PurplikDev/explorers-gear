package io.purplik.explorersgear.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;

public class CampfireUtils {
    public static boolean isNearCampfire(int distance, Player player, Level level) {
        int half = distance / 2;
        int startingPoint = half - distance;
        for(int i = startingPoint; i < half; i++) {
            for(int j = startingPoint; j < half; j++) {
                for(int k = startingPoint; k < half; k++) {
                    BlockPos pos = new BlockPos(
                            player.getBlockX() + i,
                            player.getBlockY() + j,
                            player.getBlockZ() + k);

                    if(CampfireBlock.isLitCampfire(level.getBlockState(pos))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
