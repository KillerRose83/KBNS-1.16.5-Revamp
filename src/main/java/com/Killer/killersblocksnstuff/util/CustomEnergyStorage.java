package com.Killer.killersblocksnstuff.util;

import net.minecraft.nbt.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.energy.*;

public class CustomEnergyStorage extends EnergyStorage implements INBTSerializable<CompoundNBT> {

    public CustomEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }


    protected void onEnergyChanged() {

    }

    public void setEnergy(int energy) {
        this.energy = energy;
        onEnergyChanged();
    }

    public void addEnergy(int energy) {
        this.energy += energy;
        if (this.energy > getMaxEnergyStored()) {
            this.energy = getEnergyStored();
        }
        onEnergyChanged();
    }

    public void consumeEnergy(int energy) {
        this.energy -= energy;
        if (this.energy < 0) {
            this.energy = 0;
        }
        onEnergyChanged();
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("energy", getEnergyStored());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        setEnergy(nbt.getInt("energy"));
    }
}
