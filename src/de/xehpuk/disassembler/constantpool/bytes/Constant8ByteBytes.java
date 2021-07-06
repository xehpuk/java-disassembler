package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantValueAttributeType;

/**
 *
 * @author xehpuk
 */
public abstract class Constant8ByteBytes implements ConstantPoolEntryRaw, ConstantValueAttributeType {
	private final int highBytes;
	private final int lowBytes;

	protected Constant8ByteBytes(final int highBytes, final int lowBytes) {
		this.highBytes = highBytes;
		this.lowBytes = lowBytes;
	}

	public int getHighBytes() {
		return highBytes;
	}

	public int getLowBytes() {
		return lowBytes;
	}

	@Override
	public void dump(final int indent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}