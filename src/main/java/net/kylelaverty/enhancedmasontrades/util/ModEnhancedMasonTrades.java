package net.kylelaverty.enhancedmasontrades.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

public class ModEnhancedMasonTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.MASON,
                TradeLevel.NOVICE,
                factories -> {
                    factories.add(new EmeraldToItemOffer(new ItemStack(Items.PACKED_MUD, 1), 1, 16, 2, 0.2f));
                });
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.MASON,
                TradeLevel.APPRENTICE,
                factories -> {
                    factories.add(new EmeraldToItemOffer(new ItemStack(Items.BRICKS, 4), 1, 16, 5, 0.2f));
                    factories.add(new EmeraldToItemOffer(new ItemStack(Items.MUD_BRICKS, 4), 1, 16, 5, 0.2f));
                });
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.MASON,
                TradeLevel.JOURNEYMAN,
                factories -> {
                    factories.add(new EmeraldToItemOffer(new ItemStack(Items.TUFF, 4), 1, 16, 10, 0.2f));
                    factories.add(new EmeraldToItemOffer(new ItemStack(Items.TERRACOTTA, 1), 1, 16, 10, 0.2f));
                });
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.MASON,
                TradeLevel.MASTER,
                factories -> {
                    factories.add(new EmeraldToItemOffer(new ItemStack(Items.CALCITE, 1), 1, 8, 20, 0.2f));
                });
    }

    private static final class TradeLevel {
        public static final int NOVICE = 1;
        public static final int APPRENTICE = 2;
        public static final int JOURNEYMAN = 3;
        public static final int EXPERT = 4;
        public static final int MASTER = 5;
    }

    private static final class EmeraldToItemOffer implements TradeOffers.Factory {

        private final ItemStack sell;
        private final int price;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        /**
         * @param stack      The item and how many of them will be given to the player.
         * @param price      The number of emeralds this trade will cost.
         * @param maxUses    The number of uses of this trade before being exhausted.
         * @param experience The amount of experience given for this trade.
         * @param multiplier The price multiplier for repeated trades.
         */
        public EmeraldToItemOffer(ItemStack stack, int price, int maxUses, int experience, float multiplier) {
            this.sell = stack;
            this.price = price;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
        }

        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new ItemStack(Items.EMERALD, this.price), this.sell, this.maxUses, this.experience,
                    this.multiplier);
        }
    }
}
