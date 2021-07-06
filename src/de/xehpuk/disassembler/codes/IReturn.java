package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IReturn implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.IRETURN;
	}
}