package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constants.TypeCharacter;

/**
 *
 * @author xehpuk
 */
public class ConstantDouble extends ConstantLongNumber {
	public ConstantDouble(final double bytes) {
		super(bytes);
	}

	@Override
	public String toString() {
		return "ConstantDouble{" + "bytes=" + getBytes() + '}';
	}

	@Override
	public Double getBytes() {
		return super.getBytes().doubleValue();
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.DOUBLE;
	}

	@Override
	public TypeCharacter getType() {
		return TypeCharacter.DOUBLE;
	}
}