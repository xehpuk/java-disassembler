package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LDiv implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LDIV;
	}
}