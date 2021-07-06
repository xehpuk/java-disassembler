package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantPoolEntry;
import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public abstract class ConstantRef implements ConstantPoolEntry {
	private final ConstantClass clazz;
	private final ConstantNameAndType nameAndType;

	protected ConstantRef(final ConstantClass clazz, final ConstantNameAndType nameAndTypeIndex) {
		this.clazz = clazz;
		this.nameAndType = nameAndTypeIndex;
	}

	public ConstantClass getClazz() {
		return clazz;
	}

	public ConstantNameAndType getNameAndType() {
		return nameAndType;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		clazz.dump(0);
		System.out.print('.');
		nameAndType.dump(0);
	}
}