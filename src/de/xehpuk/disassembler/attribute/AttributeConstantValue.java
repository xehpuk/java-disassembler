package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.constantpool.ConstantValueAttributeType;
import de.xehpuk.disassembler.util.Util;

public class AttributeConstantValue implements Attribute {
	public static final int LENGTH = 2;
	private final ConstantValueAttributeType constantValue;

	public AttributeConstantValue(final ConstantValueAttributeType constantValue) {
		this.constantValue = constantValue;
	}

	public ConstantValueAttributeType getConstantValue() {
		return constantValue;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.CONSTANT_VALUE;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(getName().getName() + '=');
		constantValue.dump(0);
		System.out.println();
	}
}