package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IMul implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.IMUL;
	}
}