package net.thegasman.createmechanisedmenagerie.registry;

import com.tterrag.registrate.util.entry.EntityEntry;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.thegasman.createmechanisedmenagerie.entity.cogolem.CogolemEntity;
import net.thegasman.createmechanisedmenagerie.entity.cogolem.CogolemRenderer;

import static net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie.REGISTRATE;

public class CMMEntityTypes {

    public static EntityEntry<CogolemEntity> COGOLEM_ENTITY = REGISTRATE
            .entity("cogolem", CogolemEntity::new, MobCategory.CREATURE)
            .properties(p -> p.sized(1.5f, 1.75f))
            .attributes(CogolemEntity::createAttributes)
            .renderer(() -> CogolemRenderer::new)
            .loot((registrateEntityLootTables, cogolemEntityEntityType) -> registrateEntityLootTables.add(cogolemEntityEntityType, LootTable.lootTable()))
            .spawnEgg(0xba8459,0x7e7f73)
            .tab(ModCreativeModTabs.CREATE_MECHANISED_MENAGERIE_TAB.getKey())
            .build()
            .register();

    public static void register() {
        CreateMechanisedMenagerie.LOGGER.info("Registering Entity Types");
    }
}
