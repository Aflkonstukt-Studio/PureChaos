package xyz.aflkonstukt.spice.special

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.stream.JsonReader
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

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
class UpdateScreen(private val pcVersion: String?, private val mcVersion: String?) :
    Screen(Component.literal("Pure Chaos is outdated!")) {
    private val backAction = Button.OnPress { button: Button? ->
        checkNotNull(this.minecraft)
        this.minecraft!!.setScreen(TitleScreen())
    }

    override fun init() {
        super.init()
        this.addRenderableWidget<Button?>(
            Button.Builder(Component.literal("I'll take my chances"), this.backAction).pos(this.width / 2 - 100, 200)
                .width(200).build()
        )
    }

    override fun render(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick)
        this.renderPanorama(guiGraphics, partialTick)
        val poseStack = guiGraphics.pose()
        poseStack.pushPose()
        poseStack.scale(1.2f, 1.2f, 1.2f) // Adjust the scale as needed
        guiGraphics.drawCenteredString(
            this.font,
            Component.literal(ChatFormatting.YELLOW.toString() + "⚠ Pure Chaos is outdated! ⚠"),
            (this.width.toDouble() / 2 / 1.2).toInt(),
            (70 / 1.2).toInt(),
            16777215
        )
        guiGraphics.drawCenteredString(
            this.font,
            Component.literal("Stay outdated, and Buddy " + ChatFormatting.ITALIC + "will" + ChatFormatting.RESET + " jump off a cliff"),
            (this.width.toDouble() / 2 / 1.2).toInt(),
            (85 / 1.2).toInt(),
            16777215
        )
        guiGraphics.drawCenteredString(
            this.font,
            Component.literal("while Stalin " + ChatFormatting.ITALIC + "might" + ChatFormatting.RESET + " pay you a visit."),
            (this.width.toDouble() / 2 / 1.2).toInt(),
            (95 / 1.2).toInt(),
            16777215
        )
        guiGraphics.drawCenteredString(
            this.font,
            Component.literal("The latest version is " + ChatFormatting.AQUA + pcVersion + " on MC" + mcVersion),
            (this.width.toDouble() / 2 / 1.2).toInt(),
            (120 / 1.2).toInt(),
            16777215
        )
        guiGraphics.drawCenteredString(
            this.font,
            Component.literal("Don't say we didn't warn you."),
            (this.width.toDouble() / 2 / 1.2).toInt(),
            (132 / 1.2).toInt(),
            16777215
        )

        poseStack.popPose()
        super.render(guiGraphics, mouseX, mouseY, partialTick)
    }

    override fun shouldCloseOnEsc(): Boolean {
        return false
    }

    override fun renderBackground(guiGraphics: GuiGraphics, p_295208_: Int, p_294981_: Int, p_294740_: Float) {}

    override fun renderPanorama(guiGraphics: GuiGraphics, p_331140_: Float) {
        PANORAMA.render(guiGraphics, this.width, this.height, 1.0f, p_331140_)
    }

    companion object {
        var shownScreen: Boolean = false

        @SubscribeEvent
        fun screenEvent(event: ScreenEvent.Init.Post) {
            if (event.getScreen() !is TitleScreen) return
            if (shownScreen) return
            shownScreen = true
            try {
                // Send the request
                val httpclient = HttpClients.createDefault()
                val httpget = HttpGet("https://pastebin.com/raw/rTQuWtMg")

                // Get the response
                val responseString = EntityUtils.toString(httpclient.execute(httpget).getEntity())

                val gson = Gson()
                val reader = JsonReader(StringReader(responseString))
                val data = gson.fromJson<JsonObject?>(reader, JsonObject::class.java)
                println(data)
                if (data.get("latest").getAsString() != "PC2025") {
                    val latestMCVersion = data.get("mcv").getAsString()
                    val latestPCVersion = data.get("latest").getAsString()
                    PurechaosModVariables.outdated = true

                    Minecraft.getInstance().setScreen(UpdateScreen(latestPCVersion, latestMCVersion))
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}
