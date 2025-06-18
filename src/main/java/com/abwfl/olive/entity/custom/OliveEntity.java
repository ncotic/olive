package com.abwfl.olive.entity.custom;

import com.abwfl.olive.networking.OlivePacket;
import com.abwfl.olive.registers.EntityTypesRegister;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.UUID;

public class OliveEntity extends LivingEntity {
    private ChunkPos lastForcedChunk = null;
    private static final Random r = new Random();
    private Player summoner;
    private UUID trackedPlayerUUID;

    public OliveEntity(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
        this.noPhysics = true;
        this.setNoGravity(true);
    }

    @NotNull
    public static AttributeSupplier.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 1000000d);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide) {
            ChunkPos currentChunk = new ChunkPos(this.blockPosition());
            ServerLevel serverLevel = (ServerLevel) this.level();

            if (!currentChunk.equals(lastForcedChunk)) {
                if (lastForcedChunk != null) {
                    serverLevel.getChunkSource().removeTicketWithRadius(
                            TicketType.FORCED,
                            lastForcedChunk,
                            2
                    );
                }

                serverLevel.getChunkSource().addTicketWithRadius(
                        TicketType.FORCED,
                        currentChunk,
                        2
                );

                lastForcedChunk = currentChunk;
            }
        }

        if (summoner != null) {
            // LivingEntity target = this.level().getNearestPlayer(this, 60000000);
            if (summoner.level().dimension() == this.level().dimension()) {
                Vec3 direction = summoner.position().subtract(position()).normalize().scale(0.15);
                setDeltaMovement(direction);

                double dx = summoner.getX() - getX();
                double dz = summoner.getZ() - getZ();
                double dy = summoner.getY() - getY();

                setYRot((float) (Math.toDegrees(Math.atan2(dz, dx))) - 90);
                setXRot((float) (-Math.toDegrees(Math.atan2(dy, Math.sqrt(dx * dx + dz * dz)))));
            }

            if (position().distanceTo(summoner.position()) < 0.5 && summoner.level().dimension() == this.level().dimension()) {
                if (!summoner.level().isClientSide() && position().distanceTo(summoner.position()) < 0.1) {
                    new Thread(() -> {
                        try {
                            PacketDistributor.sendToPlayer((ServerPlayer) summoner, new OlivePacket(trackedPlayerUUID.toString()));
                            Thread.sleep(300);
                            this.remove(RemovalReason.DISCARDED);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }).start();
                }
            }

            if (!this.level().isClientSide && summoner.level().dimension() != this.level().dimension()) {
                OliveEntity entity = new OliveEntity(EntityTypesRegister.OLIVE.get(), summoner.level());
                entity.setPos(new Vec3(summoner.getX() + (r.nextInt(151) - 75), summoner.getY() + r.nextInt(50), summoner.getZ() + (r.nextInt(151) - 75)));
                entity.setTrackedPlayer(trackedPlayerUUID);
                summoner.level().addFreshEntity(entity);
                this.remove(RemovalReason.DISCARDED);
            }
        }
    }

    public void setTrackedPlayer(UUID playerUUID) {
        this.trackedPlayerUUID = playerUUID;
        this.summoner = this.level().getPlayerByUUID(playerUUID);
    }

    public void onTrackedPlayerLogout() {
        this.setInvisible(true);
        this.summoner = null;
    }

    public void onTrackedPlayerLogin(@NotNull ServerPlayer player) {
        if (player.getUUID().equals(trackedPlayerUUID)) {
            this.setInvisible(false);
            this.summoner = this.level().getPlayerByUUID(player.getUUID());
        }
    }

    @Override
    public void remove(RemovalReason reason) {
        super.remove(reason);

        OlivePlayerManager.removeTracker(trackedPlayerUUID);

        if (lastForcedChunk != null && this.level() instanceof ServerLevel serverLevel) {
            serverLevel.getChunkSource().removeTicketWithRadius(
                    TicketType.UNKNOWN,
                    lastForcedChunk,
                    1
            );
        }
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public HumanoidArm getMainArm() {
        return null;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        if (trackedPlayerUUID != null) {
            tag.putString("trackedPlayerUUID", trackedPlayerUUID.toString());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("trackedPlayerUUID")) {
            trackedPlayerUUID = UUID.fromString(tag.getString("trackedPlayerUUID").orElseThrow());
        }
    }

}
