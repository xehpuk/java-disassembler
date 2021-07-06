package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantBootstrapArgumentType;
import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantMethodType;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;

/**
 *
 * @author xehpuk
 */
public class ConstantMethodTypeBytes implements ConstantPoolEntryRaw, ConstantBootstrapArgumentType {
	private final int descriptorIndex;

	public ConstantMethodTypeBytes(final int descriptorIndex) {
		this.descriptorIndex = descriptorIndex;
	}

	public int getDescriptorIndex() {
		return descriptorIndex;
	}

	@Override
	public String toString() {
		return "ConstantMethodTypeInfo{" + "descriptorIndex=" + descriptorIndex + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.METHOD_TYPE;
	}

	@Override
	public ConstantMethodType convert(final int index, final ConstantPool pool) {
		final ConstantUtf8 descriptor = pool.get(descriptorIndex, ConstantUtf8.class);
		final ConstantMethodType result = new ConstantMethodType(descriptor);
		return result;
	}

	@Override
	public void dump(final int indent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}