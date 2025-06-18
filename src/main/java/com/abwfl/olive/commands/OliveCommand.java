package com.abwfl.olive.commands;

import com.abwfl.olive.entity.custom.OliveEntity;
import com.abwfl.olive.entity.custom.OlivePlayerManager;
import com.abwfl.olive.registers.EntityTypesRegister;
import com.abwfl.olive.registers.SoundEventsRegister;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;
import java.util.Random;

public class OliveCommand {
    public static Random r = new Random();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("INTERLOPE")
                .executes(OliveCommand::interlope));
        dispatcher.register(Commands.literal("get")
                .then(Commands.argument("server", StringArgumentType.string())
                        .executes(OliveCommand::get)));
    }
    private static int interlope(CommandContext<CommandSourceStack> command){
        if(command.getSource().getEntity() instanceof Player player){
            player.displayClientMessage(Component.translatable("command.unknown.command").withColor(16733525), false);
            player.addTag("interlope");
        }
        return Command.SINGLE_SUCCESS;
    }
    private static int get(CommandContext<CommandSourceStack> command){
        if(command.getSource().getEntity() instanceof Player player && command.getArgument("server", String.class) != null) {
            if (Objects.equals(command.getArgument("server", String.class), "s.interlope.pull:25565") && player.getTags().contains("interlope")) {
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEventsRegister.SPAWN_SOUND.get(), SoundSource.MASTER);
                OliveEntity entity = new OliveEntity(EntityTypesRegister.OLIVE.get(), player.level());
                entity.setTrackedPlayer(player.getUUID());
                OlivePlayerManager.registerTracker(player.getUUID(), entity.getUUID());
                entity.setPos(new Vec3(player.getX() + (r.nextInt(151) - 75), player.getY() + r.nextInt(50), player.getZ() + (r.nextInt(151) - 75)));
                player.level().addFreshEntity(entity);
                player.displayClientMessage(Component.translatable("multiplayer.player.joined", "Olive").withColor(16777045), false);
                player.removeTag("interlope");
            } else {
                player.displayClientMessage(Component.translatable("connect.failed").withColor(16733525), false);
            }
        }
        return Command.SINGLE_SUCCESS;
    }
}
