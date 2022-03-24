package com.Killer.killersblocksnstuff.common.tileEntity;


import com.Killer.killersblocksnstuff.common.Blocks.*;
import com.Killer.killersblocksnstuff.data.recipes.*;
import com.Killer.killersblocksnstuff.util.*;
import net.minecraft.block.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.energy.*;
import net.minecraftforge.items.*;

import javax.annotation.*;
import java.util.*;


public class VibraniumForgeTile extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemHandler = createHandler();

    private final CustomEnergyStorage energyStorage = createEnergy();

    // Never create lazy optionals in getCapability. Always place them as fields in the tile entity:
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
    private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
    public int progress;
    public int clientProgress;
    public int clientEnergy;

    boolean flag;
    private int energyUsePerTick = 10;
    private int energyUsedPerItem = 2000;
    private int delay;


    public VibraniumForgeTile(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public VibraniumForgeTile() {
        this(KbnsTileEntities.VIBRANIUM_FORGE_TILE.get());
    }


    private CustomEnergyStorage createEnergy() {
        return new CustomEnergyStorage(200000, 2000, 0) {
            @Override
            protected void onEnergyChanged() {
                setChanged();
            }

        };
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getClientProgress() {
        return clientProgress;
    }

    public void setClientProgress(int clientProgress) {
        this.clientProgress = clientProgress;
    }

    public int getClientEnergy() {
        return clientEnergy;
    }

    public void setClientEnergy(int clientEnergy) {
        this.clientEnergy = clientEnergy;
    }

    public int getEnergy() {
        return energyStorage.getEnergyStored();
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {

        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        energyStorage.deserializeNBT(nbt.getCompound("energy"));

        super.load(state, nbt);
        this.progress = nbt.getInt("Progress");

    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.put("inv", itemHandler.serializeNBT());
        nbt.put("energy", energyStorage.serializeNBT());
        nbt.putInt("Progress", (int) this.progress);


        return super.save(nbt);
    }


    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        super.onDataPacket(net, packet);
        CompoundNBT nbt = packet.getTag();
        this.progress = nbt.getInt("Progress");
        this.clientEnergy = nbt.getInt("clientEnergy");

    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbt = super.getUpdateTag();
        nbt.putInt("Progress", (int) this.progress);
        nbt.putInt("clientEnergy", (int) this.clientEnergy);
        return nbt;
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

        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }
        Optional<VibraniumForgeRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(KbnsRecipeTypes.FORGE_RECIPE, inv, level);
        flag = false;
        progress--;
        crafting();
        recipe.ifPresent(iRecipe -> {
            ItemStack output = iRecipe.getResultItem();
            //checks if there is a valid recipe in machine
            flag = true;
            if (iRecipe.matches(inv, level)) {
                progress++;
                progress++;
                crafting();

            }
            //checks if the time needed to produce result is equal to the time specified in json recipe
            if (iRecipe.getCraftTime() <= progress) {
                craftTheItem(output);
                flag = false;
                delay = 50;
            }


            setChanged();
        });
    }

    public void craftTheItem(ItemStack output) {
        //inputs and outputs items into different slots
        itemHandler.extractItem(0, 1, false);
        itemHandler.extractItem(1, 1, false);
        itemHandler.insertItem(2, output, false);
        energyStorage.consumeEnergy(energyUsedPerItem);
        progress = 0;
        flag = false;


    }

    @Override
    public void tick() {
        if (level.isClientSide) {
            return;
        }

        //uncomment to allow energy usage when i figure it out
        if(getEnergy() > energyUsedPerItem+energyUsePerTick){
        craft();
        //UNCOMMENT THIS TOO
        }
        delay--;
        crafting();
        energyStorage.consumeEnergy(10);
        setChanged();
    }

    protected void crafting() {
        if (flag) {
            level.setBlock(worldPosition, level.getBlockState(worldPosition).setValue(VibraniumForgeBlock.LIT, true), 3);
        } else if (delay <= 0) {
            level.setBlock(worldPosition, level.getBlockState(worldPosition).setValue(VibraniumForgeBlock.LIT, false), 3);
        }
    }

    protected boolean canOutput() {
        if (itemHandler.getSlotLimit(2)>64) {
            return false;
        } else if (itemHandler.getSlotLimit(2) <= 63) {
            return true;
        }
        return true;
    }
}


