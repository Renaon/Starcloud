package server;


import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.util.ReferenceCountUtil;

public class ConnectionHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private ByteBuf buf;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        if (msg == null) return;
        buf.writeBytes(msg);
        try{
            while(buf.isReadable()){
                System.out.print((char) buf.readByte());
                System.out.flush();
            }
            ctx.writeAndFlush("done");
        } finally{
            ReferenceCountUtil.release(msg);
            ctx.writeAndFlush("something get wrong");
            System.out.println("Something get wrong");
        }
    }
}
