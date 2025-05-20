package xyz.aflkonstukt.spice.special

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.minecraft.ChatFormatting
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.components.Button
import net.minecraft.client.gui.screens.Screen
import net.minecraft.client.gui.screens.TitleScreen
import net.minecraft.network.chat.Component
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.ScreenEvent
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables
import java.io.IOException
import java.io.StringReader

class UpdateScreen(
    private val pcVersion: String?,
    private val mcVersion: String?
) : Screen(Component.literal("Pure Chaos is outdated!"))
{

    private val backAction = Button.OnPress {
        minecraft?.setScreen(TitleScreen())
    }

    override fun init() {
        super.init()
        addRenderableWidget(
            Button.Builder(
                Component.literal("I'll take my chances"),
                backAction
            ).pos(width / 2 - 100, 200)
                .width(200)
                .build()
        )
    }

    override fun render(
        guiGraphics: GuiGraphics,
        mouseX: Int,
        mouseY: Int,
        partialTick: Float
    ) {
        renderBackground(guiGraphics, mouseX, mouseY, partialTick)
        renderPanorama(guiGraphics, partialTick)
        val poseStack = guiGraphics.pose()
        poseStack.pushPose()
        poseStack.scale(1.2f, 1.2f, 1.2f)
        guiGraphics.drawCenteredString(
            font,
            Component.literal("${ChatFormatting.YELLOW}⚠ Pure Chaos is outdated! ⚠"),
            (width.toDouble() / 2 / 1.2).toInt(),
            (70 / 1.2).toInt(),
            0xFFFFFF
        )
        guiGraphics.drawCenteredString(
            font,
            Component.literal(
                "Stay outdated, and Buddy ${ChatFormatting.ITALIC}will${ChatFormatting.RESET} jump off a cliff"
            ),
            (width.toDouble() / 2 / 1.2).toInt(),
            (85 / 1.2).toInt(),
            0xFFFFFF
        )
        guiGraphics.drawCenteredString(
            font,
            Component.literal(
                "while Stalin ${ChatFormatting.ITALIC}might${ChatFormatting.RESET} pay you a visit."
            ),
            (width.toDouble() / 2 / 1.2).toInt(),
            (95 / 1.2).toInt(),
            0xFFFFFF
        )
        guiGraphics.drawCenteredString(
            font,
            Component.literal(
                "The latest version is ${ChatFormatting.AQUA}$pcVersion on MC$mcVersion"
            ),
            (width.toDouble() / 2 / 1.2).toInt(),
            (120 / 1.2).toInt(),
            0xFFFFFF
        )
        guiGraphics.drawCenteredString(
            font,
            Component.literal("Don't say we didn't warn you."),
            (width.toDouble() / 2 / 1.2).toInt(),
            (132 / 1.2).toInt(),
            0xFFFFFF
        )
        poseStack.popPose()
        super.render(guiGraphics, mouseX, mouseY, partialTick)
    }

    override fun shouldCloseOnEsc(): Boolean = false

    override fun renderBackground(
        guiGraphics: GuiGraphics,
        p_295208_: Int,
        p_294981_: Int,
        p_294740_: Float
    ) {
        // Optionally implement custom background rendering here
    }

    override fun renderPanorama(guiGraphics: GuiGraphics, p_331140_: Float) {
        PANORAMA.render(guiGraphics, width, height, 1.0f, p_331140_)
    }
}

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
object UpdateScreenEventHandler {
    private var shownScreen: Boolean = false

    @SubscribeEvent
    fun onScreenInit(event: ScreenEvent.Init.Post) {
        if (event.screen !is TitleScreen) return
        if (shownScreen) return
        shownScreen = true

        Thread {
            try {
                val httpclient = HttpClients.createDefault()
                val httpget = HttpGet("https://pastebin.com/raw/rTQuWtMg")
                val response = httpclient.execute(httpget)
                val responseString = EntityUtils.toString(response.entity)
                response.close()
                val gson = Gson()
                val reader = JsonReader(StringReader(responseString))
                val data: JsonObject? = gson.fromJson(reader, JsonObject::class.java)
                if (data != null) {
                    val latestPCVersion = data.get("latest")?.asString
                    val latestMCVersion = data.get("mcv")?.asString
                    if (latestPCVersion != null && latestPCVersion != "PC2025.2") {
                        PurechaosModVariables.outdated = true
                        // Schedule on main thread
                        Minecraft.getInstance().execute {
                            Minecraft.getInstance().setScreen(
                                UpdateScreen(latestPCVersion, latestMCVersion)
                            )
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }
}