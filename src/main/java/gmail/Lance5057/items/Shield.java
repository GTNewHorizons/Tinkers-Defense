package gmail.Lance5057.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import gmail.Lance5057.Reference;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.library.tools.ToolCore;

public abstract class Shield extends ToolCore {

    public Shield(int baseDamage) {
        super(baseDamage);
    }

    protected float baseSpeed() {
        return 1.5f;
    }

    protected float effectiveSpeed() {
        return 15f;
    }

    public float breakSpeedModifier() {
        return 1.0f;
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        if (stack.getTagCompound().getCompoundTag("InfiTool").getBoolean("Broken")) return 0.1f;
        for (int i = 0; i < web.length; i++) {
            if (web[i] == block.getMaterial()) {
                return effectiveSpeed();
            }
        }
        return baseSpeed();
    }

    private static ResourceLocation blockSound;

    public ResourceLocation getBlockSound() {
        if (blockSound == null) {
            blockSound = new ResourceLocation(Reference.MOD_ID, "shield");
        }

        return blockSound;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        return stack;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
            float clickX, float clickY, float clickZ) {
        return false;
    }

    /* tool_TinkerShield specific */
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (AbilityHelper.onLeftClickEntity(stack, player, entity, this)) {
            entity.hurtResistantTime += 7;
        }
        return true;
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    @Override
    public boolean canHarvestBlock(Block block, ItemStack is) {
        for (int i = 0; i < web.length; i++) {
            if (block.getMaterial() == web[i]) return true;
        }
        return super.canHarvestBlock(block, is);
    }

    protected Material[] getEffectiveMaterials() {
        return web;
    }

    // @Override
    // @SideOnly(Side.CLIENT)
    // public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
    // super.onUpdate(stack, world, entity, par4, par5);
    // if (entity instanceof EntityPlayerSP) {
    // EntityPlayerSP player = (EntityPlayerSP) entity;
    // ItemStack usingItem = player.getItemInUse();
    // if (usingItem != null && usingItem.getItem() == this) {
    // player.movementInput.moveForward *= 2.5F;
    // player.movementInput.moveStrafe *= 2.5F;
    // }
    // }
    // }

    @Override
    public String[] getTraits() {
        return new String[] { "Shield", "melee" };
    }

    public static Material[] web = new Material[] { Material.web, Material.cloth, Material.coral, Material.cake };
    public static Material[] none = new Material[0];

    protected String getHarvestType() {
        // TODO Auto-generated method stub
        return null;
    }
}
