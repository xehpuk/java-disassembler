package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constants.TypeCharacter;

/**
 *
 * @author xehpuk
 */
public class ConstantFloat extends ConstantShortNumber {
	public ConstantFloat(final float bytes) {
		super(bytes);
	}

	@Override
	public String toString() {
		return "ConstantFloat{" + "bytes=" + getBytes() + '}';
	}

	@Override
	public Float getBytes() {
		return super.getBytes().floatValue();
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.FLOAT;
	}

	@Override
	public TypeCharacter getType() {
		return TypeCharacter.FLOAT;
	}
}