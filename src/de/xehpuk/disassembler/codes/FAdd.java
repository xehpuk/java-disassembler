package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FAdd implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.FADD;
	}
}