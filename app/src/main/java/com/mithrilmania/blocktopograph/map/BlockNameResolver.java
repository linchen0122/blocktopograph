package com.mithrilmania.blocktopograph.map;

public final class BlockNameResolver {

    static private final String[] NAMES = new String[]{
            "air",
            "stone",
            "grass",
            "dirt",
            "cobblestone",
            "planks",
            "sapling",
            "bedrock",
            "flowing_water",
            "water",
            "flowing_lava",
            "lava",
            "sand",
            "gravel",
            "gold_ore",
            "iron_ore",
            "coal_ore",
            "log",
            "leaves",
            "sponge",
            "glass",
            "lapis_ore",
            "lapis_block",
            "dispenser",
            "sandstone",
            "noteblock",
            "bed",
            "golden_rail",
            "detector_rail",
            "sticky_piston",
            "web",
            "tallgrass",
            "deadbush",
            "piston",
            "pistonarmcollision",
            "wool",
            "air",
            "yellow_flower",
            "red_flower",
            "brown_mushroom",
            "red_mushroom",
            "gold_block",
            "iron_block",
            "double_stone_slab",
            "stone_slab",
            "brick_block",
            "tnt",
            "bookshelf",
            "mossy_cobblestone",
            "obsidian",
            "torch",
            "fire",
            "mob_spawner",
            "oak_stairs",
            "chest",
            "redstone_wire",
            "diamond_ore",
            "diamond_block",
            "crafting_table",
            "wheat",
            "farmland",
            "furnace",
            "lit_furnace",
            "standing_sign",
            "wooden_door",
            "ladder",
            "rail",
            "stone_stairs",
            "wall_sign",
            "lever",
            "stone_pressure_plate",
            "iron_door",
            "oak_pressure_plate",
            "redstone_ore",
            "lit_redstone_ore",
            "unlit_redstone_torch",
            "lit_redstone_torch",
            "stone_button",
            "snow_layer",
            "ice",
            "snow",
            "cactus",
            "clay",
            "reeds",
            "jukebox",
            "fence",
            "pumpkin",
            "netherrack",
            "soul_sand",
            "glowstone",
            "portal",
            "lit_pumpkin",
            "cake",
            "unpowered_repeater",
            "powered_repeater",
            "invisiblebedrock",
            "oak_trapdoor",
            "monster_egg",
            "stonebrick",
            "brown_mushroom_block",
            "red_mushroom_block",
            "iron_bars",
            "glass_pane",
            "melon_block",
            "pumpkin_stem",
            "melon_stem",
            "vine",
            "fence_gate",
            "brick_stairs",
            "stone_brick_stairs",
            "mycelium",
            "waterlily",
            "nether_brick",
            "nether_brick_fence",
            "nether_brick_stairs",
            "nether_wart",
            "enchanting_table",
            "brewing_stand",
            "cauldron",
            "end_portal",
            "end_portal_frame",
            "end_stone",
            "dragon_egg",
            "redstone_lamp",
            "lit_redstone_lamp",
            "dropper",
            "activator_rail",
            "cocoa",
            "sandstone_stairs",
            "emerald_ore",
            "ender_chest",
            "tripwire_hook",
            "tripwire",
            "emerald_block",
            "spruce_stairs",
            "birch_stairs",
            "jungle_stairs",
            "command_block",
            "beacon",
            "cobblestone_wall",
            "flower_pot",
            "carrots",
            "potatoes",
            "oak_button",
            "skull",
            "anvil",
            "trapped_chest",
            "light_weighted_pressure_plate",
            "heavy_weighted_pressure_plate",
            "unpowered_comparator",
            "powered_comparator",
            "daylight_detector",
            "redstone_block",
            "quartz_ore",
            "hopper",
            "quartz_block",
            "quartz_stairs",
            "double_wooden_slab",
            "wooden_slab",
            "stained_hardened_clay",
            "stained_glass_pane",
            "leaves2",
            "log2",
            "acacia_stairs",
            "dark_oak_stairs",
            "slime",
            "air",
            "iron_trapdoor",
            "prismarine",
            "sealantern",
            "hay_block",
            "carpet",
            "terracotta",
            "coal_block",
            "packed_ice",
            "double_plant",
            "standing_banner",
            "wall_banner",
            "daylight_detector_inverted",
            "red_sandstone",
            "red_sandstone_stairs",
            "double_stone_slab2",
            "stone_slab2",
            "spruce_fence_gate",
            "birch_fence_gate",
            "jungle_fence_gate",
            "dark_oak_fence_gate",
            "acacia_fence_gate",
            "repeating_command_block",
            "chain_command_block",
            "air",
            "air",
            "air",
            "spruce_door",
            "birch_door",
            "jungle_door",
            "acacia_door",
            "dark_oak_door",
            "grass_path",
            "frame",
            "chorus_flower",
            "purpur_block",
            "purpur_stairs",
            "air",
            "air",
            "undyed_shulker_box",
            "end_bricks",
            "frosted_ice",
            "end_rod",
            "end_gateway",
            "air",
            "air",
            "air",
            "magma",
            "nether_wart_block",
            "red_nether_brick",
            "bone_block",
            "air",
            "shulker_box",
            "purple_glazed_terracotta",
            "white_glazed_terracotta",
            "orange_glazed_terracotta",
            "magenta_glazed_terracotta",
            "light_blue_glazed_terracotta",
            "yellow_glazed_terracotta",
            "lime_glazed_terracotta",
            "pink_glazed_terracotta",
            "gray_glazed_terracotta",
            "silver_glazed_terracotta",
            "cyan_glazed_terracotta",
            "air",
            "blue_glazed_terracotta",
            "brown_glazed_terracotta",
            "green_glazed_terracotta",
            "red_glazed_terracotta",
            "black_glazed_terracotta",
            "concrete",
            "concretepowder",
            "air",
            "air",
            "chorus_plant",
            "stained_glass",
            "air",
            "podzol",
            "beetroot",
            "stonecutter",
            "glowingobsidian",
            "netherreactor",
            "info_update",
            "info_update2",
            "movingblock",
            "observer",
            "structure_block",
            "air",
            "air",
            "reserved6"};

    //String id -> global numeric id (deprecated but still works)
    static public int resolve(String name) {
        if (name.charAt(9) == ':') name = name.substring(10);
        for (int i = 0; i < 256; i++) {
            if (NAMES[i].equals(name)) return i;
        }
        return 0;
    }

    static public String getName(int legacyNumericId) {
        if (legacyNumericId < 0 || legacyNumericId > 255) legacyNumericId = 0;
        return NAMES[legacyNumericId];
    }
}
