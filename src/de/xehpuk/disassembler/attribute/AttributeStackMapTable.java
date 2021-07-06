package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.attribute.frame.StackMapFrame;
import de.xehpuk.disassembler.util.Util;
import java.util.Arrays;

public class AttributeStackMapTable implements Attribute {
	private final StackMapFrame[] entries;

	public AttributeStackMapTable(final StackMapFrame[] entries) {
		this.entries = entries;
	}

	public StackMapFrame[] getEntries() {
		return entries;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.STACK_MAP_TABLE;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(getName().getName() + '=' + Arrays.toString(entries));
	}
}