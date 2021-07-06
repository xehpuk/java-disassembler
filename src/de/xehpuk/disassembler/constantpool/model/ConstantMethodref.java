package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantTag;

/**
 *
 * @author xehpuk
 */
public class ConstantMethodref extends ConstantRef {
	public ConstantMethodref(final ConstantClass clazz, final ConstantNameAndType nameAndType) {
		super(clazz, nameAndType);
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.METHODREF;
	}

	@Override
	public String toString() {
		return "ConstantMethodRef{" + "class=" + getClazz() + ", nameAndType=" + getNameAndType() + '}';
	}
}