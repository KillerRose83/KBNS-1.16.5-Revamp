package com.Killer.killersblocksnstuff.common.tileEntity;

import com.Killer.killersblocksnstuff.container.*;
import com.Killer.killersblocksnstuff.data.recipes.*;
import com.Killer.killersblocksnstuff.util.*;
import net.minecraft.block.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.play.server.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.energy.*;
import net.minecraftforge.items.*;
import net.minecraftforge.items.wrapper.*;

import javax.annotation.*;
import java.sql.*;
import java.util.*;


public class VibraniumForgeTile extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);



    public VibraniumForgeTile(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public  VibraniumForgeTile() {
        this(KbnsTileEntities.VIBRANIUM_FORGE_TILE.get());
    }


    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));

        super.load(state, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());


        return super.save(compound);
    }


    private ItemStackHandler createHandler() {
        return new ItemStackHandler(3) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return true;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
    }

    public void craft() {
        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }
        Optional<VibraniumForgeRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(KbnsRecipeTypes.FORGE_RECIPE, inv, level);

        recipe.ifPresent(iRecipe -> {
            ItemStack output = iRecipe.getResultItem();
                craftTheItem(output);


            setChanged();
        });
    }

    public void craftTheItem(ItemStack output) {
        itemHandler.extractItem(0, 1, false);
        itemHandler.extractItem(1, 1, false);
        itemHandler.insertItem(2, output, false);
    }

    @Override
    public void tick() {
        if(level.isClientSide)
            return;

        craft();
    }

}

