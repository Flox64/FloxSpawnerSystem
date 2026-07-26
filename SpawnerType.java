package com.flox.spawners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

public enum SpawnerType {
    ZOMBIE("Zombie", EntityType.ZOMBIE, Material.ROTTEN_FLESH, 5000),
    SKELETON("Skeleton", EntityType.SKELETON, Material.BONE, 5000),
    SPIDER("Spider", EntityType.SPIDER, Material.STRING, 5000),
    CREEPER("Creeper", EntityType.CREEPER, Material.GUNPOWDER, 7500),
    ENDERMAN("Enderman", EntityType.ENDERMAN, Material.ENDER_PEARL, 8000),
    COW("Cow", EntityType.COW, Material.LEATHER, 3000),
    PIG("Pig", EntityType.PIG, Material.PORKCHOP, 3000),
    SHEEP("Sheep", EntityType.SHEEP, Material.WHITE_WOOL, 3000),
    CHICKEN("Chicken", EntityType.CHICKEN, Material.FEATHER, 3000),
    IRON_GOLEM("Iron Golem", EntityType.IRON_GOLEM, Material.IRON_INGOT, 50000),
    VILLAGER("Villager", EntityType.VILLAGER, Material.EMERALD, 40000),
    BLAZE("Blaze", EntityType.BLAZE, Material.BLAZE_ROD, 12000),
    PIGLIN("Piglin", EntityType.PIGLIN, Material.GOLD_INGOT, 10000),
    MAGMA_CUBE("Magma Cube", EntityType.MAGMA_CUBE, Material.MAGMA_CREAM, 9000),
    GHAST("Ghast", EntityType.GHAST, Material.GHAST_TEAR, 20000),
    WITHER_SKELETON("Wither Skeleton", EntityType.WITHER_SKELETON, Material.WITHER_SKELETON_SKULL, 35000),
    SLIME("Slime", EntityType.SLIME, Material.SLIME_BALL, 8000),
    WITCH("Witch", EntityType.WITCH, Material.GLASS_BOTTLE, 15000),
    PHANTOM("Phantom", EntityType.PHANTOM, Material.PHANTOM_MEMBRANE, 12000),
    DROWNED("Drowned", EntityType.DROWNED, Material.COPPER_INGOT, 6000),
    HUSK("Husk", EntityType.HUSK, Material.SAND, 6000),
    STRAY("Stray", EntityType.STRAY, Material.ARROW, 6000),
    PIGLIN_BRUTE("Piglin Brute", EntityType.PIGLIN_BRUTE, Material.GOLDEN_AXE, 45000),
    HOGLIN("Hoglin", EntityType.HOGLIN, Material.PORKCHOP, 11000),
    ZOGLIN("Zoglin", EntityType.ZOGLIN, Material.ROTTEN_FLESH, 11000),
    PANDA("Panda", EntityType.PANDA, Material.BAMBOO, 15000),
    FOX("Fox", EntityType.FOX, Material.SWEET_BERRIES, 10000),
    BEE("Bee", EntityType.BEE, Material.HONEYCOMB, 9000),
    RABBIT("Rabbit", EntityType.RABBIT, Material.RABBIT_FOOT, 8000),
    TURTLE("Turtle", EntityType.TURTLE, Material.SCUTE, 12000),
    POLAR_BEAR("Polar Bear", EntityType.POLAR_BEAR, Material.SNOWBALL, 14000),
    LLAMA("Llama", EntityType.LLAMA, Material.LEATHER, 10000),
    DONKEY("Donkey", EntityType.DONKEY, Material.CHEST, 12000),
    MULE("Mule", EntityType.MULE, Material.WHEAT, 12000),
    HORSE("Horse", EntityType.HORSE, Material.SADDLE, 15000),
    OCELOT("Ocelot", EntityType.OCELOT, Material.COD, 10000),
    CAT("Cat", EntityType.CAT, Material.STRING, 10000),
    PARROT("Parrot", EntityType.PARROT, Material.COOKIE, 15000),
    WOLF("Wolf", EntityType.WOLF, Material.BONE, 10000),
    GOAT("Goat", EntityType.GOAT, Material.GOAT_HORN, 13000),
    AXOLOTL("Axolotl", EntityType.AXOLOTL, Material.TROPICAL_FISH, 25000),
    GLOW_SQUID("Glow Squid", EntityType.GLOW_SQUID, Material.GLOW_INK_SAC, 15000),
    SQUID("Squid", EntityType.SQUID, Material.INK_SAC, 8000),
    BAT("Bat", EntityType.BAT, Material.LEATHER, 5000),
    STRIDER("Strider", EntityType.STRIDER, Material.STRING, 10000),
    VEX("Vex", EntityType.VEX, Material.IRON_SWORD, 30000),
    EVOKER("Evoker", EntityType.EVOKER, Material.TOTEM_OF_UNDYING, 60000),
    VINDICATOR("Vindicator", EntityType.VINDICATOR, Material.IRON_AXE, 25000),
    PILLAGER("Pillager", EntityType.PILLAGER, Material.CROSSBOW, 15000),
    RAVAGER("Ravager", EntityType.RAVAGER, Material.SADDLE, 50000),
    WARDEN("Warden", EntityType.WARDEN, Material.SCULK_SHRIEKER, 150000),
    WITHER("Wither", EntityType.WITHER, Material.NETHER_STAR, 200000),
    ALLAY("Allay", EntityType.ALLAY, Material.AMETHYST_SHARD, 40000),
    CAMEL("Camel", EntityType.CAMEL, Material.CACTUS, 20000),
    SNIFFER("Sniffer", EntityType.SNIFFER, Material.PITCHER_POD, 35000);

    private final String displayName;
    private final EntityType entityType;
    private final Material icon;
    private final double basePrice;

    SpawnerType(String displayName, EntityType entityType, Material icon, double basePrice) {
        this.displayName = displayName;
        this.entityType = entityType;
        this.icon = icon;
        this.basePrice = basePrice;
    }

    public String getDisplayName() { return displayName; }
    public EntityType getEntityType() { return entityType; }
    public Material getIcon() { return icon; }
    public double getBasePrice() { return basePrice; }

    public static SpawnerType fromString(String name) {
        for (SpawnerType type : values()) {
            if (type.name().equalsIgnoreCase(name) || type.getDisplayName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}