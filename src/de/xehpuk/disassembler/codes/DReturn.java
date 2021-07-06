package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DReturn implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DRETURN;
	}
}