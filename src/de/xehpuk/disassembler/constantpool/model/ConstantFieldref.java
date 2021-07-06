package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantTag;

/**
 *
 * @author xehpuk
 */
public class ConstantFieldref extends ConstantRef {
	public ConstantFieldref(final ConstantClass clazz, final ConstantNameAndType nameAndType) {
		super(clazz, nameAndType);
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.FIELDREF;
	}

	@Override
	public String toString() {
		return "ConstantFieldref{" + "class=" + getClazz() + ", nameAndType=" + getNameAndType() + '}';
	}
}