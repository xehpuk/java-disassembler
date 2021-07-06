package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class Swap implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.SWAP;
	}
}