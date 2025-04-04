package gmail.Lance5057;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gmail.Lance5057.compat.Mods;
import gmail.Lance5057.items.Shield;
import iguanaman.iguanatweakstconstruct.leveling.LevelingLogic;
import tconstruct.library.tools.AbilityHelper;

public class DefenseEvents {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onHurt(LivingHurtEvent event) {
        if (event.source.isUnblockable()) return;
        // no hugging cacti
        if (event.source == DamageSource.cactus) return;
        if (event.entityLiving instanceof EntityPlayer player) {
            if (player instanceof FakePlayer) return;

            if (player.isBlocking()) {
                ItemStack itemInUse = player.itemInUse;
                if (itemInUse.getItem() instanceof Shield shield) {
                    // block only from front
                    if (event.source instanceof EntityDamageSource entityDamageSource) {
                        if (entityDamageSource.getEntity() != null) {
                            Vec3 sourcePosition = Vec3.createVectorHelper(
                                    entityDamageSource.getEntity().posX,
                                    entityDamageSource.getEntity().posY,
                                    entityDamageSource.getEntity().posZ);
                            Vec3 playerLook = player.getLook(1);
                            Vec3 playerPos = player.getPosition(1.0F);
                            Vec3 vec3d2 = sourcePosition.subtract(playerPos).normalize();
                            vec3d2 = Vec3.createVectorHelper(vec3d2.xCoord, 0.0D, vec3d2.zCoord);

                            if (vec3d2.dotProduct(playerLook) >= 0.0D) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }

                    NBTTagCompound toolTags = itemInUse.getTagCompound().getCompoundTag("InfiTool");
                    if (toolTags == null) return; // how?
                    if (toolTags.getBoolean("Broken")) return;
                    int currentDamage = toolTags.getInteger("Damage");
                    int maxDamage = toolTags.getInteger("TotalDurability");

                    // Block all damage, except if it overflows the shields durability
                    float damageAbsorbed = event.ammount;
                    if (currentDamage + damageAbsorbed > maxDamage)
                        damageAbsorbed -= (maxDamage - (currentDamage + damageAbsorbed));
                    float leftOverDamage = event.ammount - damageAbsorbed;
                    // just in case, cap to int max
                    if (damageAbsorbed >= Integer.MAX_VALUE) damageAbsorbed = Integer.MAX_VALUE - 1;

                    // damage shield based on absorbed damage; affected by reinforced
                    AbilityHelper.damageTool(itemInUse, (int) Math.ceil(damageAbsorbed), player, false);

                    if (Mods.IguanaTweaks.isLoaded()) {
                        // gain xp equal to absorbed damage, capped to tool durability
                        // * 10 to not be terrible to level
                        LevelingLogic.addXP(itemInUse, player, (long) (damageAbsorbed * 10));
                    }

                    // factor in the vanilla blocking calculations
                    event.ammount = (leftOverDamage * 2);
                }
            }
        }
    }
}
