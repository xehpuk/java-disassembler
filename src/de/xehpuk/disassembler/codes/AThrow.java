package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class AThrow implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.ATHROW;
	}
}