package xyz.vikkivuk.chaosmod.world.features.treedecorators;

public class HellButOverworldFruitDecorator extends CocoaDecorator {

    public static final HellButOverworldFruitDecorator INSTANCE = new HellButOverworldFruitDecorator();

    public static com.mojang.serialization.Codec<HellButOverworldFruitDecorator> codec;
    public static TreeDecoratorType<?> tdt;

    static {
        codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
        tdt = new TreeDecoratorType<>(codec);
        tdt.setRegistryName("hell_but_overworld_tree_fruit_decorator");
        ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
    }

    public HellButOverworldFruitDecorator() {
        super(0.2f);
    }

    @Override protected TreeDecoratorType<?> type() {
        return tdt;
    }

    @Override /* failed to load code for net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator */

}
