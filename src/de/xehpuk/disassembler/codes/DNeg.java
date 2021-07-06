package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class DNeg implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.DNEG;
	}
}