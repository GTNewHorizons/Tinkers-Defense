// Date: 1/18/2015 9:46:49 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package lance5057.tDefense.core.blocks.crestMount;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrestMount extends ModelBase {

    // fields
    ModelRenderer ShieldMount;
    ModelRenderer Base;
    ModelRenderer SwordMount1;
    ModelRenderer SwordMount2;

    // ModelRenderer SwordMount3;

    public ModelCrestMount() {
        textureWidth = 32;
        textureHeight = 32;

        ShieldMount = new ModelRenderer(this, 20, 6);
        ShieldMount.addBox(0F, 0F, 0F, 2, 7, 2);
        ShieldMount.setRotationPoint(-1F, 17F, -1F);
        ShieldMount.setTextureSize(32, 32);
        ShieldMount.mirror = true;
        setRotation(ShieldMount, 0F, 0F, 0F);

        Base = new ModelRenderer(this, 0, 6);
        Base.addBox(0F, 0F, 0F, 4, 4, 4);
        Base.setRotationPoint(-2F, 20F, -2F);
        Base.setTextureSize(32, 32);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);

        SwordMount1 = new ModelRenderer(this, 0, 0);
        SwordMount1.addBox(-5F, 0F, -2F, 10, 2, 4);
        SwordMount1.setRotationPoint(0F, 22F, 0F);
        SwordMount1.setTextureSize(32, 32);
        SwordMount1.mirror = true;
        setRotation(SwordMount1, 0F, 0.7853982F, 0F);

        SwordMount2 = new ModelRenderer(this, 0, 0);
        SwordMount2.addBox(-5F, 0F, -2F, 10, 2, 4);
        SwordMount2.setRotationPoint(0F, 22F, 0F);
        SwordMount2.setTextureSize(32, 32);
        SwordMount2.mirror = true;
        setRotation(SwordMount2, 0F, -0.7853982F, 0F);

        // SwordMount3 = new ModelRenderer(this, 0, 0);
        // SwordMount3.addBox(-5F, 0F, -2F, 10, 2, 4);
        // SwordMount3.setRotationPoint(0F, 21.9F, 0F);
        // SwordMount3.setTextureSize(32, 32);
        // SwordMount3.mirror = true;
        // setRotation(SwordMount3, 0F, 1.570796F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean left,
            boolean right, boolean shield) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (shield) {
            ShieldMount.render(f5);
        }
        if (left) {
            SwordMount1.render(f5);
        }
        if (right) {
            SwordMount2.render(f5);
        }

        Base.render(f5);
        // SwordMount3.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
