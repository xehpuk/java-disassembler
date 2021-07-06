package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;

public class AttributeInnerClasses implements Attribute {
	private final Classes[] classes;

	public AttributeInnerClasses(final Classes[] classes) {
		this.classes = classes;
	}

	public Classes[] getClasses() {
		return classes;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.INNER_CLASSES;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(getName().getName() + ':');
		for (final Classes clazz : classes) {
			clazz.dump(indent + 1);
		}
	}
}