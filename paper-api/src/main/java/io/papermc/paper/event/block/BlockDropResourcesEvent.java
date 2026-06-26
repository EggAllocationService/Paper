package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import java.util.List;

/**
    Called when a block is about to drop items as a result of being broken

 <p>
    This event will be called once for every block broken, even if multiple blocks are broken simultaneously.
    For example, this event will be called twice when breaking a block with a torch on top.
 </p>
 <p>
    If you do not need the drops of each individual block, use {@link org.bukkit.event.block.BlockBreakEvent}.
 </p>
 */
public class BlockDropResourcesEvent extends BlockEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean cancelled;
    private final List<ItemStack> drops;

    @ApiStatus.Internal
    public BlockDropResourcesEvent(final @NotNull Block block, final List<ItemStack> drops) {
        super(block);
        this.cancelled = false;
        this.drops = drops;
    }

    /**
     * Get the list of items to be dropped
     *
     * <p>
     *     If no items would have been dropped, this list will be empty.
     * </p>
     * @return A mutable list of items to be dropped
     */
    public @NotNull List<ItemStack> getDrops() {
        return drops;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(final boolean cancel) {
        cancelled = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
