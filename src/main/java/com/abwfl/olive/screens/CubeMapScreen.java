package com.abwfl.olive.screens;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public class CubeMapScreen extends Screen {
    private final List<ResourceLocation> textureIds;
    private final Function<ResourceLocation, TextureAtlasSprite> atlasGetter;
    private int currentIndex = 0;
    private long lastSwitchTime = 0;

    public CubeMapScreen(List<ResourceLocation> textureIds, Function<ResourceLocation, TextureAtlasSprite> atlasGetter) {
        super(Component.literal("Texture Viewer"));
        this.textureIds = textureIds;
        this.atlasGetter = atlasGetter;
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        long time = System.currentTimeMillis();
        if (time - lastSwitchTime > 10) {
            currentIndex = (currentIndex + 1) % textureIds.size();
            lastSwitchTime = time;
        }

        ResourceLocation textureId = textureIds.get(currentIndex);
        TextureAtlasSprite sprite = atlasGetter.apply(textureId);

        guiGraphics.fill(
                RenderType.gui(),
                0, 0,
                width, height,
                -16777216
        );

        guiGraphics.blitSprite(
                RenderType::guiTextured,
                sprite,
                0, 0,
                (int) (width*.2), (int) (width*.2)
        );
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }
}

