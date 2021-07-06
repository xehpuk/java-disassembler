package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class FMul implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.FMUL;
	}
}