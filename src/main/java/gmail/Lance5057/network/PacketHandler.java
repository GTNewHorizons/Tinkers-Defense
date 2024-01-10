package gmail.Lance5057.network;

import cpw.mods.fml.relauncher.Side;
import gmail.Lance5057.TinkersDefense;

public class PacketHandler {

    private static int id = 0;

    public static void init() {
        TinkersDefense.INSTANCE.registerMessage(Handler_CrestMount.class, Message_CrestMount.class, id++, Side.SERVER);
    }
}
