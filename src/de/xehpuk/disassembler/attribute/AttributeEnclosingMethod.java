package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.constantpool.model.ConstantClass;
import de.xehpuk.disassembler.constantpool.model.ConstantNameAndType;
import de.xehpuk.disassembler.util.Util;

public class AttributeEnclosingMethod implements Attribute {
	public static final int LENGTH = 4;
	private final ConstantClass clazz;
	private final ConstantNameAndType method;

	public AttributeEnclosingMethod(final ConstantClass clazz, final ConstantNameAndType method) {
		this.clazz = clazz;
		this.method = method;
	}

	public ConstantClass getClazz() {
		return clazz;
	}

	public ConstantNameAndType getMethod() {
		return method;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.ENCLOSING_METHOD;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(getName().getName() + '=');
		clazz.dump(0);
		System.out.print('.');
		method.dump(0);
		System.out.println();
	}
}