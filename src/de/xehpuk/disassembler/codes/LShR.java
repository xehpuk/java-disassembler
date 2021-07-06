package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LShR implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LSHR;
	}
}