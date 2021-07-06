package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class NewArray implements Instruction {
	private final ArrayType type;

	public NewArray(final ArrayType type) {
		this.type = type;
	}

	public final ArrayType getType() {
		return type;
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.NEWARRAY;
	}
}