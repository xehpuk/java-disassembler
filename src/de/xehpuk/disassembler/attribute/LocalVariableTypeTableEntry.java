package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.Dumpable;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import de.xehpuk.disassembler.util.Util;

public class LocalVariableTypeTableEntry implements Dumpable {
	private final int startPc;
	private final int length;
	private final ConstantUtf8 name;
	private final ConstantUtf8 signature;
	private final int index;

	public LocalVariableTypeTableEntry(final int startPc, final int length,
			final ConstantUtf8 name, final ConstantUtf8 signature, final int index) {
		this.startPc = startPc;
		this.length = length;
		this.name = name;
		this.signature = signature;
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

	public ConstantUtf8 getSignature() {
		return signature;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "LocalVariableTableEntry{" + startPc + ", " + length + ", " + name.getString() + ", " + signature.getString() + ", " + index + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(startPc + ", " + length + ", " + name.getString() + ", " + signature.getString() + ", " + index);
	}
}