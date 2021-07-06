package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FReturn implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.FRETURN;
	}
}