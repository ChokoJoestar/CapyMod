package fr.chokojoestar.capymod.item;

import fr.chokojoestar.capymod.CapyMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class CapyItems {
   public static final Item DEV_ITEM = registerItem("dev_item", new Item(new FabricItemSettings()));

   private static Item registerItem(String name, Item item) {
      return Registry.register(Registries.ITEM, new Identifier(CapyMod.MOD_ID, name), item);
   }

   public static void addItemsToItemGroup() {
      addToItemGroup(ItemGroups.OPERATOR, DEV_ITEM);
   };

   private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
      ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
         content.add(item);
      });
   }

   public static void registerItems() {
      CapyMod.LOGGER.debug("Registering Mod Items for " + CapyMod.MOD_ID);
   }
}
