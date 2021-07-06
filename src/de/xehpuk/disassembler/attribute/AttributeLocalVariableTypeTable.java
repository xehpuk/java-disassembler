package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;

public class AttributeLocalVariableTypeTable implements Attribute {
	private final LocalVariableTypeTableEntry[] localVariableTypeTable;

	public AttributeLocalVariableTypeTable(final LocalVariableTypeTableEntry[] localVariableTypeTable) {
		this.localVariableTypeTable = localVariableTypeTable;
	}

	public LocalVariableTypeTableEntry[] getLocalVariableTable() {
		return localVariableTypeTable;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.LOCAL_VARIABLE_TYPE_TABLE;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(getName().getName() + ':');
		System.out.println();
		for (final LocalVariableTypeTableEntry localVariableTypeTableEntry : localVariableTypeTable) {
			localVariableTypeTableEntry.dump(indent + 1);
		}
	}
}