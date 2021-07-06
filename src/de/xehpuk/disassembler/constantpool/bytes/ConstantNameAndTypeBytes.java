package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantNameAndType;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;

/**
 *
 * @author xehpuk
 */
public class ConstantNameAndTypeBytes implements ConstantPoolEntryRaw {
	private final int nameIndex;
	private final int descriptorIndex;

	public ConstantNameAndTypeBytes(final int nameIndex, final int descriptorIndex) {
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
	}

	public int getNameIndex() {
		return nameIndex;
	}

	public int getDescriptorIndex() {
		return descriptorIndex;
	}

	@Override
	public String toString() {
		return "ConstantNameAndTypeInfo{" + "nameIndex=" + nameIndex + ", descriptorIndex=" + descriptorIndex + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.NAME_AND_TYPE;
	}

	@Override
	public ConstantNameAndType convert(final int index, final ConstantPool pool) {
		final ConstantUtf8 name = pool.get(nameIndex, ConstantUtf8.class);
		final ConstantUtf8 descriptor = pool.get(descriptorIndex, ConstantUtf8.class);
		final ConstantNameAndType result = new ConstantNameAndType(name, descriptor);
		return result;
	}

	@Override
	public void dump(final int indent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}