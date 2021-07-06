package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LShL implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LSHL;
	}
}