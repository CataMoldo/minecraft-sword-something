package com.autosword.handlers;

import com.autosword.AutoSwordMod;
import com.autosword.config.AutoSwordConfig;
import com.autosword.keybinds.KeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Mod.EventBusSubscriber(modid = AutoSwordMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class AutoAttackHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoAttackHandler.class);
    private static final Minecraft minecraft = Minecraft.getInstance();
    
    private static long lastAttackTime = 0;
    private static boolean autoAttackEnabled = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (minecraft.player == null || minecraft.level == null) return;
        if (!AutoSwordConfig.enabled && !autoAttackEnabled) return;

        // Check if we should continue attacking even when in menus
        if (!AutoSwordConfig.workInMenus && (minecraft.screen != null || !minecraft.isWindowActive())) {
            return;
        }

        LocalPlayer player = minecraft.player;
        long currentTime = System.currentTimeMillis();

        // Check if enough time has passed since last attack
        if (currentTime - lastAttackTime < AutoSwordConfig.attackInterval) {
            return;
        }

        // Check if player is holding a sword (if required)
        if (AutoSwordConfig.onlySwords) {
            ItemStack heldItem = player.getMainHandItem();
            if (!(heldItem.getItem() instanceof SwordItem)) {
                return;
            }
        }

        // Check if we need a target and if there's a valid target
        if (AutoSwordConfig.requireTarget) {
            Entity target = getTargetEntity(player);
            if (target == null) {
                return;
            }
        }

        // Perform the attack
        performAttack(player);
        lastAttackTime = currentTime;
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (KeyBindings.TOGGLE_AUTO_ATTACK.consumeClick()) {
            autoAttackEnabled = !autoAttackEnabled;
            LOGGER.info("Auto attack toggled: {}", autoAttackEnabled ? "ON" : "OFF");
        }
    }

    private static void performAttack(LocalPlayer player) {
        // Use the same attack logic as the game
        if (player.attackStrengthTicker > 0) {
            return; // Still on cooldown
        }

        // Get the target entity
        Entity target = getTargetEntity(player);
        
        if (target != null) {
            // Attack the target
            player.attack(target);
            player.swing(InteractionHand.MAIN_HAND);
        } else {
            // Just swing the weapon
            player.swing(InteractionHand.MAIN_HAND);
        }
    }

    private static Entity getTargetEntity(LocalPlayer player) {
        // Get the player's look direction
        Vec3 lookVec = player.getLookAngle();
        Vec3 eyePos = player.getEyePosition();
        
        // Create a ray from the player's eyes in the look direction
        Vec3 endPos = eyePos.add(lookVec.scale(4.0)); // 4 block reach
        
        // Get all entities in a box around the ray
        AABB searchBox = new AABB(eyePos, endPos).inflate(1.0);
        List<Entity> entities = player.level.getEntities(player, searchBox);
        
        Entity closestEntity = null;
        double closestDistance = Double.MAX_VALUE;
        
        for (Entity entity : entities) {
            if (!(entity instanceof LivingEntity)) continue;
            if (entity == player) continue;
            
            // Check if the entity is in the player's line of sight
            AABB entityBox = entity.getBoundingBox();
            if (entityBox.intersects(searchBox)) {
                double distance = player.distanceTo(entity);
                if (distance < closestDistance && distance <= 4.0) {
                    closestEntity = entity;
                    closestDistance = distance;
                }
            }
        }
        
        return closestEntity;
    }
}
