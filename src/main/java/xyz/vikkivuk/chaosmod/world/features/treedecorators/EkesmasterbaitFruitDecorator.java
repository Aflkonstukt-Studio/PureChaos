package xyz.vikkivuk.chaosmod.world.features.treedecorators;

public class EkesmasterbaitFruitDecorator extends CocoaDecorator {

    public static final EkesmasterbaitFruitDecorator INSTANCE = new EkesmasterbaitFruitDecorator();

    public static com.mojang.serialization.Codec<EkesmasterbaitFruitDecorator> codec;
    public static TreeDecoratorType<?> tdt;

    static {
        codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
        tdt = new TreeDecoratorType<>(codec);
        tdt.setRegistryName("ekesmasterbait_tree_fruit_decorator");
        ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
    }

    public EkesmasterbaitFruitDecorator() {
        super(0.2f);
    }

    @Override protected TreeDecoratorType<?> type() {
        return tdt;
    }

    @Override /* failed to load code for net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator */

}
