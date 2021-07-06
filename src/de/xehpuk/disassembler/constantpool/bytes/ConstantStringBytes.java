package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.ConstantValueAttributeType;
import de.xehpuk.disassembler.constantpool.model.ConstantString;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;

/**
 *
 * @author xehpuk
 */
public class ConstantStringBytes implements ConstantPoolEntryRaw, ConstantValueAttributeType {
	private final int stringIndex;

	public ConstantStringBytes(final int stringIndex) {
		this.stringIndex = stringIndex;
	}

	public int getStringIndex() {
		return stringIndex;
	}

	@Override
	public String toString() {
		return "ConstantStringInfo{" + "stringIndex=" + stringIndex + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.STRING;
	}

	@Override
	public ConstantString convert(final int index, final ConstantPool pool) {
		final ConstantUtf8 string = pool.get(stringIndex, ConstantUtf8.class);
		final ConstantString result = new ConstantString(string);
		return result;
	}

	@Override
	public void dump(final int indent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}