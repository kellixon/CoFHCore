package cofh.core.init;

import cofh.CoFHCore;
import cofh.core.enchantment.*;
import cofh.core.util.helpers.StringHelper;
import com.mojang.authlib.GameProfile;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CoreProps {

	private CoreProps() {

	}

	public static void preInit() {

		configCommon();
		configClient();
	}

	/* HELPERS */
	private static void configCommon() {

		String category;
		String comment;

		/* GENERAL */
		category = "General";

		comment = "If TRUE, a log message is generated when a block is dismantled.";
		enableDismantleLogging = CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("EnableDismantleLogging", category, enableDismantleLogging, comment);

		comment = "If TRUE, death messages are displayed for any named entity.";
		enableLivingEntityDeathMessages = CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("EnableGenericDeathMessage", category, enableLivingEntityDeathMessages, comment);

		/* ENCHANTS */
		category = "Enchantment";

		comment = "If TRUE, the Holding Enchantment is available for various Storage Items.";
		EnchantmentHolding.enable = CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("EnableHoldingEnchant", category, EnchantmentHolding.enable, comment);

		comment = "If TRUE, the Insight Enchantment is available for various Tools and Weapons.";
		EnchantmentInsight.enable = CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("EnableInsightEnchant", category, EnchantmentInsight.enable, comment);

		comment = "If TRUE, the Leech Enchantment is available for various Weapons.";
		EnchantmentLeech.enable = CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("EnableLeechEnchant", category, EnchantmentLeech.enable, comment);

		comment = "If TRUE, the Multishot Enchantment is available for various Bows.";
		EnchantmentMultishot.enable = CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("EnableMultishotEnchant", category, EnchantmentMultishot.enable, comment);

		comment = "If TRUE, the Smelting Enchantment is available for various Tools.";
		EnchantmentSmelting.enable = CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("EnableSmeltingEnchant", category, EnchantmentSmelting.enable, comment);

		comment = "If TRUE, the Soulbound Enchantment is available.";
		EnchantmentSoulbound.enable = CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("EnableSoulboundEnchant", category, EnchantmentSoulbound.enable, comment);

		comment = "If TRUE, the Vorpal Enchantment is available for various Weapons.";
		EnchantmentVorpal.enable = CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("EnableVorpalEnchant", category, EnchantmentVorpal.enable, comment);

		/* HOLIDAY */
		category = "Holidays";

		comment = "If TRUE, April Foolishness is disabled. Boring! :P";
		holidayAprilFools = !CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("IHateApril", category, !holidayAprilFools, comment);

		comment = "If TRUE, Christmas cheer is disabled. Scrooge. :(";
		holidayChristmas = !CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("HoHoNo", category, !holidayChristmas, comment);

		/* SECURITY */
		category = "Security";

		comment = "If TRUE, Server Ops can access \"secure\" blocks. Your players will be warned upon server connection.";
		enableOpSecureAccess = CoFHCore.CONFIG_CORE.getConfiguration().getBoolean("OpsCanAccessSecureBlocks", category, enableOpSecureAccess, comment);
	}

	private static void configClient() {

		String category;
		String comment;

		/* GLOBAL */
		category = "Global";
		CoFHCore.CONFIG_CLIENT.getCategory(category).setComment("The options in this section change core Minecraft behavior and are not limited to CoFH mods.");

		comment = "If TRUE, particles will be disabled.";
		disableParticles = CoFHCore.CONFIG_CLIENT.getConfiguration().getBoolean("DisableParticles", category, disableParticles, comment);

		/* GRAPHICS */
		category = "Render";

		comment = "If TRUE, Color Blind Textures will be enabled in CoFH Mods, where applicable.";
		enableColorBlindTextures = CoFHCore.CONFIG_CLIENT.getConfiguration().getBoolean("EnableColorBlindTextures", category, enableColorBlindTextures, comment);

		comment = "If TRUE, borders will be drawn on GUI slots in CoFH Mods, where applicable.";
		enableGUISlotBorders = CoFHCore.CONFIG_CLIENT.getConfiguration().getBoolean("EnableGUISlotBorders", category, enableGUISlotBorders, comment);

		comment = "If TRUE, Shader Effects will be enabled in CoFH Mods, where applicable.";
		enableShaderEffects = CoFHCore.CONFIG_CLIENT.getConfiguration().getBoolean("EnableShaderEffects", category, enableShaderEffects, comment);

		/* INTERFACE */
		category = "Interface";

		comment = "If TRUE, a tooltip will be used which prompts to press Shift for more details on various items.";
		StringHelper.displayShiftForDetail = CoFHCore.CONFIG_CLIENT.getConfiguration().getBoolean("DisplayHoldShiftForDetail", category, StringHelper.displayShiftForDetail, comment);

		comment = "If TRUE, large item counts will be displayed as stacks rather than a single quantity.";
		StringHelper.displayStackCount = CoFHCore.CONFIG_CLIENT.getConfiguration().getBoolean("DisplayContainedItemsAsStackCount", category, StringHelper.displayStackCount, comment);

		/* SECURITY */
		category = "Security";

		comment = "If TRUE, a warning will display if Ops have access to \"secure\" blocks upon logging on to a server.";
		enableOpSecureAccessWarning = CoFHCore.CONFIG_CLIENT.getConfiguration().getBoolean("OpsCanAccessSecureBlocksWarning", category, enableOpSecureAccessWarning, comment);
	}

	private static void configLoot() {

		//		CONFIG_LOOT.setConfiguration(new Configuration(new File(configDir, "/cofh/core/loot.cfg"), true));
		//
		//		String comment;
		//		/* GENERAL */
		//		String category = "General";
		//
		//		comment = "Set to false to disable this entire module.";
		//		boolean enable = CONFIG_LOOT.get(category, "EnableModule", true, comment);
		//
		//		if (!enable) {
		//			CONFIG_LOOT.save();
		//			return false;
		//		}
		//		/* HEADS */
		//		category = "Heads";
		//
		//		comment = "If enabled, mobs only drop heads when killed by players.";
		//		DropHandler.mobPvEOnly = CONFIG_LOOT.get(category, "MobsDropOnPvEOnly", DropHandler.mobPvEOnly, comment);
		//
		//		comment = "If enabled, players only drop heads when killed by other players.";
		//		DropHandler.playerPvPOnly = CONFIG_LOOT.get(category, "PlayersDropOnPvPOnly", DropHandler.playerPvPOnly, comment);
		//
		//		category = "Heads.Players";
		//		DropHandler.playersEnabled = CONFIG_LOOT.get(category, "Enabled", DropHandler.playersEnabled);
		//		DropHandler.playerChance = CONFIG_LOOT.get(category, "Chance", DropHandler.playerChance);
		//
		//		category = "Heads.Creepers";
		//		DropHandler.creeperEnabled = CONFIG_LOOT.get(category, "Enabled", DropHandler.creeperEnabled);
		//		DropHandler.creeperChance = CONFIG_LOOT.get(category, "Chance", DropHandler.creeperChance);
		//
		//		category = "Heads.Skeletons";
		//		DropHandler.skeletonEnabled = CONFIG_LOOT.get(category, "Enabled", DropHandler.skeletonEnabled);
		//		DropHandler.skeletonChance = CONFIG_LOOT.get(category, "Chance", DropHandler.skeletonChance);
		//
		//		category = "Heads.WitherSkeletons";
		//		DropHandler.skeletonEnabled = CONFIG_LOOT.get(category, "Enabled", DropHandler.witherSkeletonEnabled);
		//		DropHandler.witherSkeletonChance = CONFIG_LOOT.get(category, "Chance", DropHandler.witherSkeletonChance);
		//
		//		category = "Heads.Zombies";
		//		DropHandler.zombieEnabled = CONFIG_LOOT.get(category, "Enabled", DropHandler.zombieEnabled);
		//		DropHandler.zombieChance = CONFIG_LOOT.get(category, "Chance", DropHandler.zombieChance);
		//
		//		CONFIG_LOOT.save();
		//
		//		MinecraftForge.EVENT_BUS.register(DropHandler.instance);
	}

	private static final String BUILD = "2611";
	private static final String FORGE_REQ = "14.23.2." + BUILD;
	private static final String FORGE_REQ_MAX = "15.0.0.0";

	public static final String FORGE_DEP = "required-after:forge@[" + FORGE_REQ + "," + FORGE_REQ_MAX + ");";

	/* INSTANCE CONSTANTS */
	public static File configDir;
	public static MinecraftServer server;

	/* GLOBAL CONSTANTS */
	public static final GameProfile DEFAULT_OWNER = new GameProfile(UUID.fromString("1ef1a6f0-87bc-4e78-0a0b-c6824eb787ea"), "[None]");

	public static final int TIME_CONSTANT = 32;
	public static final int TIME_CONSTANT_HALF = TIME_CONSTANT / 2;
	public static final int TIME_CONSTANT_QUARTER = TIME_CONSTANT / 4;
	public static final int TIME_CONSTANT_EIGHTH = TIME_CONSTANT / 8;
	public static final int MB_PER_XP = 20;
	public static final int RF_PER_MJ = 10;
	public static final int LAVA_RF = 200000;
	public static final int MAGMATIC_TEMPERATURE = 1000;
	public static final int ENTITY_TRACKING_DISTANCE = 64;
	public static final int TILE_UPDATE_DELAY = 160;

	public static final int BOTTLE_VOLUME = 250;
	public static final int POTION_MIN = 3;
	public static final int POTION_MAX = 5;

	public static final int RGB_DURABILITY_FLUX = 0xD01010;
	public static final int RGB_DURABILITY_WATER = 0x4060FF;
	public static final int RGB_DURABILITY_ENDER = 0x14594D;
	public static final int RGB_DURABILITY_EXP = 0x7AAC52;

	/* INVENTORIES */
	public static final int[] EMPTY_INVENTORY = new int[] {};
	public static final int[] SINGLE_INVENTORY = { 0 };
	public static final List<ItemStack> EMPTY_DROPS = new ArrayList<>();

	public static final int[] STORAGE_SIZE = { 1, 9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99, 108, 117, 126 };
	public static final int[] FILTER_SIZE = { 3, 6, 9, 12, 15 };
	public static final int[][] SLOTS = new int[STORAGE_SIZE.length][];

	static {
		for (int i = 0; i < STORAGE_SIZE.length; i++) {
			SLOTS[i] = new int[STORAGE_SIZE[i]];
			for (int j = 0; j < STORAGE_SIZE[i]; j++) {
				SLOTS[i][j] = j;
			}
		}
	}

	/* TEXTURES */
	public static final String PATH_GFX = "cofh:textures/";
	public static final String PATH_GUI = PATH_GFX + "gui/";
	public static final String PATH_ELEMENTS = PATH_GUI + "elements/";
	public static final String PATH_GUI_STORAGE = PATH_GUI + "storage/";
	public static final String PATH_GUI_FILTER = PATH_GUI + "filter/";

	public static final ResourceLocation[] TEXTURE_STORAGE = new ResourceLocation[STORAGE_SIZE.length];
	public static final ResourceLocation[] TEXTURE_FILTER = new ResourceLocation[FILTER_SIZE.length];

	static {
		for (int i = 0; i < STORAGE_SIZE.length; i++) {
			TEXTURE_STORAGE[i] = new ResourceLocation(PATH_GUI_STORAGE + "storage_" + STORAGE_SIZE[i] + ".png");
		}
		for (int i = 0; i < FILTER_SIZE.length; i++) {
			TEXTURE_FILTER[i] = new ResourceLocation(PATH_GUI_FILTER + "filter_" + FILTER_SIZE[i] + ".png");
		}
	}

	/* NETWORK */
	public static final int NETWORK_UPDATE_RANGE = 192;

	/* GLOBAL */
	public static boolean disableParticles = false;

	/* GENERAL */
	public static boolean enableDismantleLogging = false;
	public static boolean enableLivingEntityDeathMessages = true;

	/* GRAPHICS */
	public static boolean enableColorBlindTextures = false;
	public static boolean enableGUISlotBorders = true;
	public static boolean enableShaderEffects = true;
	public static boolean useAlternateStarfieldShader = false;

	/* HOLIDAY */
	public static boolean holidayAprilFools = true;
	public static boolean holidayChristmas = true;

	/* SECURITY */
	public static boolean enableOpSecureAccess = false;
	public static boolean enableOpSecureAccessWarning = true;

}
