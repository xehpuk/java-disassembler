package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LReturn implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LRETURN;
	}
}