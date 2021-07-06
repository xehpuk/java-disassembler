package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantLong;

/**
 *
 * @author xehpuk
 */
public class ConstantLongBytes extends Constant8ByteBytes {
	public ConstantLongBytes(final int highBytes, final int lowBytes) {
		super(highBytes, lowBytes);
	}

	@Override
	public String toString() {
		return "ConstantLongInfo{" + "highBytes=" + getHighBytes() + ", lowBytes=" + getLowBytes() + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.LONG;
	}

	@Override
	public ConstantLong convert(final int index, final ConstantPool pool) {
		final long bytes = ((long) getHighBytes() << 32) + getLowBytes();
		final ConstantLong result = new ConstantLong(bytes);
		return result;
	}
}