package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constants.TypeCharacter;

/**
 *
 * @author xehpuk
 */
public class ConstantInteger extends ConstantShortNumber {
	public ConstantInteger(final int bytes) {
		super(bytes);
	}

	@Override
	public String toString() {
		return "ConstantIntegerInfo{" + "bytes=" + getBytes() + '}';
	}

	@Override
	public Integer getBytes() {
		return super.getBytes().intValue();
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.INTEGER;
	}

	@Override
	public TypeCharacter getType() {
		return TypeCharacter.INT;
	}
}