package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {

    EventLoopGroup worker = new NioEventLoopGroup();

    public static void main(String[] args) {
        EventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(worker).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception{
                ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        String msg = "hello Server!";
                        ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
                        encoded.writeBytes(msg.getBytes());
                        ctx.write(encoded);
                        ctx.flush();
                    }
                });
            }
        }).option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.connect("127.0.0.1",8000);
    }
}
