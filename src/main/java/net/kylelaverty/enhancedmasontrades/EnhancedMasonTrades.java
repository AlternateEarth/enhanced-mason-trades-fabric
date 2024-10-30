package net.kylelaverty.enhancedmasontrades;

import net.fabricmc.api.ModInitializer;

import net.kylelaverty.enhancedmasontrades.util.ModEnhancedMasonTrades;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnhancedMasonTrades implements ModInitializer {
	public static final String MOD_ID = "enhancedmasontrades"; // Uppercase and space are not allowed in ID
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEnhancedMasonTrades.registerCustomTrades();
	}
}