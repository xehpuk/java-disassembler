package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;

public class AttributeLocalVariableTable implements Attribute {
	private final LocalVariableTableEntry[] localVariableTable;

	public AttributeLocalVariableTable(final LocalVariableTableEntry[] localVariableTable) {
		this.localVariableTable = localVariableTable;
	}

	public LocalVariableTableEntry[] getLocalVariableTable() {
		return localVariableTable;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.LOCAL_VARIABLE_TABLE;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(getName().getName() + ':');
		System.out.println();
		for (final LocalVariableTableEntry localVariableTableEntry : localVariableTable) {
			localVariableTableEntry.dump(indent + 1);
		}
	}
}