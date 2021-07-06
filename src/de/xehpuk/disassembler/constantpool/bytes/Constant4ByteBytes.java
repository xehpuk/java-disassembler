package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantValueAttributeType;

/**
 *
 * @author xehpuk
 */
public abstract class Constant4ByteBytes implements ConstantPoolEntryRaw, ConstantValueAttributeType {
	private final int bytes;

	protected Constant4ByteBytes(final int bytes) {
		this.bytes = bytes;
	}

	public int getBytes() {
		return bytes;
	}

	@Override
	public void dump(final int indent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}