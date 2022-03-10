package com.Killer.killersblocksnstuff.common.Blocks;

import com.Killer.killersblocksnstuff.common.tileEntity.*;
import com.Killer.killersblocksnstuff.container.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.network.*;

import javax.annotation.*;

public class VibraniumForgeBlock extends Block implements ITickableTileEntity {
    public VibraniumForgeBlock() {
        super(Properties.of(Material.METAL).strength(7.0F, -1.0F).sound(SoundType.STONE).harvestLevel(3).harvestTool(ToolType.PICKAXE));
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
                return new VibraniumForgeContainer(i, worldIn, pos, playerInventory, playerEntity);
            }

            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.killersblocksnstuff.vibranium_forge");
            }
        };
    }

        @Nullable
        @Override
        public TileEntity createTileEntity (BlockState state, IBlockReader world){
            return KbnsTileEntities.VIBRANIUM_FORGE_TILE.get().create();
        }

        @Override
        public boolean hasTileEntity (BlockState state){
            return true;
        }




    @Override
    public void tick() {
    }
}