package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import de.xehpuk.disassembler.constants.TypeCharacter;

/**
 *
 * @author xehpuk
 */
public class EnumConstValue implements ElementValue {
	private final ConstantUtf8 typeName;
	private final ConstantUtf8 constName;

	public EnumConstValue(final ConstantUtf8 typeName, final ConstantUtf8 constName) {
		this.typeName = typeName;
		this.constName = constName;
	}

	public ConstantUtf8 getTypeName() {
		return typeName;
	}

	public ConstantUtf8 getConstName() {
		return constName;
	}

	@Override
	public TypeCharacter getType() {
		return TypeCharacter.ENUM_CONSTANT;
	}
}