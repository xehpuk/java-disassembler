package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;

public class AttributeLineNumberTable implements Attribute {
	private final LineNumberTableEntry[] lineNumberTable;

	public AttributeLineNumberTable(final LineNumberTableEntry[] lineNumberTable) {
		this.lineNumberTable = lineNumberTable;
	}

	public LineNumberTableEntry[] getLineNumberTable() {
		return lineNumberTable;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.LINE_NUMBER_TABLE;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(getName().getName() + ':');
		System.out.println();
		for (final LineNumberTableEntry lineNumberTableEntry : lineNumberTable) {
			lineNumberTableEntry.dump(indent + 1);
		}
	}
}