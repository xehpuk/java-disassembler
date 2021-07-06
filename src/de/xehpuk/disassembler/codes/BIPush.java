package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class BIPush implements ConstantInstruction {
	private final byte constant;

	public BIPush(final byte constant) {
		this.constant = constant;
	}

	@Override
	public final byte getConstant() {
		return constant;
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.BIPUSH;
	}
}