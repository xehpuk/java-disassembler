package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public class AttributeDeprecated implements Attribute {
	public static final int LENGTH = 0;

	@Override
	public RecognizedAttributeName getName() {
		return RecognizedAttributeName.DEPRECATED;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println(getName().getName());
	}
}