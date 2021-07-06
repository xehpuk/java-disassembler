package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantClass;
import de.xehpuk.disassembler.constantpool.model.ConstantMethodref;
import de.xehpuk.disassembler.constantpool.model.ConstantNameAndType;

/**
 *
 * @author xehpuk
 */
public class ConstantMethodrefBytes extends ConstantRefBytes {
	public ConstantMethodrefBytes(final int classIndex, final int nameAndTypeIndex) {
		super(classIndex, nameAndTypeIndex);
	}

	@Override
	public String toString() {
		return "ConstantMethodrefInfo{" + "classIndex=" + getClassIndex() + ", nameAndTypeIndex=" + getNameAndTypeIndex() + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.METHODREF;
	}

	@Override
	public ConstantMethodref convert(final int index, final ConstantPool pool) {
		final ConstantClass clazz = pool.get(getClassIndex(), ConstantClass.class);
		final ConstantNameAndType nameAndType = pool.get(getNameAndTypeIndex(), ConstantNameAndType.class);
		final ConstantMethodref result = new ConstantMethodref(clazz, nameAndType);
		return result;
	}
}