package lance5057.tDefense;

import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class TD_Config {

    public boolean debug;
    public boolean ArmorAddon;
    public boolean transparency;
    public boolean mossEnabled;
    public boolean mossHard;

    static int count = 18;
    public int AeonsteelMatID;
    public int QueensGoldMatID;
    public int DogbeariumMatID;
    public int RedMintMatID;
    public int GreenMintMatID;

    public int SoulBoundID;
    public int DazeID;
    public int RainbowID;
    public int XPBoostID;
    public int ShearFortuneID;

    public int[] CrestFeathersID;
    public int[] CrestMirrorsID;
    public int[] CrestLegendsID;
    public int[] CrestBladesID;
    public int[] CrestGluttonyID;
    public int[] CrestPitchID;
    public int[] CrestThornsID;
    public int[] CrestSanguisugaID;
    public int[] CrestWindsID;
    public int[] CrestRetributionID;
    public int[] CrestLightID;

    // public int JokeInsultID;
    // public int JokePyrotechID;
    // public int JokeCompensateID;

    public int SoulSteveID;

    public int ArmorProtectionID;
    public int ArmorFireProtectionID;
    public int ArmorBlastProtectionID;
    public int ArmorProjectileProtectionID;
    public int ArmorFeatherfallID;
    public int ArmorGlowstepID;
    public int ArmorFrostwalkerID;
    public int ArmorFirewalkerID;
    public int ArmorDepthstriderID;
    public int ArmorRebreatherID;
    public int ArmorNightvisionID;
    public int ArmorAntiBlindnessID;
    public int ArmorPumpkinID;
    public int ArmorDodgeID;
    public int ArmorThornsID;
    public int ArmorAbsorptionID;
    public int ArmorJumpboostID;
    public int ArmorSpeedID;
    public int ArmorHighstepID;
    public int ArmorKnockbackResistID;

    public int MaterialIndex;

    public boolean MineAndBladeAddon;

    public boolean BotaniaAddon;
    public int CorpseIvyModID;
    public int ManaRepairModID;
    public int TerraCoreModID;
    public int ArmorPixieCoreModID;
    public int ArmorManaDiscountModID;

    public boolean ThaumcraftAddon;
    public int RevealingModID;
    public int VisDiscountModID;
    public int CapsModID;
    // public int SpellbindModID;

    public boolean BloodMagicAddon;
    public int SuppingModID;
    public int BloodOathModID;
    public int ScabbingModID;
    public int DivinationModID;

    public TD_Config(FMLPreInitializationEvent e) {
        final Configuration config = new Configuration(e.getSuggestedConfigurationFile());

        config.load();

        debug = config.getBoolean("Should debug mode be enabled?", "Debug Mode", false, null);
        ArmorAddon = config.getBoolean("Should the armor addon be enabled?", "Armor Addon", true, null);
        transparency = config.getBoolean(
                "Should Transparent Textures be enabled?",
                "General Settings",
                true,
                "May help fps if disabled");
        mossEnabled = config.getBoolean("Should the moss recipe be enabled?", "General Settings", true, null);
        mossHard = config.getBoolean("Should the moss recipe be hard?", "General Settings", true, null);

        MaterialIndex = config.getInt(
                "Material Index",
                "Highest material ID",
                206,
                30,
                Integer.MAX_VALUE,
                "TDefense - 206 MFR - 1001 ExtraTIC - 1024");

        AeonsteelMatID = config.getInt("Aeonsteel Material ID", "Material Configs", 201, 30, Integer.MAX_VALUE, null);
        QueensGoldMatID = config.getInt("QueensGold Material ID", "Material Configs", 202, 30, Integer.MAX_VALUE, null);
        DogbeariumMatID = config.getInt("Dogbearium Material ID", "Material Configs", 203, 30, Integer.MAX_VALUE, null);
        RedMintMatID = config.getInt("RedMint Material ID", "Material Configs", 204, 30, Integer.MAX_VALUE, null);
        GreenMintMatID = config.getInt("GreenMint Material ID", "Material Configs", 205, 30, Integer.MAX_VALUE, null);

        DazeID = config.getInt("Daze ID", "Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        SoulBoundID = config.getInt("Soulbound ID", "Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        RainbowID = config.getInt("Rainbow ID", "Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        XPBoostID = config.getInt("XPBoost ID", "Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ShearFortuneID = config
                .getInt("Fortune for Shears ID", "Modifier Configs", count++, 18, Integer.MAX_VALUE, null);

        CrestFeathersID = ConfigCrest(config, "Feathers");
        CrestMirrorsID = ConfigCrest(config, "Mirrors");
        CrestLegendsID = ConfigCrest(config, "Legends");
        CrestBladesID = ConfigCrest(config, "Blades");
        CrestGluttonyID = ConfigCrest(config, "Gluttony");
        CrestPitchID = ConfigCrest(config, "Pitch");
        CrestThornsID = ConfigCrest(config, "Thorns");
        CrestSanguisugaID = ConfigCrest(config, "Sanguisuga");
        CrestWindsID = ConfigCrest(config, "Winds");
        CrestRetributionID = ConfigCrest(config, "Retribution");
        CrestLightID = ConfigCrest(config, "Light");

        SoulSteveID = config.getInt("Soulstone Steve ID", "Modifier Configs", count++, 18, Integer.MAX_VALUE, null);

        ArmorProtectionID = config
                .getInt("Protection ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorFireProtectionID = config
                .getInt("Fire Protection ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorBlastProtectionID = config
                .getInt("Blast Protection ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorProjectileProtectionID = config
                .getInt("Projectile Protection ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorFeatherfallID = config
                .getInt("Featherfall ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorGlowstepID = config.getInt("Glowstep ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorFrostwalkerID = config
                .getInt("Frostwalker ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorFirewalkerID = config
                .getInt("Firewalker ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorDepthstriderID = config
                .getInt("Depthstrider ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorRebreatherID = config
                .getInt("Rebreather ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorNightvisionID = config
                .getInt("Nightvision ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorAntiBlindnessID = config
                .getInt("Anti Blindness ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorPumpkinID = config.getInt("Pumpkin ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorDodgeID = config.getInt("Dodge ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorThornsID = config.getInt("Thorns ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorAbsorptionID = config
                .getInt("Absorbtion ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorJumpboostID = config
                .getInt("Jump Boost ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorSpeedID = config.getInt("Speed ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorHighstepID = config.getInt("High Step ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        ArmorKnockbackResistID = config
                .getInt("Knockback Resistance ID", "Armor Modifier Configs", count++, 18, Integer.MAX_VALUE, null);

        MineAndBladeAddon = config.getBoolean("Enable Mine and Blade Addon", "Integration", true, "");

        BotaniaAddon = config.getBoolean("Enable Botania Addon", "Integration", true, "");
        CorpseIvyModID = config
                .getInt("Corpse Drinker Ivy Modifier ID", "Botania Addon", count++, 18, Integer.MAX_VALUE, null);
        ManaRepairModID = config
                .getInt("Mana Repair Modifier ID", "Botania Addon", count++, 18, Integer.MAX_VALUE, null);
        TerraCoreModID = config.getInt("Terra Core Modifier ID", "Botania Addon", count++, 18, Integer.MAX_VALUE, null);
        ArmorPixieCoreModID = config
                .getInt("Elementium Core Modifier ID", "Botania Addon", count++, 18, Integer.MAX_VALUE, null);
        ArmorManaDiscountModID = config
                .getInt("Mana Embroidery Modifier ID", "Botania Addon", count++, 18, Integer.MAX_VALUE, null);

        ThaumcraftAddon = config
                .getBoolean("Enable Thaumcraft Addon", "Integration", true, "Requires Thaumcraft to use");
        RevealingModID = config
                .getInt("Revealing Modifier ID", "Thaumcraft Addon", count++, 18, Integer.MAX_VALUE, null);
        VisDiscountModID = config
                .getInt("Vis Discount Modifier ID", "Thaumcraft Addon", count++, 18, Integer.MAX_VALUE, null);
        CapsModID = config.getInt("Cap Repair Modifier ID", "Thaumcraft Addon", count++, 18, Integer.MAX_VALUE, null);
        // SpellbindModID = config.getIntInt("Spellbinding Modifier ID", "Thaumcraft Addon", 73, 0, Integer.MAX_VALUE,
        // "");

        BloodMagicAddon = config
                .getBoolean("Enable BloodMagic Addon", "Integration", true, "Requires BloodMagic to use");
        DivinationModID = config
                .getInt("Divination Modifier ID", "BloodMagic Addon", count++, 18, Integer.MAX_VALUE, null);
        SuppingModID = config.getInt("Supping Modifier ID", "BloodMagic Addon", count++, 18, Integer.MAX_VALUE, null);
        BloodOathModID = config
                .getInt("Blood Oath Modifier ID", "BloodMagic Addon", count++, 18, Integer.MAX_VALUE, null);
        ScabbingModID = config.getInt("Scabbing Modifier ID", "BloodMagic Addon", count++, 18, Integer.MAX_VALUE, null);

        // JokeInsultID = config.getInt("Insult ID", "Joke Modifier Configs", count++, 18, Integer.MAX_VALUE, null);
        // JokePyrotechID = config.getInt("Pyrotech ID", "Joke Modifier Configs", count++, 18, Integer.MAX_VALUE, null);

        config.save();
    }

    private int[] ConfigCrest(Configuration config, String name) {
        final int[] crest = new int[TinkersDefense.colors.length];

        for (int i = 0; i < TinkersDefense.colors.length; i++) {
            crest[i] = config.getInt(
                    "Crest of " + name + " (" + TinkersDefense.colors[i] + ") ID",
                    "Shield Modifier Configs",
                    count++,
                    18,
                    Integer.MAX_VALUE,
                    null);
        }

        return crest;
    }
}
