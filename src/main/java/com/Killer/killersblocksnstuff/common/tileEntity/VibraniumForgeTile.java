package com.Killer.killersblocksnstuff.common.tileEntity;


import com.Killer.killersblocksnstuff.data.recipes.*;
import com.Killer.killersblocksnstuff.util.*;
import net.minecraft.block.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.energy.*;
import net.minecraftforge.items.*;

import javax.annotation.*;
import java.util.*;


public class VibraniumForgeTile extends TileEntity implements ITickableTileEntity {

    private ItemStackHandler itemHandler = createHandler();
    private CustomEnergyStorage energyStorage = createEnergy();
    private int craftTime;
    private float progress;

    // Never create lazy optionals in getCapability. Always place them as fields in the tile entity:
    private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);


    public VibraniumForgeTile(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public VibraniumForgeTile() {
        this(KbnsTileEntities.VIBRANIUM_FORGE_TILE.get());
    }


    @Override
    public void load(BlockState state, CompoundNBT nbt) {

        TileEntity te = level.getBlockEntity(getBlockPos());
        if (te != null) {
            LazyOptional<IEnergyStorage> capability = te.getCapability(CapabilityEnergy.ENERGY);
            capability.ifPresent(handler -> handler.receiveEnergy(200, false));
        }
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        energyStorage.deserializeNBT(nbt.getCompound("energy"));

        super.load(state, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        compound.put("energy", energyStorage.serializeNBT());


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

    private CustomEnergyStorage createEnergy() {
        return new CustomEnergyStorage(20000, 200) {
            @Override
            protected void onEnergyChanged() {
                setChanged();
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        if (cap == CapabilityEnergy.ENERGY) {
            return energy.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
    }

    public void craft() {

        if (KbnsRecipeTypes.FORGE_RECIPE != null) {
            // Process
            craftTime = 100;
            progress += 1;
        }
        if (progress >= craftTime) {


            Inventory inv = new Inventory(itemHandler.getSlots());
            for (int i = 0; i < itemHandler.getSlots(); i++) {
                inv.setItem(i, itemHandler.getStackInSlot(i));
            }
            Optional<VibraniumForgeRecipe> recipe = level.getRecipeManager()
                    .getRecipeFor(KbnsRecipeTypes.FORGE_RECIPE, inv, level);

            recipe.ifPresent(iRecipe -> {
                ItemStack output = iRecipe.getResultItem();


                craftTheItem(output);
                progress = 0;


                setChanged();
            });
        }
    }
    public void craftTheItem(ItemStack output) {
        itemHandler.extractItem(0, 1, false);
        itemHandler.extractItem(1, 1, false);
        itemHandler.insertItem(2, output, false);



    }

    @Override
    public void tick() {

        if (level.isClientSide)
            return;
        craft();
        energyStorage.consumeEnergy(200);

        progress ++ ;
        setChanged();
    }
}



