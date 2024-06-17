package twilightforest.world.components.structures;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.StructurePiece;

public class StrongholdStairs extends StructurePiece.BlockSelector {

	@Override
	public void next(RandomSource random, int x, int y, int z, boolean wall) {
		if (!wall) {
			next = Blocks.AIR.defaultBlockState();
		} else {
			float f = random.nextFloat();

			if (f < 0.2F) {
				next = Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState();
			} else {
				next = Blocks.STONE_BRICK_STAIRS.defaultBlockState();
			}
		}
	}

}
