package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantTag;

/**
 *
 * @author xehpuk
 */
public class ConstantInterfaceMethodref extends ConstantRef {
	public ConstantInterfaceMethodref(final ConstantClass clazz, final ConstantNameAndType nameAndType) {
		super(clazz, nameAndType);
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.INTERFACE_METHODREF;
	}

	@Override
	public String toString() {
		return "ConstantInterfaceMethodref{" + "class=" + getClazz() + ", nameAndType=" + getNameAndType() + '}';
	}
}