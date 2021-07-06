package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LRem implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LREM;
	}
}