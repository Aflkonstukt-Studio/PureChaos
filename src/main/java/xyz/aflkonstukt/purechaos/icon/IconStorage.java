package xyz.aflkonstukt.purechaos.icon;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.server.packs.resources.IoSupplier;
import org.apache.commons.io.IOUtils;
import xyz.aflkonstukt.purechaos.PurechaosMod;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class IconStorage {
    private static final String RESOURCES_ROOT = "assets/purechaos/icons/";
    private static final Map<String, byte[]> STORAGE = Maps.newLinkedHashMap();
    private static final List<String> PNG_PATHS = Lists.newArrayList();
    private static boolean inited = false;

    public IconStorage() {
    }

    public static synchronized void init() {
        if (!inited) {
            loadResource("icon_16x16.png", true);
            loadResource("icon_32x32.png", true);
            loadResource("icon_48x48.png", true);
            loadResource("icon_128x128.png", true);
            loadResource("icon_256x256.png", true);
            PurechaosMod.LOGGER.info("{} initialized", IconStorage.class.getSimpleName());
            Minecraft.getInstance().getWindow().setTitle("Pure Chaos");

            inited = true;
        }
    }

    private static void loadResource(String path, boolean isPng) {
        String fullPath = RESOURCES_ROOT + path;
        ClassLoader classLoader = IconStorage.class.getClassLoader();

        try {
            InputStream stream = classLoader.getResourceAsStream(fullPath);

            try {
                if (stream == null) {
                    throw new IOException("getResourceAsStream failed");
                }

                byte[] data = IOUtils.toByteArray(stream);
                STORAGE.put(path, data);
                if (isPng) {
                    PNG_PATHS.add(path);
                }
            } catch (Throwable var8) {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (stream != null) {
                stream.close();
            }

        } catch (IOException var9) {
            throw new RuntimeException(String.format("Failed to load resource %s: %s", fullPath, var9));
        }
    }

    public static IoSupplier<InputStream> getResource(String path) {
        init();
        byte[] data = (byte[])STORAGE.get(path);
        if (data == null) {
            throw new RuntimeException("Unexpected resource path " + path);
        } else {
            return () -> {
                return new ByteArrayInputStream(data);
            };
        }
    }

    public static List<IoSupplier<InputStream>> getAllPngResources() {
        init();
        return PNG_PATHS.stream().map(IconStorage::getResource).toList();
    }
}
