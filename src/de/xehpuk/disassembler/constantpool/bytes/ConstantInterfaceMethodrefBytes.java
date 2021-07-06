package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantClass;
import de.xehpuk.disassembler.constantpool.model.ConstantInterfaceMethodref;
import de.xehpuk.disassembler.constantpool.model.ConstantNameAndType;

/**
 *
 * @author xehpuk
 */
public class ConstantInterfaceMethodrefBytes extends ConstantRefBytes {
	public ConstantInterfaceMethodrefBytes(final int classIndex, final int nameAndTypeIndex) {
		super(classIndex, nameAndTypeIndex);
	}

	@Override
	public String toString() {
		return "ConstantInterfaceMethodrefInfo{" + "classIndex=" + getClassIndex() + ", nameAndTypeIndex=" + getNameAndTypeIndex() + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.INTERFACE_METHODREF;
	}

	@Override
	public ConstantInterfaceMethodref convert(final int index, final ConstantPool pool) {
		final ConstantClass clazz = pool.get(getClassIndex(), ConstantClass.class);
		final ConstantNameAndType nameAndType = pool.get(getNameAndTypeIndex(), ConstantNameAndType.class);
		final ConstantInterfaceMethodref result = new ConstantInterfaceMethodref(clazz, nameAndType);
		return result;
	}
}