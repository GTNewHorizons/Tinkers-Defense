package gmail.Lance5057.items;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.battlegear2.api.ISheathed;
import mods.battlegear2.api.shield.IArrowCatcher;
import mods.battlegear2.api.shield.IArrowDisplay;
import mods.battlegear2.api.shield.IShield;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.library.tools.HarvestTool;
import tconstruct.tools.TinkerTools;

public class HeaterShield extends HarvestTool implements IShield, ISheathed, IArrowCatcher, IArrowDisplay {

    int induceDamage = 0;

    public HeaterShield() {
        super(0);
        this.setUnlocalizedName("heatershield");
    }

    @Override
    public Item getHeadItem() {
        return TinkerTools.largePlate;
    }

    @Override
    public Item getHandleItem() {
        return TinkerTools.toughRod;
    }

    @Override
    public Item getAccessoryItem() {
        return TinkerTools.largePlate;
    }

    @Override
    public Item getExtraItem() {
        return TinkerTools.toughBinding;
    }

    @Override
    public int durabilityTypeAccessory() {
        return 2;
    }

    @Override
    public float getRepairCost() {
        return 4.0f;
    }

    @Override
    public float getDurabilityModifier() {
        return 2.5f;
    }

    @Override
    public float breakSpeedModifier() {
        return 0.4f;
    }

    @Override
    public float getDamageModifier() {
        return 1.4f;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getPartAmount() {
        return 4;
    }

    @Override
    public String getIconSuffix(int partType) {
        switch (partType) {
            case 0:
                return "_shield_face";
            case 1:
                return "_shield_face_broken";
            case 2:
                return "_shield_edge";
            case 3:
                return "_shield_face_other";
            case 4:
                return "_shield_binding";
            default:
                return "";
        }
    }

    @Override
    public String getEffectSuffix() {
        return "_shield_effect";
    }

    @Override
    public String getDefaultFolder() {
        return "heatershield";
    }

    /* tool_TinkerShield specific */
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (AbilityHelper.onLeftClickEntity(stack, player, entity, this)) {
            entity.hurtResistantTime += 7;
            /*
             * if (entity instanceof EntityLiving) { EntityLiving living = (EntityLiving) entity; if (living.getHealth()
             * <= 0) { } }
             */
            // if (entity.getHealth() <= 0)
        }
        return true;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        super.onUpdate(stack, world, entity, par4, par5);
    }

    @Override
    public int getArrowCount(ItemStack stack) {
        if (stack.hasTagCompound() && stack.getTagCompound().hasKey("arrows")) {
            return stack.getTagCompound().getShort("arrows");
        } else return 0;
    }

    @Override
    public void setArrowCount(ItemStack stack, int count) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        // Should never happen, you would need A LOT of arrows for this to happen
        if (count > Short.MAX_VALUE) {
            count = Short.MAX_VALUE;
        }
        stack.getTagCompound().setShort("arrows", (short) count);
    }

    @Override
    public boolean catchArrow(ItemStack shield, EntityPlayer player, IProjectile arrow) {
        if (arrow instanceof EntityArrow) {
            setArrowCount(shield, getArrowCount(shield) + 1);
            player.setArrowCountInEntity(player.getArrowCountInEntity() - 1);
            ((EntityArrow) arrow).setDead();
            return true;
        }
        return false;
    }

    @Override
    public boolean sheatheOnBack(ItemStack arg0) {
        return true;
    }

    @Override
    public void blockAnimation(EntityPlayer player, float dmg) {
        player.worldObj.playSoundAtEntity(player, "battlegear2:shield", 1, 1);
    }

    @Override
    public boolean canBlock(ItemStack shield, DamageSource source) {
        return !source.isUnblockable();
    }

    @Override
    public int getBashTimer(ItemStack arg0) {
        // TODO Auto-generated method stub
        return 10;
    }

    @Override
    public float getBlockAngle(ItemStack arg0) {
        // TODO Auto-generated method stub
        return 60;
    }

    @Override
    public float getDamageDecayRate(ItemStack shield, float amount) {
        return 0;
    }

    @Override
    public float getDamageReduction(ItemStack arg0, DamageSource arg1) {
        return 1f;
    }

    @Override
    public float getDecayRate(ItemStack stack) {
        NBTTagCompound tags = stack.getTagCompound();
        float recovery = tags.getCompoundTag("InfiTool").getInteger("MiningSpeed") / 1.5f;
        return 10f / recovery;
    }

    @Override
    public float getRecoveryRate(ItemStack stack) {
        NBTTagCompound tags = stack.getTagCompound();
        float recovery = tags.getCompoundTag("InfiTool").getInteger("MiningSpeed") / 1.5f;
        return 10f / recovery;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        NBTTagCompound tags = par1ItemStack.getTagCompound();
        super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add("");
        par3List.add(
                EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocalFormatted(
                        "attribute.shield.block.time",
                        ItemStack.field_111284_a.format(
                                1F / (10f / (tags.getCompoundTag("InfiTool").getInteger("MiningSpeed") / 1.5f))
                                        / 20F)));
        int arrowCount = getArrowCount(par1ItemStack);
        if (arrowCount > 0) {
            par3List.add(
                    EnumChatFormatting.GOLD
                            + StatCollector.translateToLocalFormatted("attribute.shield.arrow.count", arrowCount));
        }
    }

    @Override
    protected Material[] getEffectiveMaterials() {
        return materials;
    }

    static Material[] materials = new Material[] { Material.rock, Material.iron, Material.ice, Material.glass,
            Material.piston, Material.anvil, Material.circuits };

    @Override
    protected String getHarvestType() {
        // TODO Auto-generated method stub
        return "pickaxe";
    }
}
