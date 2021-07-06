package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.ConstantValueAttributeType;
import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public class ConstantString implements ConstantValueAttributeType {
	private final ConstantUtf8 string;

	public ConstantString(final ConstantUtf8 string) {
		this.string = string;
	}

	public ConstantUtf8 getString() {
		return string;
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.STRING;
	}

	@Override
	public String toString() {
		return "ConstantString{" + "string=" + string + '}';
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print('"' + string.getString() + '"');
	}
}