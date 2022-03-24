package com.Killer.killersblocksnstuff.common.Blocks;

import com.Killer.killersblocksnstuff.common.container.*;
import com.Killer.killersblocksnstuff.common.tileEntity.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.particles.*;
import net.minecraft.state.*;
import net.minecraft.state.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.network.*;

import javax.annotation.*;
import java.util.*;

public class VibraniumForgeBlock extends HorizontalBlock implements ITickableTileEntity {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;


    public VibraniumForgeBlock() {
        super(Properties.of(Material.METAL).strength(7.0F, -1.0F).sound(SoundType.STONE).harvestLevel(3).harvestTool(ToolType.PICKAXE).lightLevel((LIT)->15));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)));
    }


    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (!worldIn.isClientSide()) {
            TileEntity tileEntity = worldIn.getBlockEntity(pos);

            if (!player.isCrouching()) {
                if (tileEntity instanceof VibraniumForgeTile) {
                    INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);

                    NetworkHooks.openGui(((ServerPlayerEntity) player), containerProvider, tileEntity.getBlockPos());
                } else {
                    throw new IllegalStateException("Our Container provider is missing!");
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        return new INamedContainerProvider() {
            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new VibraniumForgeContainer(i, worldIn, pos, playerInventory, playerEntity, null);
            }

            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.killersblocksnstuff.vibranium_forge");
            }
        };
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return KbnsTileEntities.VIBRANIUM_FORGE_TILE.get().create();
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }


    @Override
    public void tick() {
    }


    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }


    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        if (state.getValue(LIT)){
            return 15;
        }
        return 0;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }


    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
        if (p_180655_1_.getValue(LIT)) {
            double d0 = (double)p_180655_3_.getX() + 0.5D;
            double d1 = (double)p_180655_3_.getY();
            double d2 = (double)p_180655_3_.getZ() + 0.5D;
            if (p_180655_4_.nextDouble() < 0.1D) {
                p_180655_2_.playLocalSound(d0, d1, d2, SoundEvents.BLASTFURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
                p_180655_2_.playLocalSound(d0, d1, d2, SoundEvents.ANVIL_USE, SoundCategory.BLOCKS, .01F, .01F, false);
            }

            Direction direction = p_180655_1_.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d3 = 0.52D;
            double d4 = p_180655_4_.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : d4;
            double d6 = p_180655_4_.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : d4;
            p_180655_2_.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            p_180655_2_.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
        }
    }
}



