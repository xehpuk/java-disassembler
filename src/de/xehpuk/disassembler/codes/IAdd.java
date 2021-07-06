package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IAdd implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.IADD;
	}
}