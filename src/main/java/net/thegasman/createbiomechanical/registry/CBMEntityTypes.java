package net.thegasman.createbiomechanical.registry;

import com.tterrag.registrate.util.entry.EntityEntry;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.thegasman.createbiomechanical.CreateBiomechanical;
import net.thegasman.createbiomechanical.entity.cogolem.CogolemEntity;
import net.thegasman.createbiomechanical.entity.cogolem.CogolemRenderer;

import static net.thegasman.createbiomechanical.CreateBiomechanical.REGISTRATE;

public class CBMEntityTypes {

    public static EntityEntry<CogolemEntity> COGOLEM_ENTITY = REGISTRATE
            .entity("cogolem", CogolemEntity::new, MobCategory.CREATURE)
            .properties(p -> p.sized(1.5f, 1.75f))
            .attributes(CogolemEntity::createAttributes)
            .renderer(() -> CogolemRenderer::new)
            .loot((registrateEntityLootTables, cogolemEntityEntityType) -> registrateEntityLootTables.add(cogolemEntityEntityType, LootTable.lootTable()
                    .withPool(
                            LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1.0F))
                                    .add(LootItem.lootTableItem(CBMBlocks.POWER_CORE.get()))
                    )))
            .spawnEgg(0x7e7f73,0xba8459)
            .tab(CBMCreativeModTabs.CREATE_MECHANISED_MENAGERIE_TAB.getKey())
            .build()
            .register();

    public static void register() {
        CreateBiomechanical.LOGGER.info("Registering Entity Types");
    }
}
