package de.xehpuk.disassembler.attribute.variable;

import de.xehpuk.disassembler.constantpool.model.ConstantClass;

public class ObjectVariable implements VerificationType {
	public static final int TAG = 7;
	private final ConstantClass clazz;

	protected ObjectVariable(final ConstantClass clazz) {
		this.clazz = clazz;
	}

	public ConstantClass getClassIndex() {
		return clazz;
	}

	@Override
	public int getTag() {
		return TAG;
	}
}