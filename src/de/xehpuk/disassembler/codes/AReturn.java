package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class AReturn implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.ARETURN;
	}
}