package org.traccar.protocol;

import org.traccar.helper.TestDataManager;
import java.nio.ByteOrder;
import org.jboss.netty.buffer.ChannelBuffers;
import static org.traccar.helper.DecoderVerifier.verify;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class NavigilProtocolDecoderTest {

    @Test
    public void testDecode() throws Exception {

        NavigilProtocolDecoder decoder = new NavigilProtocolDecoder(new TestDataManager(), null, null);

        byte[] buf1 = {0x01,0x00,0x43,0x00,0x04,0x00,0x20,0x00,0x00,0x00,(byte)0xf6,0x02,0x03,0x08,0x02,0x00,(byte)0xe7,(byte)0xcd,0x0f,0x51,0x0c,0x00,0x00,0x00,0x3b,0x00,0x00,0x00,0x00,0x00,0x00,0x00};
        assertNull(decoder.decode(null, null, ChannelBuffers.wrappedBuffer(ByteOrder.LITTLE_ENDIAN, buf1)));

        byte[] buf2 = {0x01,0x00,(byte)0xb3,0x00,0x0f,0x00,0x24,0x00,0x00,0x00,(byte)0xf4,(byte)0xa8,0x03,0x08,0x02,0x00,(byte)0xca,0x0c,0x11,0x51,(byte)0xef,(byte)0x88,(byte)0x85,(byte)0xf0,(byte)0xb8,0x2e,0x6d,0x13,0x04,0x00,(byte)0xc0,0x04,0x03,0x00,0x00,0x00};
        verify(decoder.decode(null, null, ChannelBuffers.wrappedBuffer(ByteOrder.LITTLE_ENDIAN, buf2)));

    }

}
