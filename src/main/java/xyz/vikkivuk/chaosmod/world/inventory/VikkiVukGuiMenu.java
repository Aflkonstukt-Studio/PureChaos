
package xyz.vikkivuk.chaosmod.world.inventory;

import xyz.vikkivuk.chaosmod.ChaosmodMod;

public class VikkiVukGuiMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {

	public final static HashMap<String, Object> guistate = new HashMap<>();

	public final Level world;
	public final Player entity;
	public int x, y, z;

	private IItemHandler internal;

	private final Map<Integer, Slot> customSlots = new HashMap<>();

	private boolean bound = false;

	public VikkiVukGuiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ChaosmodModMenus.VIKKI_VUK_GUI, id);

		this.entity = inv.player;
		this.world = inv.player.level;

		this.internal = new ItemStackHandler(9);

		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
		}

		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack;
				if (hand == 0)
					itemstack = this.entity.getMainHandItem();
				else
					itemstack = this.entity.getOffhandItem();
				itemstack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					this.internal = capability;
					this.bound = true;
				});
			} else if (extraData.readableBytes() > 1) {
				extraData.readByte(); // drop padding
				Entity entity = world.getEntity(extraData.readVarInt());
				if (entity != null)
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			} else { // might be bound to block
				BlockEntity ent = inv.player != null ? inv.player.level.getBlockEntity(pos) : null;
				if (ent != null) {
					ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
				}
			}
		}

		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 6, 29) {

		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 24, 29) {

		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 42, 29) {

		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 60, 29) {

		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 78, 29) {

		}));
		this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 96, 29) {

		}));
		this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 114, 29) {

		}));
		this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 132, 29) {

		}));
		this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 150, 29) {

		}));

		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 0 + 8 + sj * 18, 0 + 84 + si * 18));

		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 0 + 8 + si * 18, 0 + 142));

	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);

		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();

			if (index < 9) {
				if (!this.moveItemStackTo(itemstack1, 9, this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 9, false)) {
				if (index < 9 + 27) {
					if (!this.moveItemStackTo(itemstack1, 9 + 27, this.slots.size(), true)) {
						return ItemStack.EMPTY;
					}
				} else {
					if (!this.moveItemStackTo(itemstack1, 9, 9 + 27, false)) {
						return ItemStack.EMPTY;
					}
				}
				return ItemStack.EMPTY;
			}

			if (itemstack1.getCount() == 0) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override /* failed to load code for net.minecraft.world.inventory.AbstractContainerMenu */

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);

		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					playerIn.drop(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					playerIn.getInventory().placeItemBackInInventory(internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
				}
			}
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}

}
