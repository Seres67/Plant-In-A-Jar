package io.github.coolmineman.plantinajar;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PlantInAJar implements ModInitializer {
	public static final Block PLANT_JAR = new JarBlock(FabricBlockSettings.copyOf(Blocks.GLASS));
	public static BlockEntityType<JarBlockEntity> PLANT_JAR_ENTITY;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.BLOCK, new Identifier("plantinajar", "plant_jar"), PLANT_JAR);
		Registry.register(Registry.ITEM, new Identifier("plantinajar", "plant_jar"), new BlockItem(PLANT_JAR, new Item.Settings().group(ItemGroup.MISC)));
		PLANT_JAR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "plantinajar:plant_jar", BlockEntityType.Builder.create(JarBlockEntity::new, PLANT_JAR).build(null));
		System.out.println("Hello Fabric world!");
	}
}
