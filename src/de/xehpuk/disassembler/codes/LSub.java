package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LSub implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LSUB;
	}
}