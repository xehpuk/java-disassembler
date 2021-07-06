package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantBootstrapArgumentType;
import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantClass;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;

/**
 *
 * @author xehpuk
 */
public class ConstantClassBytes implements ConstantPoolEntryRaw, ConstantBootstrapArgumentType {
	private final int nameIndex;

	public ConstantClassBytes(final int nameIndex) {
		this.nameIndex = nameIndex;
	}

	public int getNameIndex() {
		return nameIndex;
	}

	@Override
	public String toString() {
		return "ConstantClassInfo{" + "nameIndex=" + nameIndex + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.CLASS;
	}

	@Override
	public ConstantClass convert(final int index, final ConstantPool pool) {
		final ConstantUtf8 name = pool.get(nameIndex, ConstantUtf8.class);
		final ConstantClass result = new ConstantClass(name);
		return result;
	}

	@Override
	public void dump(final int indent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}