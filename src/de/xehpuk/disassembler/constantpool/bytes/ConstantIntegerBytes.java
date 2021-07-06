package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantInteger;

/**
 *
 * @author xehpuk
 */
public class ConstantIntegerBytes extends Constant4ByteBytes {
	public ConstantIntegerBytes(final int bytes) {
		super(bytes);
	}

	@Override
	public String toString() {
		return "ConstantIntegerInfo{" + "bytes=" + getBytes() + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.INTEGER;
	}

	@Override
	public ConstantInteger convert(final int index, final ConstantPool pool) {
		final int bytes = getBytes();
		final ConstantInteger result = new ConstantInteger(bytes);
		return result;
	}
}