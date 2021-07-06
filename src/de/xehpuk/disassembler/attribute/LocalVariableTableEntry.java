package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.Dumpable;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import de.xehpuk.disassembler.util.Util;

public class LocalVariableTableEntry implements Dumpable {
	private final int startPc;
	private final int length;
	private final ConstantUtf8 name;
	private final ConstantUtf8 descriptor;
	private final int index;

	public LocalVariableTableEntry(final int startPc, final int length,
			final ConstantUtf8 name, final ConstantUtf8 descriptor, final int index) {
		this.startPc = startPc;
		this.length = length;
		this.name = name;
		this.descriptor = descriptor;
		this.index = index;
	}

	public int getStartPc() {
		return startPc;
	}

	public int getLength() {
		return length;
	}

	public ConstantUtf8 getName() {
		return name;
	}

	public ConstantUtf8 getDescriptor() {
		return descriptor;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "LocalVariableTableEntry{" + startPc + ", " + length + ", " + name.getString() + ", " + descriptor.getString() + ", " + index + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(startPc + ", " + length + ", " + name.getString() + ", " + descriptor.getString() + ", " + index);
	}
}