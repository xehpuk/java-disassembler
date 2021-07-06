package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.constantpool.model.ConstantClass;
import de.xehpuk.disassembler.util.Util;

public class AttributeExceptions implements Attribute {
	private final ConstantClass[] classes;

	public AttributeExceptions(final ConstantClass[] classes) {
		this.classes = classes;
	}

	public ConstantClass[] getClasses() {
		return classes;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.EXCEPTIONS;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(getName().getName() + ':');
		for (final ConstantClass clazz : classes) {
			clazz.dump(indent + 1);
			System.out.println();
		}
	}
}