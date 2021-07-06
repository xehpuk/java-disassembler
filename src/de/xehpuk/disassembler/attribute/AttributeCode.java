package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.codes.Instruction;
import de.xehpuk.disassembler.util.Util;
import java.util.List;

public class AttributeCode implements Attribute {
	private final int maxStack;
	private final int maxLocals;
	private final List<Instruction> code;
	private final ExceptionTableEntry[] exceptionTable;
	private final Attribute[] attributes;

	public AttributeCode(final int maxStack, final int maxLocals, final List<Instruction> code,
			final ExceptionTableEntry[] exceptionTable,
			final Attribute[] attributes) {
		this.maxStack = maxStack;
		this.maxLocals = maxLocals;
		this.code = code;
		this.exceptionTable = exceptionTable;
		this.attributes = attributes;
	}

	public int getMaxStack() {
		return maxStack;
	}

	public int getMaxLocals() {
		return maxLocals;
	}

	public List<Instruction> getCode() {
		return code;
	}

	public ExceptionTableEntry[] getExceptionTable() {
		return exceptionTable;
	}

	public Attribute[] getAttributes() {
		return attributes;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.CODE;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(getName().getName() + ':');
		Util.indent(indent + 1);
		System.out.println(maxStack + ", " + maxLocals);
		Util.indent(indent + 1);
		if (!code.isEmpty()) {
			System.out.println("Instructions:");
			for (final Instruction instruction : code) {
				Util.indent(indent + 2);
				System.out.println(instruction.getOpCode());
			}
		}
		if (exceptionTable.length != 0) {
			Util.indent(indent + 1);
			System.out.println("ExceptionTable:");
			for (final ExceptionTableEntry exceptionTableEntry : exceptionTable) {
				exceptionTableEntry.dump(indent + 2);
			}
		}
		for (final Attribute attribute : attributes) {
			attribute.dump(indent + 1);
		}
	}
}