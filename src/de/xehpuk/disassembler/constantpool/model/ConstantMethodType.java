package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantPoolEntry;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public class ConstantMethodType implements ConstantPoolEntry {
	private final ConstantUtf8 descriptor;

	public ConstantMethodType(final ConstantUtf8 descriptor) {
		this.descriptor = descriptor;
	}

	public ConstantUtf8 getDescriptor() {
		return descriptor;
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.METHOD_TYPE;
	}

	@Override
	public String toString() {
		return "ConstantMethodType{" + "descriptor=" + descriptor + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		descriptor.dump(0);
	}
}