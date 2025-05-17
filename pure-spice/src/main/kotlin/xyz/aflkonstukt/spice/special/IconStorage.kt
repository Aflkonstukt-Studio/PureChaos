package xyz.aflkonstukt.spice.special

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import net.minecraft.client.Minecraft
import net.minecraft.server.packs.resources.IoSupplier
import org.apache.commons.io.IOUtils
import xyz.aflkonstukt.purechaos.PurechaosMod
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream

object IconStorage {
    private const val RESOURCES_ROOT = "assets/purechaos/icons/"
    private val STORAGE: MutableMap<String?, ByteArray?> =
        Maps.newLinkedHashMap<String?, ByteArray?>()
    private val PNG_PATHS: MutableList<String?> = Lists.newArrayList<String?>()
    private var inited = false

    @Synchronized
    fun init() {
        if (!inited) {
            loadResource("icon_16x16.png", true)
            loadResource("icon_32x32.png", true)
            loadResource("icon_48x48.png", true)
            loadResource("icon_128x128.png", true)
            loadResource("icon_256x256.png", true)
            PurechaosMod.LOGGER.info("{} initialized", IconStorage::class.java.simpleName)
            Minecraft.getInstance().window.setTitle( "Pure Chaos" )
            inited = true
        }
    }

    private fun loadResource(path: String, isPng: Boolean) {
        val fullPath = RESOURCES_ROOT + path
        val classLoader = IconStorage::class.java.classLoader

        try {
            val stream = classLoader.getResourceAsStream(fullPath)
            try {
                if (stream == null) {
                    throw IOException("getResourceAsStream failed")
                }
                val data = IOUtils.toByteArray(stream)
                STORAGE[path] = data
                if (isPng) {
                    PNG_PATHS.add(path)
                }
            } catch (var8: Throwable) {
                stream?.let {
                    try {
                        it.close()
                    } catch (var7: Throwable) {
                        var8.addSuppressed(var7)
                    }
                }
                throw var8
            }
            stream?.close()
        } catch (var9: IOException) {
            throw RuntimeException(
                String.format("Failed to load resource %s: %s", fullPath, var9)
            )
        }
    }

    fun getResource(path: String?): IoSupplier<InputStream?> {
        init()
        val data = STORAGE[path] as ByteArray?
        if (data == null) {
            throw RuntimeException("Unexpected resource path $path")
        } else {
            return IoSupplier { ByteArrayInputStream(data) }
        }
    }

    // This is the new static-style function you can call from Java or Kotlin
    fun getAllPngResources(): List<IoSupplier<InputStream?>> {
        init()
        return PNG_PATHS.map { obj -> getResource(obj) }
    }
}