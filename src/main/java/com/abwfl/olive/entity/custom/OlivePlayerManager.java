package com.abwfl.olive.entity.custom;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OlivePlayerManager {
    private static final Map<UUID, UUID> activeTrackers = new HashMap<>();

    public static boolean hasTracker(UUID playerId) {
        return activeTrackers.containsKey(playerId);
    }

    public static void registerTracker(UUID playerId, UUID entityId) {
        activeTrackers.put(playerId, entityId);
    }

    public static void removeTracker(UUID playerId) {
        activeTrackers.remove(playerId);
    }

    public static UUID getEntityId(UUID playerId) {
        return activeTrackers.get(playerId);
    }
}

