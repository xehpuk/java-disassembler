package de.xehpuk.disassembler.constantpool.model;

import de.xehpuk.disassembler.constantpool.ConstantTag;
import de.xehpuk.disassembler.constants.TypeCharacter;

/**
 *
 * @author xehpuk
 */
public class ConstantLong extends ConstantLongNumber {
	public ConstantLong(final long bytes) {
		super(bytes);
	}

	@Override
	public String toString() {
		return "ConstantLong{" + "bytes=" + getBytes() + '}';
	}

	@Override
	public Long getBytes() {
		return super.getBytes().longValue();
	}

	@Override
	public ConstantTag getTag() {
		return ConstantTag.LONG;
	}

	@Override
	public TypeCharacter getType() {
		return TypeCharacter.LONG;
	}
}