package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;
import java.util.Arrays;

public class AttributeSourceDebugExtension implements Attribute {
	private final byte[] bytes;

	public AttributeSourceDebugExtension(final byte[] bytes) {
		this.bytes = bytes;
	}

	public byte[] getBytes() {
		return bytes;
	}

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.SOURCE_DEBUG_EXTENSION;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(getName().getName() + '=' + Arrays.toString(bytes));
	}
}