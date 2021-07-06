package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class IUShR implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.IUSHR;
	}
}