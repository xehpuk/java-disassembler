package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantPoolEntry;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public class ConstantNameAndType implements ConstantPoolEntry {
	private final ConstantUtf8 name;
	private final ConstantUtf8 descriptor;

	public ConstantNameAndType(final ConstantUtf8 name, final ConstantUtf8 descriptor) {
		this.name = name;
		this.descriptor = descriptor;
	}

	public ConstantUtf8 getName() {
		return name;
	}

	public ConstantUtf8 getDescriptor() {
		return descriptor;
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.NAME_AND_TYPE;
	}

	@Override
	public String toString() {
		return "ConstantNameAndType{" + "name=" + name + ", descriptor=" + descriptor + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		final String descriptorDump = getDescriptor().getString();
		if (Util.field(descriptorDump)) {
			System.out.print(Util.fieldDescriptor(descriptorDump) + ' ');
			name.dump(0);
		} else {
			name.dump(0);
			System.out.print(Util.parameterDescriptor(descriptorDump));
		}
	}
}