package lance5057.tDefense.core.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import lance5057.tDefense.core.blocks.crestMount.TileEntity_CrestMount;
import net.minecraft.tileentity.TileEntity;

public class Handler_CrestMount implements IMessageHandler<Message_CrestMount, IMessage> {
    @Override
    public IMessage onMessage(Message_CrestMount message, MessageContext ctx) {
        final TileEntity te =
                ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);
        if (te instanceof TileEntity_CrestMount) {
            ((TileEntity_CrestMount) te).flip = message.flip;
        }
        return null;
    }
}
