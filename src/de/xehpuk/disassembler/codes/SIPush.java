package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class SIPush implements Instruction {
	private final short constant;

	public SIPush(final short constant) {
		this.constant = constant;
	}

	public final short getConstant() {
		return constant;
	}

	@Override
	public OpCode getOpCode() {
		return OpCode.SIPUSH;
	}
}