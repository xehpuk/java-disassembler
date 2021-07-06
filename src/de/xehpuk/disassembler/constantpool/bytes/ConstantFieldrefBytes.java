package de.xehpuk.disassembler.constantpool.bytes;

import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.model.ConstantClass;
import de.xehpuk.disassembler.constantpool.model.ConstantFieldref;
import de.xehpuk.disassembler.constantpool.model.ConstantNameAndType;

/**
 *
 * @author xehpuk
 */
public class ConstantFieldrefBytes extends ConstantRefBytes {
	public ConstantFieldrefBytes(final int classIndex, final int nameAndTypeIndex) {
		super(classIndex, nameAndTypeIndex);
	}

	@Override
	public String toString() {
		return "ConstantFieldrefInfo{" + "classIndex=" + getClassIndex() + ", nameAndTypeIndex=" + getNameAndTypeIndex() + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.FIELDREF;
	}

	@Override
	public ConstantFieldref convert(final int index, final ConstantPool pool) {
		final ConstantClass clazz = pool.get(getClassIndex(), ConstantClass.class);
		final ConstantNameAndType nameAndType = pool.get(getNameAndTypeIndex(), ConstantNameAndType.class);
		final ConstantFieldref result = new ConstantFieldref(clazz, nameAndType);
		return result;
	}
}