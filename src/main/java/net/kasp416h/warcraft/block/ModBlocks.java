package net.kasp416h.warcraft.block;

import com.google.common.base.Supplier;

import net.kasp416h.warcraft.Warcraft;
import net.kasp416h.warcraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Warcraft.MODID);

  @SuppressWarnings("null")
  public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
      () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

  @SuppressWarnings("null")
  public static final RegistryObject<Block> RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
      () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

  private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);

    return toReturn;
  }

  @SuppressWarnings("null")
  private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
    return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
