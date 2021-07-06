package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import de.xehpuk.disassembler.util.Util;

public class AttributeSignature implements Attribute {
	public static final int LENGTH = 2;
	private final ConstantUtf8 signature;

	public AttributeSignature(final ConstantUtf8 signature) {
		this.signature = signature;
	}

	public ConstantUtf8 getSignature() {
		return signature;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.SIGNATURE;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(getName().getName() + '=');
		signature.dump(0);
		System.out.println();
	}
}