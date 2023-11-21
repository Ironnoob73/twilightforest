package twilightforest.world.components.structures.courtyard;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import twilightforest.TwilightForestMod;
import twilightforest.init.TFStructurePieceTypes;

public class NagaCourtyardHedgeCornerComponent extends NagaCourtyardHedgeAbstractComponent {
    public NagaCourtyardHedgeCornerComponent(StructurePieceSerializationContext ctx, CompoundTag nbt) {
        super(ctx, TFStructurePieceTypes.TFNCCr.value(), nbt, new ResourceLocation(TwilightForestMod.ID, "courtyard/hedge_corner"), new ResourceLocation(TwilightForestMod.ID, "courtyard/hedge_corner_big"));
    }

    public NagaCourtyardHedgeCornerComponent(StructureTemplateManager manager, int i, int x, int y, int z, Rotation rotation) {
        super(manager, TFStructurePieceTypes.TFNCCr.value(), i, x, y, z, rotation, new ResourceLocation(TwilightForestMod.ID, "courtyard/hedge_corner"), new ResourceLocation(TwilightForestMod.ID, "courtyard/hedge_corner_big"));
    }
}
