package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FDiv implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.FDIV;
	}
}