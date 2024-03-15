package net.kasp416h.warcraft.worldgen.biome;

import net.kasp416h.warcraft.Warcraft;

public class ModBiomes {
    public static final ResourceKey<Biome> EVELYN_FOREST_BIOME = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Warcraft.MODID, "evelyn_forest_biome"));

    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(EVELYN_FOREST_BIOME, evelynForestBiome(context));
    }

    private static Biome evelynForestBiome(BootstrapContext<Biome> context) {
    }
}