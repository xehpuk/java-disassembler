package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.attribute.ElementValue;
import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constantpool.ConstantValueAttributeType;
import de.xehpuk.disassembler.constants.TypeCharacter;
import de.xehpuk.disassembler.util.Util;

/**
 *
 * @author xehpuk
 */
public class ConstantUtf8 implements ConstantValueAttributeType, ElementValue {
	private final String string;

	public ConstantUtf8(final String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

	@Override
	public String toString() {
		return "ConstantUtf8{" + "string=" + string + '}';
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.UTF8;
	}

	@Override
	public TypeCharacter getType() {
		return TypeCharacter.STRING;
	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.print(string);
	}
}