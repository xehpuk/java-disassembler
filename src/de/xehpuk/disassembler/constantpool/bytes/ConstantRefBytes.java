package de.xehpuk.disassembler.constantpool.bytes;

/**
 *
 * @author xehpuk
 */
public abstract class ConstantRefBytes implements ConstantPoolEntryRaw {
	private final int classIndex;
	private final int nameAndTypeIndex;

	protected ConstantRefBytes(final int classIndex, final int nameAndTypeIndex) {
		this.classIndex = classIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	public int getClassIndex() {
		return classIndex;
	}

	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}

	@Override
	public void dump(final int indent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}