package io.purplik.explorersgear.client.entity.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class BackpackModel<T extends LivingEntity> extends HumanoidModel<T> {
    public ModelPart backpack;

    public BackpackModel(ModelPart part) {
        super(part);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", new CubeListBuilder(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("right_arm", new CubeListBuilder(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left_arm", new CubeListBuilder(), PartPose.ZERO);

        PartDefinition backpack = body.addOrReplaceChild("backpack", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.005F, -2.5F, 8.0F, 12.01F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 25).addBox(4.0F, -4.005F, -1.5F, 3.0F, 8.01F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.975F, 5.0F));
        PartDefinition sleepingroll = backpack.addOrReplaceChild("backpack_sleepingroll", CubeListBuilder.create().texOffs(0, 17).addBox(-5.0F, -2.005F, -2.5F, 10.0F, 4.01F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.5F, -0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 48, 48);
    }
}