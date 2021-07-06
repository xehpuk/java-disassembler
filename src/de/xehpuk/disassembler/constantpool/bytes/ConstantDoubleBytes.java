package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantDouble;

/**
 *
 * @author xehpuk
 */
public class ConstantDoubleBytes extends Constant8ByteBytes {
	public ConstantDoubleBytes(final int highBytes, final int lowBytes) {
		super(highBytes, lowBytes);
	}

	@Override
	public String toString() {
		return "ConstantDoubleInfo{" + "highBytes=" + getHighBytes() + ", lowBytes=" + getLowBytes() + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.DOUBLE;
	}

	@Override
	public ConstantDouble convert(final int index, final ConstantPool pool) {
		final double bits = Double.longBitsToDouble(((long) getHighBytes() << 32) + getLowBytes());
		final ConstantDouble result = new ConstantDouble(bits);
		return result;
	}
}