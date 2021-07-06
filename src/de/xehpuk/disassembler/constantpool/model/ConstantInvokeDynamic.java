package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.attribute.BootstrapMethodsTableEntry;
import de.xehpuk.disassembler.constantpool.ConstantPoolEntry;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public class ConstantInvokeDynamic implements ConstantPoolEntry {
	private final BootstrapMethodsTableEntry bootstrapMethodAttr;
	private final ConstantNameAndType nameAndType;

	public ConstantInvokeDynamic(final BootstrapMethodsTableEntry bootstrapMethodAttr, final ConstantNameAndType nameAndType) {
		this.bootstrapMethodAttr = bootstrapMethodAttr;
		this.nameAndType = nameAndType;
	}

	public BootstrapMethodsTableEntry getBootstrapMethodAttr() {
		return bootstrapMethodAttr;
	}

	public ConstantNameAndType getNameAndType() {
		return nameAndType;
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.INVOKE_DYNAMIC;
	}

	@Override
	public String toString() {
		return "ConstantInvokeDynamic{" + "bootstrapMethodAttr=" + bootstrapMethodAttr + ", nameAndType=" + nameAndType + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		nameAndType.dump(0);
		System.out.print('{');
		bootstrapMethodAttr.dump(0);
		System.out.print('}');
	}
}