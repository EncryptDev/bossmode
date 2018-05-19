package de.encryptdev.bossmode.boss;

import de.encryptdev.bossmode.boss.path.BossPathfinderEdited;
import de.encryptdev.bossmode.boss.special.SpecialAttack;
import de.encryptdev.bossmode.boss.util.BossSettings;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by EncryptDev
 */
public interface IBoss {

    void spawnBoss(Location location);

    BossBar getBossBar();

    String getBossName();

    int getBossID();

    int getLivingID();

    void damageEntity(double damage);

    void death();

    void heal(double amount);

    boolean hasSpawner();

    void setHasSpawner(boolean bool);

    void setName(String name);

    EntityType getEntityType();

    Location getSpawnLocation();

    LivingEntity getBossEntity();

    BossSettings getBossSettings();

    List<SpecialAttack> getSpecialAttacks();

    World getWorld();

    void setWorldName(String worldName);

    BossPathfinderEdited editBossPathfinder();

    void setBossPathfinderEdit(BossPathfinderEdited bossPathfinderEdit);

    void setBossSettings(BossSettings settings);

    ItemStack getEgg();

}