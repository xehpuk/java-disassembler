package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;

public class AttributeSynthetic implements Attribute {
	public static final int LENGTH = 0;

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.SYNTHETIC;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(getName().getName());
	}
}