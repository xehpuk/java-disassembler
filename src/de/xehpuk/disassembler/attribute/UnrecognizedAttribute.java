package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;

public class UnrecognizedAttribute implements Attribute {
	private final UnrecognizedAttributeName name;

	public UnrecognizedAttribute(final UnrecognizedAttributeName name) {
		this.name = name;
	}

	@Override
	public UnrecognizedAttributeName getName() {
		return name;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println("UnrecognizedAttribute=" + name.getName());
	}
}