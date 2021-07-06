package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantFloat;

/**
 *
 * @author xehpuk
 */
public class ConstantFloatBytes extends Constant4ByteBytes {
	public ConstantFloatBytes(final int bytes) {
		super(bytes);
	}

	@Override
	public String toString() {
		return "ConstantFloatInfo{" + "bytes=" + getBytes() + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.FLOAT;
	}

	@Override
	public ConstantFloat convert(final int index, final ConstantPool pool) {
		final float bytes = Float.intBitsToFloat(getBytes());
		final ConstantFloat result = new ConstantFloat(bytes);
		return result;
	}
}