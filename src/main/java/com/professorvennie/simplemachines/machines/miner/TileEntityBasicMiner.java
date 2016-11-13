package com.professorvennie.simplemachines.machines.miner;


import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;
import net.minecraft.util.math.BlockPos;

/**
 * Created by snows on 11/4/2016.
 */
public class TileEntityBasicMiner extends TileEntityBasicMachine {

    private int range, progress = 0, speed = 100, x, y, z;

    public TileEntityBasicMiner() {
        super("basicMiner");
        range = 50;
        x = pos.getX();
        y = pos.getY();
        z = pos.getZ();
    }

    @Override
    public void update() {
        super.update();
        progress++;
        /*if (progress == speed) {
            for (int x = pos.getX() + 1; x <= pos.getX() + range; x++) {
                for (int y = pos.getY(); y >= 0; y--) {
                    for (int z = pos.getZ() + 1; z <= pos.getZ() + range; z++) {
                        BlockPos newPos = new BlockPos(x, y, z);
                        System.out.println("X: " + x + " Y: " + y + " Z: " + z);
                            progress = 0;

                        if (worldObj.getBlockState(newPos).getBlock() != null)
                            worldObj.setBlockToAir(newPos);

                    }
                }
            }
        }*/
        if (progress == speed){
            progress = 0;
            x++;
            y--;
            z++;
            System.out.println("X: " + x + " Y: " + y + " Z: " + z);
            if (x - pos.getX() <= pos.getX() + range && y >= 0 && z - pos.getZ() <= pos.getZ() + range){
                System.out.println("X: " + x + " Y: " + y + " Z: " + z);
                BlockPos newPos = new BlockPos(x, y, z);
                System.out.println(worldObj.getBlockState(newPos).getBlock().getUnlocalizedName());
                worldObj.setBlockToAir(newPos);
            }
        }
    }

    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }
}
