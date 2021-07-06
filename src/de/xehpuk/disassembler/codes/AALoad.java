package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class AALoad implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.AALOAD;
	}
}