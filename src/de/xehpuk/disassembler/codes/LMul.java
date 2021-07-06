package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LMul implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LMUL;
	}
}