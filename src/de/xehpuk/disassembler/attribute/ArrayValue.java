package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.constants.TypeCharacter;

/**
 *
 * @author xehpuk
 */
public class ArrayValue implements ElementValue {
	private final ElementValue[] values;

	public ArrayValue(final ElementValue[] values) {
		this.values = values;
	}

	public ElementValue[] getValues() {
		return values;
	}

	@Override
	public TypeCharacter getType() {
		return TypeCharacter.ARRAY;
	}
}