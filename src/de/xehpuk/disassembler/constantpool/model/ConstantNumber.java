package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.attribute.ElementValue;
import de.xehpuk.disassembler.constantpool.ConstantValueAttributeType;
import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public abstract class ConstantNumber implements ConstantValueAttributeType, ElementValue {
	private final Number bytes;

	protected ConstantNumber(final Number bytes) {
		this.bytes = bytes;
	}

	public Number getBytes() {
		return bytes;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(bytes);
	}
}