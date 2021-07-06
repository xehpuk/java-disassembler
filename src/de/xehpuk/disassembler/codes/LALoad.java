package de.xehpuk.disassembler.codes;

/**
 *
 * @author xehpuk
 */
public class LALoad implements Instruction {
	@Override
	public OpCode getOpCode() {
		return OpCode.LALOAD;
	}
}