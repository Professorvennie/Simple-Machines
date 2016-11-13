package com.professorvennie.simplemachines.api.repecies;

import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;

/**
 * Created by snows on 11/11/2016.
 */
public class GrinderRecipe {

    private static final GrinderRecipe INSTANCE = new GrinderRecipe();
    private final Map<ItemStack, ItemStack> grindingList = Maps.<ItemStack, ItemStack>newHashMap();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    private ItemStack input;
    private ItemStack output;
    private float xp;

    public ItemStack getGrindingResult(ItemStack stack) {
        for (Map.Entry<ItemStack, ItemStack> entry : this.grindingList.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2){
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getGrindingList() {
        return this.grindingList;
    }

    public float getGrindingExperience(ItemStack stack) {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;

        for (Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }
        return 0.0F;
    }

    public void addRecipe(ItemStack input, ItemStack output, float xp){
        this.input = input;
        this.output = output;
        this.xp = xp;
        grindingList.put(input, output);
        experienceList.put(output, xp);
    }

    public void addRecipe(ItemStack input, ItemStack output){
        addRecipe(input, output, 0);
    }

    public void addRecipe(Item input, int inAmount, Item output, int outAmount, float xp){
        addRecipe(new ItemStack(input, inAmount), new ItemStack(output, outAmount), xp);
    }

    public void addRecipe(Item input, int inAmount, Item output, int outAmount){
        addRecipe(input, inAmount, output, outAmount, 0);
    }

    public static GrinderRecipe instance(){
        return INSTANCE;
    }
}
