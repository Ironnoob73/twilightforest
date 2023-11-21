package twilightforest.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import twilightforest.TwilightForestMod;
import twilightforest.entity.*;
import twilightforest.entity.boss.*;
import twilightforest.entity.monster.*;
import twilightforest.entity.passive.*;
import twilightforest.entity.projectile.*;

@Mod.EventBusSubscriber(modid = TwilightForestMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TFEntities {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, TwilightForestMod.ID);
	public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(Registries.ITEM, TwilightForestMod.ID);

	public static final DeferredHolder<EntityType<?>, EntityType<Adherent>> ADHERENT = make(TFEntityNames.ADHERENT, Adherent::new, MobCategory.MONSTER, 0.8F, 2.2F, 0x0a0000, 0x00008b);
	public static final DeferredHolder<EntityType<?>, EntityType<AlphaYeti>> ALPHA_YETI = make(TFEntityNames.ALPHA_YETI, AlphaYeti::new, MobCategory.MONSTER, 3.8F, 5.0F, 0xcdcdcd, 0x29486e);
	public static final DeferredHolder<EntityType<?>, EntityType<ArmoredGiant>> ARMORED_GIANT = make(TFEntityNames.ARMORED_GIANT, ArmoredGiant::new, MobCategory.MONSTER, 2.4F, 7.2F, 0x239391, 0x9a9a9a);
	public static final DeferredHolder<EntityType<?>, EntityType<Bighorn>> BIGHORN_SHEEP = make(TFEntityNames.BIGHORN_SHEEP, Bighorn::new, MobCategory.CREATURE, 0.9F, 1.3F, 0xdbceaf, 0xd7c771);
	public static final DeferredHolder<EntityType<?>, EntityType<BlockChainGoblin>> BLOCKCHAIN_GOBLIN = make(TFEntityNames.BLOCKCHAIN_GOBLIN, BlockChainGoblin::new, MobCategory.MONSTER, 0.9F, 1.4F, 0xd3e7bc, 0x1f3fff);
	public static final DeferredHolder<EntityType<?>, EntityType<Boar>> BOAR = make(TFEntityNames.BOAR, Boar::new, MobCategory.CREATURE, 0.9F, 0.9F, 0x83653b, 0xffefca);
	public static final DeferredHolder<EntityType<?>, EntityType<TwilightBoat>> BOAT = buildNoEgg(TFEntityNames.BOAT, makeCastedBuilder(TwilightBoat.class, TwilightBoat::new, 1.375F, 0.5625F, 10, 3), false);
	//public static final DeferredHolder<EntityType<?>, EntityType<Boggard>> BOGGARD = make(TFEntityNames.BOGGARD, Boggard::new, MobCategory.MONSTER, 0.8F, 1.1F);
	public static final DeferredHolder<EntityType<?>, EntityType<TowerBroodling>> CARMINITE_BROODLING = make(TFEntityNames.CARMINITE_BROODLING, TowerBroodling::new, MobCategory.MONSTER, 0.7F, 0.5F, 0x343c14, 0xbaee02);
	public static final DeferredHolder<EntityType<?>, EntityType<CarminiteGhastguard>> CARMINITE_GHASTGUARD = make(TFEntityNames.CARMINITE_GHASTGUARD, CarminiteGhastguard::new, MobCategory.MONSTER, 4.0F, 6.0F, 0xbcbcbc, 0xb77878);
	public static final DeferredHolder<EntityType<?>, EntityType<CarminiteGhastling>> CARMINITE_GHASTLING = make(TFEntityNames.CARMINITE_GHASTLING, CarminiteGhastling::new, MobCategory.MONSTER, 1.1F, 1.5F, 0xbcbcbc, 0xa74343);
	public static final DeferredHolder<EntityType<?>, EntityType<CarminiteGolem>> CARMINITE_GOLEM = make(TFEntityNames.CARMINITE_GOLEM, CarminiteGolem::new, MobCategory.MONSTER, 1.4F, 2.9F, 0x6b3d20, 0xe2ddda);
	public static final DeferredHolder<EntityType<?>, EntityType<ChainBlock>> CHAIN_BLOCK = buildNoEgg(TFEntityNames.CHAIN_BLOCK, makeCastedBuilder(ChainBlock.class, ChainBlock::new, 0.6F, 0.6F, 80, 1), true);
	public static final DeferredHolder<EntityType<?>, EntityType<CharmEffect>> CHARM_EFFECT = make(TFEntityNames.CHARM_EFFECT, CharmEffect::new, MobCategory.MISC, 0.25F, 0.25F, 0, 0);
	public static final DeferredHolder<EntityType<?>, EntityType<TwilightChestBoat>> CHEST_BOAT = buildNoEgg(TFEntityNames.CHEST_BOAT, makeCastedBuilder(TwilightChestBoat.class, TwilightChestBoat::new, 1.375F, 0.5625F, 10, 3), false);
	public static final DeferredHolder<EntityType<?>, EntityType<CubeOfAnnihilation>> CUBE_OF_ANNIHILATION = buildNoEgg(TFEntityNames.CUBE_OF_ANNIHILATION, makeCastedBuilder(CubeOfAnnihilation.class, CubeOfAnnihilation::new, 1.0F, 1.0F, 80, 1), true);
	public static final DeferredHolder<EntityType<?>, EntityType<DeathTome>> DEATH_TOME = make(TFEntityNames.DEATH_TOME, DeathTome::new, MobCategory.MONSTER, 0.6F, 1.1F, 0x774e22, 0xdbcdbe);
	public static final DeferredHolder<EntityType<?>, EntityType<Deer>> DEER = make(TFEntityNames.DEER, Deer::new, MobCategory.CREATURE, 0.7F, 1.8F, 0x7b4d2e, 0x4b241d);
	public static final DeferredHolder<EntityType<?>, EntityType<DwarfRabbit>> DWARF_RABBIT = make(TFEntityNames.DWARF_RABBIT, DwarfRabbit::new, MobCategory.CREATURE, 0.4F, 0.4F, 0xfefeee, 0xccaa99);
	public static final DeferredHolder<EntityType<?>, EntityType<FallingIce>> FALLING_ICE = make(TFEntityNames.FALLING_ICE, FallingIce::new, MobCategory.MISC, 1.0F, 1.0F, true, 0, 0);
	public static final DeferredHolder<EntityType<?>, EntityType<FireBeetle>> FIRE_BEETLE = make(TFEntityNames.FIRE_BEETLE, FireBeetle::new, MobCategory.MONSTER, 1.1F, 0.5F, true, 0x1d0b00, 0xcb6f25);
	public static final DeferredHolder<EntityType<?>, EntityType<GiantMiner>> GIANT_MINER = make(TFEntityNames.GIANT_MINER, GiantMiner::new, MobCategory.MONSTER, 2.4F, 7.2F, 0x211b52, 0x9a9a9a);
	public static final DeferredHolder<EntityType<?>, EntityType<HarbingerCube>> HARBINGER_CUBE = make(TFEntityNames.HARBINGER_CUBE, HarbingerCube::new, MobCategory.MONSTER, 1.9F, 2.4F, true, 0x00000a, 0x8b0000);
	public static final DeferredHolder<EntityType<?>, EntityType<HedgeSpider>> HEDGE_SPIDER = make(TFEntityNames.HEDGE_SPIDER, HedgeSpider::new, MobCategory.MONSTER, 1.4F, 0.9F, 0x235f13, 0x562653);
	public static final DeferredHolder<EntityType<?>, EntityType<HelmetCrab>> HELMET_CRAB = make(TFEntityNames.HELMET_CRAB, HelmetCrab::new, MobCategory.MONSTER, 0.8F, 1.1F, 0xfb904b, 0xd3e7bc);
	public static final DeferredHolder<EntityType<?>, EntityType<HostileWolf>> HOSTILE_WOLF = make(TFEntityNames.HOSTILE_WOLF, HostileWolf::new, MobCategory.MONSTER, 0.6F, 0.85F, 0xd7d3d3, 0xab1e14);
	public static final DeferredHolder<EntityType<?>, EntityType<Hydra>> HYDRA = make(TFEntityNames.HYDRA, Hydra::new, MobCategory.MONSTER, 16.0F, 12.0F, true, 0x142940, 0x29806b);
	public static final DeferredHolder<EntityType<?>, EntityType<HydraMortar>> HYDRA_MORTAR = buildNoEgg(TFEntityNames.HYDRA_MORTAR, makeCastedBuilder(HydraMortar.class, HydraMortar::new, 0.75F, 0.75F, 150, 3), true);
	public static final DeferredHolder<EntityType<?>, EntityType<IceArrow>> ICE_ARROW = buildNoEgg(TFEntityNames.ICE_ARROW, makeCastedBuilder(IceArrow.class, IceArrow::new, 0.5F, 0.5F, 150, 1), false);
	public static final DeferredHolder<EntityType<?>, EntityType<IceBomb>> THROWN_ICE = buildNoEgg(TFEntityNames.THROWN_ICE, makeCastedBuilder(IceBomb.class, IceBomb::new, 1.0F, 1.0F, 80, 2), true);
	public static final DeferredHolder<EntityType<?>, EntityType<IceCrystal>> ICE_CRYSTAL = make(TFEntityNames.ICE_CRYSTAL, IceCrystal::new, MobCategory.MONSTER, 0.6F, 1.8F, 0xdce9fe, 0xadcafb);
	public static final DeferredHolder<EntityType<?>, EntityType<IceSnowball>> ICE_SNOWBALL = buildNoEgg(TFEntityNames.ICE_SNOWBALL, makeCastedBuilder(IceSnowball.class, IceSnowball::new, 0.25F, 0.25F, 150, 3), false);
	public static final DeferredHolder<EntityType<?>, EntityType<KingSpider>> KING_SPIDER = make(TFEntityNames.KING_SPIDER, KingSpider::new, MobCategory.MONSTER, 1.6F, 1.6F, 0x2c1a0e, 0xffc017);
	public static final DeferredHolder<EntityType<?>, EntityType<KnightPhantom>> KNIGHT_PHANTOM = make(TFEntityNames.KNIGHT_PHANTOM, KnightPhantom::new, MobCategory.MONSTER, 1.25F, 2.5F, 0xa6673b, 0xd3e7bc);
	public static final DeferredHolder<EntityType<?>, EntityType<Kobold>> KOBOLD = make(TFEntityNames.KOBOLD, Kobold::new, MobCategory.MONSTER, 0.8F, 1.1F, 0x372096, 0x895d1b);
	public static final DeferredHolder<EntityType<?>, EntityType<Lich>> LICH = make(TFEntityNames.LICH, Lich::new, MobCategory.MONSTER, 1.1F, 2.1F, 0xaca489, 0x360472);
	public static final DeferredHolder<EntityType<?>, EntityType<LichBolt>> LICH_BOLT = buildNoEgg(TFEntityNames.LICH_BOLT, makeCastedBuilder(LichBolt.class, LichBolt::new, 0.25F, 0.25F, 150, 2), false);
	public static final DeferredHolder<EntityType<?>, EntityType<LichBomb>> LICH_BOMB = buildNoEgg(TFEntityNames.LICH_BOMB, makeCastedBuilder(LichBomb.class, LichBomb::new, 0.25F, 0.25F, 150, 3), false);
	public static final DeferredHolder<EntityType<?>, EntityType<LichMinion>> LICH_MINION = make(TFEntityNames.LICH_MINION, LichMinion::new, MobCategory.MONSTER, 0.6F, 1.95F, 0, 0);
	public static final DeferredHolder<EntityType<?>, EntityType<LowerGoblinKnight>> LOWER_GOBLIN_KNIGHT = make(TFEntityNames.LOWER_GOBLIN_KNIGHT, LowerGoblinKnight::new, MobCategory.MONSTER, 0.7F, 1.1F, 0x566055, 0xd3e7bc);
	public static final DeferredHolder<EntityType<?>, EntityType<LoyalZombie>> LOYAL_ZOMBIE = make(TFEntityNames.LOYAL_ZOMBIE, LoyalZombie::new, MobCategory.MONSTER, 0.6F, 1.8F, 0, 0);
	public static final DeferredHolder<EntityType<?>, EntityType<MazeSlime>> MAZE_SLIME = make(TFEntityNames.MAZE_SLIME, MazeSlime::new, MobCategory.MONSTER, 2.04F, 2.04F, 0xa3a3a3, 0x2a3b17);
	public static final DeferredHolder<EntityType<?>, EntityType<Minoshroom>> MINOSHROOM = make(TFEntityNames.MINOSHROOM, Minoshroom::new, MobCategory.MONSTER, 1.49F, 2.5F, 0xa81012, 0xaa7d66);
	public static final DeferredHolder<EntityType<?>, EntityType<Minotaur>> MINOTAUR = make(TFEntityNames.MINOTAUR, Minotaur::new, MobCategory.MONSTER, 0.6F, 2.1F, 0x3f3024, 0xaa7d66);
	public static final DeferredHolder<EntityType<?>, EntityType<MistWolf>> MIST_WOLF = make(TFEntityNames.MIST_WOLF, MistWolf::new, MobCategory.MONSTER, 1.4F, 1.9F, 0x3a1411, 0xe2c88a);
	public static final DeferredHolder<EntityType<?>, EntityType<MoonwormShot>> MOONWORM_SHOT = buildNoEgg(TFEntityNames.MOONWORM_SHOT, makeCastedBuilder(MoonwormShot.class, MoonwormShot::new, 0.25F, 0.25F, 150, 3), false);
	public static final DeferredHolder<EntityType<?>, EntityType<MosquitoSwarm>> MOSQUITO_SWARM = make(TFEntityNames.MOSQUITO_SWARM, MosquitoSwarm::new, MobCategory.MONSTER, 0.7F, 1.9F, 0x080904, 0x2d2f21);
	public static final DeferredHolder<EntityType<?>, EntityType<Naga>> NAGA = make(TFEntityNames.NAGA, Naga::new, MobCategory.MONSTER, 2.0F, 3.0F, true, 0xa4d316, 0x1b380b);
	public static final DeferredHolder<EntityType<?>, EntityType<NatureBolt>> NATURE_BOLT = buildNoEgg(TFEntityNames.NATURE_BOLT, makeCastedBuilder(NatureBolt.class, NatureBolt::new, 0.25F, 0.25F, 150, 5), false);
	public static final DeferredHolder<EntityType<?>, EntityType<MagicPainting>> MAGIC_PAINTING = buildNoEgg(TFEntityNames.MAGIC_PAINTING, makeCastedBuilder(MagicPainting.class, MagicPainting::new, 0.5F, 0.5F, 10, Integer.MAX_VALUE), false);
	public static final DeferredHolder<EntityType<?>, EntityType<Penguin>> PENGUIN = make(TFEntityNames.PENGUIN, Penguin::new, MobCategory.CREATURE, 0.5F, 0.9F, 0x12151b, 0xf9edd2);
	public static final DeferredHolder<EntityType<?>, EntityType<PinchBeetle>> PINCH_BEETLE = make(TFEntityNames.PINCH_BEETLE, PinchBeetle::new, MobCategory.MONSTER, 1.2F, 0.5F, 0xbc9327, 0x241609);
	public static final DeferredHolder<EntityType<?>, EntityType<PlateauBoss>> PLATEAU_BOSS = make(TFEntityNames.PLATEAU_BOSS, PlateauBoss::new, MobCategory.MONSTER, 1F, 1F, true, 0, 0);
	public static final DeferredHolder<EntityType<?>, EntityType<ProtectionBox>> PROTECTION_BOX = buildNoEgg(TFEntityNames.PROTECTION_BOX, makeCastedBuilder(ProtectionBox.class, ProtectionBox::new, 0, 0, 80, 3).noSave().noSummon(), true);
	public static final DeferredHolder<EntityType<?>, EntityType<QuestRam>> QUEST_RAM = make(TFEntityNames.QUEST_RAM, QuestRam::new, MobCategory.CREATURE, 1.25F, 2.9F, 0xfefeee, 0x33aadd);
	public static final DeferredHolder<EntityType<?>, EntityType<Raven>> RAVEN = make(TFEntityNames.RAVEN, Raven::new, MobCategory.CREATURE, 0.3F, 0.5F, 0x000011, 0x222233);
	public static final DeferredHolder<EntityType<?>, EntityType<Redcap>> REDCAP = make(TFEntityNames.REDCAP, Redcap::new, MobCategory.MONSTER, 0.9F, 1.4F, 0x3b3a6c, 0xab1e14);
	public static final DeferredHolder<EntityType<?>, EntityType<RedcapSapper>> REDCAP_SAPPER = make(TFEntityNames.REDCAP_SAPPER, RedcapSapper::new, MobCategory.MONSTER, 0.9F, 1.4F, 0x575d21, 0xab1e14);
	public static final DeferredHolder<EntityType<?>, EntityType<RisingZombie>> RISING_ZOMBIE = make(TFEntityNames.RISING_ZOMBIE, RisingZombie::new, MobCategory.MONSTER, 0.6F, 1.95F, 0, 0);
	public static final DeferredHolder<EntityType<?>, EntityType<RovingCube>> ROVING_CUBE = make(TFEntityNames.ROVING_CUBE, RovingCube::new, MobCategory.MONSTER, 1.2F, 2.1F, 0, 0);
	public static final DeferredHolder<EntityType<?>, EntityType<SeekerArrow>> SEEKER_ARROW = buildNoEgg(TFEntityNames.SEEKER_ARROW, makeCastedBuilder(SeekerArrow.class, SeekerArrow::new, 0.5F, 0.5F, 150, 1), false);
	public static final DeferredHolder<EntityType<?>, EntityType<SkeletonDruid>> SKELETON_DRUID = make(TFEntityNames.SKELETON_DRUID, SkeletonDruid::new, MobCategory.MONSTER, 0.6F, 1.99F, 0xa3a3a3, 0x2a3b17);
	public static final DeferredHolder<EntityType<?>, EntityType<SlideBlock>> SLIDER = buildNoEgg(TFEntityNames.SLIDER, makeCastedBuilder(SlideBlock.class, SlideBlock::new, 0.98F, 0.98F, 80, 1), false);
	public static final DeferredHolder<EntityType<?>, EntityType<SlimeBeetle>> SLIME_BEETLE = make(TFEntityNames.SLIME_BEETLE, SlimeBeetle::new, MobCategory.MONSTER, 0.9F, 0.5F, 0x0c1606, 0x60a74c);
	public static final DeferredHolder<EntityType<?>, EntityType<SlimeProjectile>> SLIME_BLOB = buildNoEgg(TFEntityNames.SLIME_BLOB, makeCastedBuilder(SlimeProjectile.class, SlimeProjectile::new, 0.25F, 0.25F, 150, 3), false);
	public static final DeferredHolder<EntityType<?>, EntityType<SnowGuardian>> SNOW_GUARDIAN = make(TFEntityNames.SNOW_GUARDIAN, SnowGuardian::new, MobCategory.MONSTER, 0.6F, 1.8F, 0xd3e7bc, 0xfefefe);
	public static final DeferredHolder<EntityType<?>, EntityType<SnowQueen>> SNOW_QUEEN = make(TFEntityNames.SNOW_QUEEN, SnowQueen::new, MobCategory.MONSTER, 0.7F, 2.2F, 0xb1b2d4, 0x87006e);
	public static final DeferredHolder<EntityType<?>, EntityType<Squirrel>> SQUIRREL = make(TFEntityNames.SQUIRREL, Squirrel::new, MobCategory.CREATURE, 0.3F, 0.5F, 0x904f12, 0xeeeeee);
	public static final DeferredHolder<EntityType<?>, EntityType<StableIceCore>> STABLE_ICE_CORE = make(TFEntityNames.STABLE_ICE_CORE, StableIceCore::new, MobCategory.MONSTER, 0.8F, 1.8F, 0xa1bff3, 0x7000f8);
	public static final DeferredHolder<EntityType<?>, EntityType<SwarmSpider>> SWARM_SPIDER = make(TFEntityNames.SWARM_SPIDER, SwarmSpider::new, MobCategory.MONSTER, 0.8F, 0.4F, 0x32022e, 0x17251e);
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownBlock>> THROWN_BLOCK = buildNoEgg(TFEntityNames.THROWN_BLOCK, makeCastedBuilder(ThrownBlock.class, ThrownBlock::new, 1.0F, 1.0F, 80, 2), true);
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownWep>> THROWN_WEP = make(TFEntityNames.THROWN_WEP, ThrownWep::new, MobCategory.MISC, 0.5F, 0.5F, 0, 0);
	public static final DeferredHolder<EntityType<?>, EntityType<TinyBird>> TINY_BIRD = make(TFEntityNames.TINY_BIRD, TinyBird::new, MobCategory.CREATURE, 0.3F, 0.3F, 0x33aadd, 0x1188ee);
	public static final DeferredHolder<EntityType<?>, EntityType<TomeBolt>> TOME_BOLT = buildNoEgg(TFEntityNames.TOME_BOLT, makeCastedBuilder(TomeBolt.class, TomeBolt::new, 0.25F, 0.25F, 150, 5), false);
	public static final DeferredHolder<EntityType<?>, EntityType<TowerwoodBorer>> TOWERWOOD_BORER = make(TFEntityNames.TOWERWOOD_BORER, TowerwoodBorer::new, MobCategory.MONSTER, 0.4F, 0.3F, 0x5d2b21, 0xaca03a);
	public static final DeferredHolder<EntityType<?>, EntityType<Troll>> TROLL = make(TFEntityNames.TROLL, Troll::new, MobCategory.MONSTER, 1.4F, 2.4F, 0x9ea98f, 0xb0948e);
	public static final DeferredHolder<EntityType<?>, EntityType<TwilightWandBolt>> WAND_BOLT = buildNoEgg(TFEntityNames.WAND_BOLT, makeCastedBuilder(TwilightWandBolt.class, TwilightWandBolt::new, 0.25F, 0.25F, 150, 5), false);
	public static final DeferredHolder<EntityType<?>, EntityType<UnstableIceCore>> UNSTABLE_ICE_CORE = make(TFEntityNames.UNSTABLE_ICE_CORE, UnstableIceCore::new, MobCategory.MONSTER, 0.8F, 1.8F, 0x9aacf5, 0x9b0fa5);
	public static final DeferredHolder<EntityType<?>, EntityType<UpperGoblinKnight>> UPPER_GOBLIN_KNIGHT = make(TFEntityNames.UPPER_GOBLIN_KNIGHT, UpperGoblinKnight::new, MobCategory.MONSTER, 1.1F, 1.3F, 0, 0);
	public static final DeferredHolder<EntityType<?>, EntityType<UrGhast>> UR_GHAST = make(TFEntityNames.UR_GHAST, UrGhast::new, MobCategory.MONSTER, 14.0F, 18.0F, true, 0xbcbcbc, 0xb77878);
	public static final DeferredHolder<EntityType<?>, EntityType<WinterWolf>> WINTER_WOLF = make(TFEntityNames.WINTER_WOLF, WinterWolf::new, MobCategory.MONSTER, 1.4F, 1.9F, 0xdfe3e5, 0xb2bcca);
	public static final DeferredHolder<EntityType<?>, EntityType<Wraith>> WRAITH = make(TFEntityNames.WRAITH, Wraith::new, MobCategory.MONSTER, 0.6F, 1.8F, true, 0x505050, 0x838383);
	public static final DeferredHolder<EntityType<?>, EntityType<Yeti>> YETI = make(TFEntityNames.YETI, Yeti::new, MobCategory.MONSTER, 1.4F, 2.4F, 0xdedede, 0x4675bb);

	private static <E extends Entity> DeferredHolder<EntityType<?>, EntityType<E>> make(ResourceLocation id, EntityType.EntityFactory<E> factory, MobCategory classification, float width, float height, int primary, int secondary) {
		return make(id, factory, classification, width, height, false, primary, secondary);
	}

	private static <E extends Entity> DeferredHolder<EntityType<?>, EntityType<E>> make(ResourceLocation id, EntityType.EntityFactory<E> factory, MobCategory classification, float width, float height, boolean fireproof, int primary, int secondary) {
		return build(id, makeBuilder(factory, classification, width, height, 80, 3), fireproof, primary, secondary);
	}

	private static <E extends Entity> DeferredHolder<EntityType<?>, EntityType<E>> buildNoEgg(ResourceLocation id, EntityType.Builder<E> builder, boolean fireproof) {
		if (fireproof) builder.fireImmune();
		return ENTITIES.register(id.getPath(), () -> builder.build(id.toString()));
	}

	@SuppressWarnings("unchecked")
	private static <E extends Entity> DeferredHolder<EntityType<?>, EntityType<E>> build(ResourceLocation id, EntityType.Builder<E> builder, boolean fireproof, int primary, int secondary) {
		if (fireproof) builder.fireImmune();
		DeferredHolder<EntityType<?>, EntityType<E>> ret = ENTITIES.register(id.getPath(), () -> builder.build(id.toString()));
		if (primary != 0 && secondary != 0) {
			SPAWN_EGGS.register(id.getPath() + "_spawn_egg", () -> new DeferredSpawnEggItem(() -> (EntityType<? extends Mob>) ret.value(), primary, secondary, new Item.Properties()));
		}
		return ret;
	}

	private static <E extends Entity> EntityType.Builder<E> makeCastedBuilder(@SuppressWarnings("unused") Class<E> cast, EntityType.EntityFactory<E> factory, float width, float height, int range, int interval) {
		return makeBuilder(factory, MobCategory.MISC, width, height, range, interval);
	}

	private static <E extends Entity> EntityType.Builder<E> makeBuilder(EntityType.EntityFactory<E> factory, MobCategory classification, float width, float height, int range, int interval) {
		return EntityType.Builder.of(factory, classification).
				sized(width, height).
				setTrackingRange(range).
				setUpdateInterval(interval).
				setShouldReceiveVelocityUpdates(true);
	}

	@SubscribeEvent
	public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
		event.register(BOAR.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(BIGHORN_SHEEP.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(DEER.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(REDCAP.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(SKELETON_DRUID.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SkeletonDruid::checkDruidSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(WRAITH.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Wraith::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(HOSTILE_WOLF.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HostileWolf::checkWolfSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(HYDRA.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(LICH.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(PENGUIN.value(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Penguin::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(LICH_MINION.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(LOYAL_ZOMBIE.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(TINY_BIRD.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(SQUIRREL.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(DWARF_RABBIT.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(RAVEN.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(QUEST_RAM.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(KOBOLD.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(MOSQUITO_SWARM.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(DEATH_TOME.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(MINOTAUR.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(MINOSHROOM.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(FIRE_BEETLE.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(SLIME_BEETLE.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(PINCH_BEETLE.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(MIST_WOLF.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(CARMINITE_GHASTLING.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CarminiteGhastling::canSpawnHere, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(CARMINITE_GOLEM.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(TOWERWOOD_BORER.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(CARMINITE_GHASTGUARD.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CarminiteGhastguard::ghastSpawnHandler, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(UR_GHAST.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CarminiteGhastguard::ghastSpawnHandler, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(BLOCKCHAIN_GOBLIN.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(UPPER_GOBLIN_KNIGHT.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(LOWER_GOBLIN_KNIGHT.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(HELMET_CRAB.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(KNIGHT_PHANTOM.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(NAGA.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(SWARM_SPIDER.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SwarmSpider::getCanSpawnHere, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(KING_SPIDER.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(CARMINITE_BROODLING.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(HEDGE_SPIDER.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HedgeSpider::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(REDCAP_SAPPER.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(MAZE_SLIME.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MazeSlime::getCanSpawnHere, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(YETI.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Yeti::yetiSnowyForestSpawnHandler, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(ALPHA_YETI.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(WINTER_WOLF.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WinterWolf::canSpawnHere, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(SNOW_GUARDIAN.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(STABLE_ICE_CORE.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(UNSTABLE_ICE_CORE.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(SNOW_QUEEN.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(TROLL.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(GIANT_MINER.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GiantMiner::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(ARMORED_GIANT.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GiantMiner::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(ICE_CRYSTAL.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(HARBINGER_CUBE.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(ADHERENT.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(ROVING_CUBE.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(RISING_ZOMBIE.value(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
	}

	@SubscribeEvent
	public static void addEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(BOAR.value(), Boar.registerAttributes().build());
		event.put(BIGHORN_SHEEP.value(), Sheep.createAttributes().build());
		event.put(DEER.value(), Deer.registerAttributes().build());
		event.put(REDCAP.value(), Redcap.registerAttributes().build());
		event.put(SWARM_SPIDER.value(), SwarmSpider.registerAttributes().build());
		event.put(NAGA.value(), Naga.registerAttributes().build());
		event.put(SKELETON_DRUID.value(), AbstractSkeleton.createAttributes().build());
		event.put(HOSTILE_WOLF.value(), HostileWolf.registerAttributes().build());
		event.put(WRAITH.value(), Wraith.registerAttributes().build());
		event.put(HEDGE_SPIDER.value(), Spider.createAttributes().build());
		event.put(HYDRA.value(), Hydra.registerAttributes().build());
		event.put(LICH.value(), Lich.registerAttributes().build());
		event.put(PENGUIN.value(), Penguin.registerAttributes().build());
		event.put(LICH_MINION.value(), Zombie.createAttributes().build());
		event.put(LOYAL_ZOMBIE.value(), LoyalZombie.registerAttributes().build());
		event.put(TINY_BIRD.value(), TinyBird.registerAttributes().build());
		event.put(SQUIRREL.value(), Squirrel.registerAttributes().build());
		event.put(DWARF_RABBIT.value(), DwarfRabbit.registerAttributes().build());
		event.put(RAVEN.value(), Raven.registerAttributes().build());
		event.put(QUEST_RAM.value(), QuestRam.registerAttributes().build());
		event.put(KOBOLD.value(), Kobold.registerAttributes().build());
		event.put(MOSQUITO_SWARM.value(), MosquitoSwarm.registerAttributes().build());
		event.put(DEATH_TOME.value(), DeathTome.registerAttributes().build());
		event.put(MINOTAUR.value(), Minotaur.registerAttributes().build());
		event.put(MINOSHROOM.value(), Minoshroom.registerAttributes().build());
		event.put(FIRE_BEETLE.value(), FireBeetle.registerAttributes().build());
		event.put(SLIME_BEETLE.value(), SlimeBeetle.registerAttributes().build());
		event.put(PINCH_BEETLE.value(), PinchBeetle.registerAttributes().build());
		event.put(MAZE_SLIME.value(), MazeSlime.registerAttributes().build());
		event.put(REDCAP_SAPPER.value(), RedcapSapper.registerAttributes().build());
		event.put(MIST_WOLF.value(), MistWolf.registerAttributes().build());
		event.put(KING_SPIDER.value(), KingSpider.registerAttributes().build());
		event.put(CARMINITE_GHASTLING.value(), CarminiteGhastling.registerAttributes().build());
		event.put(CARMINITE_GHASTGUARD.value(), CarminiteGhastguard.registerAttributes().build());
		event.put(CARMINITE_GOLEM.value(), CarminiteGolem.registerAttributes().build());
		event.put(TOWERWOOD_BORER.value(), TowerwoodBorer.registerAttributes().build());
		event.put(CARMINITE_BROODLING.value(), TowerBroodling.registerAttributes().build());
		event.put(UR_GHAST.value(), UrGhast.registerAttributes().build());
		event.put(BLOCKCHAIN_GOBLIN.value(), BlockChainGoblin.registerAttributes().build());
		event.put(UPPER_GOBLIN_KNIGHT.value(), UpperGoblinKnight.registerAttributes().build());
		event.put(LOWER_GOBLIN_KNIGHT.value(), LowerGoblinKnight.registerAttributes().build());
		event.put(HELMET_CRAB.value(), HelmetCrab.registerAttributes().build());
		event.put(KNIGHT_PHANTOM.value(), KnightPhantom.registerAttributes().build());
		event.put(YETI.value(), Yeti.registerAttributes().build());
		event.put(ALPHA_YETI.value(), AlphaYeti.registerAttributes().build());
		event.put(WINTER_WOLF.value(), WinterWolf.registerAttributes().build());
		event.put(SNOW_GUARDIAN.value(), SnowGuardian.registerAttributes().build());
		event.put(STABLE_ICE_CORE.value(), StableIceCore.registerAttributes().build());
		event.put(UNSTABLE_ICE_CORE.value(), UnstableIceCore.registerAttributes().build());
		event.put(SNOW_QUEEN.value(), SnowQueen.registerAttributes().build());
		event.put(TROLL.value(), Troll.registerAttributes().build());
		event.put(GIANT_MINER.value(), GiantMiner.registerAttributes().build());
		event.put(ARMORED_GIANT.value(), GiantMiner.registerAttributes().build());
		event.put(ICE_CRYSTAL.value(), IceCrystal.registerAttributes().build());
		event.put(HARBINGER_CUBE.value(), HarbingerCube.registerAttributes().build());
		event.put(ADHERENT.value(), Adherent.registerAttributes().build());
		event.put(ROVING_CUBE.value(), RovingCube.registerAttributes().build());
		event.put(PLATEAU_BOSS.value(), PlateauBoss.registerAttributes().build());

		//event.put(BOGGARD.value(), Boggard.registerAttributes().create());
		event.put(RISING_ZOMBIE.value(), Zombie.createAttributes().build());
	}
}
