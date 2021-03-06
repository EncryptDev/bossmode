package de.encryptdev.bossmode.listener.inventory;

import de.encryptdev.bossmode.BossMode;
import de.encryptdev.bossmode.InventoryStorage;
import de.encryptdev.bossmode.boss.mount.MountType;
import de.encryptdev.bossmode.boss.special.ArmySpecialAttack;
import de.encryptdev.bossmode.boss.special.StompSpecialAttack;
import de.encryptdev.bossmode.boss.util.BossManager;
import de.encryptdev.bossmode.boss.util.BossUtil;
import de.encryptdev.bossmode.util.CheckNull;
import de.encryptdev.bossmode.util.ItemCreator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by EncryptDev
 */
public class ListenerInventoryCounterType implements Listener {

    private BossManager bossManager;

    public ListenerInventoryCounterType(BossManager bossManager) {
        this.bossManager = bossManager;
    }

    @EventHandler
    public void on(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getInventory();

        if (CheckNull.checkNull(event))
            return;

        ItemStack itemStack = event.getCurrentItem();

        for (InventoryStorage.CounterType counterType : InventoryStorage.CounterType.values()) {
            if (inventory.getName().equalsIgnoreCase(counterType.getInventoryName())) {
                event.setCancelled(true);
                String itemName = itemStack.getItemMeta().getDisplayName();

                double amount = Double.parseDouble(inventory.getItem(13).getItemMeta().getDisplayName().split(":")[1].replace("§a§l", "").trim());

                switch (itemName) {
                    case "§e-0.1":
                        changeMiddleItem(inventory, counterType, amount - 0.1 <= 0 ? 0 : amount - 0.1);
                        break;
                    case "§e-0.5":
                        changeMiddleItem(inventory, counterType, amount - 0.5 <= 0 ? 0 : amount - 0.5);
                        break;
                    case "§e-1":
                        changeMiddleItem(inventory, counterType, amount - 1.0 <= 0 ? 0 : amount - 1.0);
                        break;
                    case "§e+0.1":
                        changeMiddleItem(inventory, counterType, amount + 0.1);
                        break;
                    case "§e+0.5":
                        changeMiddleItem(inventory, counterType, amount + 0.5);
                        break;
                    case "§e+1":
                        changeMiddleItem(inventory, counterType, amount + 1.0);
                        break;
                    case "§e-5":
                        changeMiddleItem(inventory, counterType, amount - 5.0 <= 0 ? 0 : amount - 5.0);
                        break;
                    case "§e-10":
                        changeMiddleItem(inventory, counterType, amount - 10.0 <= 0 ? 0 : amount - 10.0);
                        break;
                    case "§e-50":
                        changeMiddleItem(inventory, counterType, amount - 50.0 <= 0 ? 0 : amount - 50.0);
                        break;
                    case "§e+5":
                        changeMiddleItem(inventory, counterType, amount + 5.0);
                        break;
                    case "§e+10":
                        changeMiddleItem(inventory, counterType, amount + 10.);
                        break;
                    case "§e+50":
                        changeMiddleItem(inventory, counterType, amount + 50.0);
                        break;
                    case "§eFinish":
                        switch (counterType) {
                            case CHANCE_TO_SPAWN:
                                bossManager.getBossEditor(player).setChanceToSpawn((float) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case DAMAGE:
                                bossManager.getBossEditor(player).setDamage(amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case DROP_CHANCE_MAIN_HAND:
                                bossManager.getBossEditor(player).setDropChanceMainHand((float) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().equipment());
                                break;
                            case DROP_CHANCE_OFF_HAND:
                                bossManager.getBossEditor(player).setDropChanceOffHand((float) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().equipment());
                                break;
                            case DROPPED_XP:
                                bossManager.getBossEditor(player).setDroppedXp((int) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case HEALTH:
                                bossManager.getBossEditor(player).setMaxHealth(amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case NEARBY_RADIUS:
                                bossManager.getBossEditor(player).setNearbyRad(amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case SPAWN_AMOUNT:
                                bossManager.getBossEditor(player).setSpawnAmount((int) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case SPAWN_RADIUS:
                                bossManager.getBossEditor(player).setSpawnRadius(amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case SPAWNER_DELAY:
                                bossManager.getSpawnerEditor(player).setDelay((int) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().spawnerInventory());
                                break;
                            case SPAWNER_MAX_DELAY:
                                bossManager.getSpawnerEditor(player).setMaxSpawnDelay((int) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().spawnerInventory());
                                break;
                            case SPAWNER_MIN_DELAY:
                                bossManager.getSpawnerEditor(player).setMinSpawnDelay((int) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().spawnerInventory());
                                break;
                            case SPAWNER_REQUIRED_PLAYERS_RANGE:
                                bossManager.getSpawnerEditor(player).setRequiredPlayerRange((int) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().spawnerInventory());
                                break;
                            case SPAWNER_SPAWN_COUNT:
                                bossManager.getSpawnerEditor(player).setSpawnCount((int) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().spawnerInventory());
                                break;
                            case SPAWNER_SPAWN_RANGE:
                                bossManager.getSpawnerEditor(player).setSpawnRange((int) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().spawnerInventory());
                                break;
                            case SPECIAL_ATTACK_ARMY_AMOUNT:
                                bossManager.getBossEditor(player).setAmountArmy((int) amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().counterInventory(InventoryStorage.CounterType.SPECIAL_ATTACK_ARMY_CHANCE,
                                        BossUtil.checkDefaultValue(InventoryStorage.CounterType.SPECIAL_ATTACK_ARMY_CHANCE, bossManager.getBossEditor(player).getAmountArmy()) ? InventoryStorage.CounterType.SPECIAL_ATTACK_ARMY_CHANCE.getDefaultValue() :
                                                bossManager.getBossEditor(player).getAmountArmy()));
                                break;
                            case SPECIAL_ATTACK_ARMY_CHANCE:
                                bossManager.getBossEditor(player).addSpecialAttack(new ArmySpecialAttack(bossManager.getBossEditor(player).getAmountArmy(), amount));
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case SPECIAL_ATTACK_STOMP_STRENGTH:
                                bossManager.getBossEditor(player).addSpecialAttack(new StompSpecialAttack(amount));
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case SPEED:
                                bossManager.getBossEditor(player).setSpeed(amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case MOUNT_HEALTH_BAT:
                                bossManager.getBossEditor(player).setMount(MountType.BAT, amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case MOUNT_HEALTH_COW:
                                bossManager.getBossEditor(player).setMount(MountType.COW, amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                            case MOUNT_HEALTH_PIG:
                                bossManager.getBossEditor(player).setMount(MountType.PIG, amount);
                                player.openInventory(BossMode.getInstance().getInventoryStorage().bossSettings(bossManager.getBossEditor(player).isNaturalSpawn()));
                                break;
                        }
                        break;
                }

            }
        }

    }

    private void changeMiddleItem(Inventory inventory, InventoryStorage.CounterType counterType, double amount) {
        inventory.setItem(13, ItemCreator.getItem(Material.GOLD_NUGGET, counterType.getInventoryName() + ": §a§l" + amount, 1));
    }
}
